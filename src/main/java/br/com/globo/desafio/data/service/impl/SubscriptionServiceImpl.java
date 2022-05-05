package br.com.globo.desafio.data.service.impl;

import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.repository.SubscriptionRepository;
import br.com.globo.desafio.data.service.SubscriptionService;
import br.com.globo.desafio.domain.transaction.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionNotificationServiceImpl.class);

    @Autowired
    private SubscriptionRepository repository;

    @Override
    public Subscription validarSubscription(String subscription) {
        LOGGER.debug("Buscando dados de Subscription : {}", subscription);
        Optional<Subscription> subscriptionOptional = repository.findByCode(subscription);
        if (subscriptionOptional.isPresent()) {
            return subscriptionOptional.get();
        }
        return null;
    }

    @Override
    public void salvarSubscription(Subscription subscription) {
        repository.saveAndFlush(subscription);
    }
}
