package br.com.globo.desafio.data.service;

import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.model.NotificacaoRequest;
import br.com.globo.desafio.data.model.NotificationDTO;
import br.com.globo.desafio.data.model.SubscriptionEventDTO;

public interface TransactionNotificationService {

    NotificationDTO verificarNotificacaoDeAssinatura(NotificacaoRequest request) throws BusinessRuleException;
    String verificarNotificacaoDeAssinaturaMessage(String request) throws BusinessRuleException;
    SubscriptionEventDTO consultarDadosSubscription(String Subscription) throws BusinessRuleException;
}
