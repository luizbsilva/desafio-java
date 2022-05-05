package br.com.globo.desafio.data.service;

import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.model.NotificacaoRequest;
import br.com.globo.desafio.data.model.NotificationDTO;
import br.com.globo.desafio.domain.transaction.Subscription;

public interface SubscriptionService {

    Subscription validarSubscription(String subscription);
    void salvarSubscription(Subscription subscription);
}
