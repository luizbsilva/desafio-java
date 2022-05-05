package br.com.globo.desafio.data.service.impl;

import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.i18n.MessageI18N;
import br.com.globo.desafio.data.mapper.EventHistoryAdapter;
import br.com.globo.desafio.data.mapper.SubscriptionAdapter;
import br.com.globo.desafio.data.model.NotificacaoRequest;
import br.com.globo.desafio.data.model.NotificationDTO;
import br.com.globo.desafio.data.model.SubscriptionEventDTO;
import br.com.globo.desafio.data.model.enums.EnumConverter;
import br.com.globo.desafio.data.model.enums.NotificationTypeEnum;
import br.com.globo.desafio.data.model.enums.StatusEnum;
import br.com.globo.desafio.data.service.EventHistoryService;
import br.com.globo.desafio.data.service.SubscriptionService;
import br.com.globo.desafio.data.service.TransactionNotificationService;
import br.com.globo.desafio.domain.transaction.EventHistory;
import br.com.globo.desafio.domain.transaction.Subscription;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionNotificationServiceImpl implements TransactionNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionNotificationServiceImpl.class);

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private EventHistoryService eventHistoryService;

    @Override
    public NotificationDTO verificarNotificacaoDeAssinatura(NotificacaoRequest request) throws BusinessRuleException {
        try {
            LOGGER.debug("Validando Notificacao de Assinatura: {}", request.getNotification_type());

            if (NotificationTypeEnum.SUBSCRIPTION_PURCHASED.equals(EnumConverter.lookup(NotificationTypeEnum.class, request.getNotification_type()))) {
                Subscription subscription = SubscriptionAdapter.converttoEntity(request.getSubscription(), StatusEnum.PURCHASED);
                salvarDados(subscription, request.getNotification_type());
                return new NotificationDTO(EnumConverter.lookup(NotificationTypeEnum.class, request.getNotification_type()), NotificationTypeEnum.SUBSCRIPTION_PURCHASED.getDescricao());
            }
            NotificationDTO notificationDTO = salvarDadosDeNotificacao(request);
            LOGGER.debug("Finalizado Notificacao de Assinatura: {}", request.getNotification_type());
            return notificationDTO;
        } catch (Exception e) {
            LOGGER.error("Error ao Validar Notificação de assinatura: {}, {}", request.getNotification_type(), e.toString());
            throw new BusinessRuleException(MessageI18N.getKey("general.fail.notification"));
        }
    }

    @Override
    public String verificarNotificacaoDeAssinaturaMessage(String request) throws BusinessRuleException {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(request);// response will be the json String
        NotificacaoRequest notificacaoRequest = gson.fromJson(object, NotificacaoRequest.class);
        NotificationDTO notificationDTO = verificarNotificacaoDeAssinatura(notificacaoRequest);
        StringBuilder notification = new StringBuilder();
        notification.append("statusNotification: ")
                .append(notificationDTO.getStatusNotification().toString())
                .append(", eventHistory: ").append(notificationDTO.getEventHistory());
        return notification.toString();
    }

    private NotificationDTO salvarDadosDeNotificacao(NotificacaoRequest request) {
        Subscription subscription = subscriptionService.validarSubscription(request.getSubscription());
        Subscription newSubscription = SubscriptionAdapter.preencherSubscription(subscription, validarStatus(EnumConverter.lookup(NotificationTypeEnum.class, request.getNotification_type())), request.getSubscription());
        salvarDados(newSubscription, request.getNotification_type());
        return new NotificationDTO(EnumConverter.lookup(NotificationTypeEnum.class, request.getNotification_type()), NotificationTypeEnum.SUBSCRIPTION_RESTARTED.getDescricao());
    }

    private StatusEnum validarStatus(NotificationTypeEnum notificationType) {
        return NotificationTypeEnum.SUBSCRIPTION_RESTARTED.equals(notificationType) ? StatusEnum.RESTARTED : StatusEnum.CANCELED;
    }

    private void salvarDados(Subscription subscription, String notificationType) {
        subscriptionService.salvarSubscription(subscription);
        eventHistoryService.salvarEventHistory(EventHistoryAdapter.converttoEntity(subscription, notificationType));
    }

    @Override
    public SubscriptionEventDTO consultarDadosSubscription(String codeSubscription) throws BusinessRuleException {
        Subscription subscription = subscriptionService.validarSubscription(codeSubscription);
        if (Objects.isNull(subscription)) {
            LOGGER.debug("O Subscription consta nos registro: {}", codeSubscription);
            throw new BusinessRuleException("O Subscription consta nos registro.");
        }
        List<EventHistory> eventHistoryList = eventHistoryService.buscarEventHistoryBySubscription(subscription);
        return SubscriptionAdapter.preencherDTO(subscription, EventHistoryAdapter.preencherDTO(eventHistoryList));
    }
}
