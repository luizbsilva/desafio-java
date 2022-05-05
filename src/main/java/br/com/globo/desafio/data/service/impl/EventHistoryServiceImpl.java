package br.com.globo.desafio.data.service.impl;

import br.com.globo.desafio.data.repository.EventHistoryRepository;
import br.com.globo.desafio.data.service.EventHistoryService;
import br.com.globo.desafio.domain.transaction.EventHistory;
import br.com.globo.desafio.domain.transaction.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventHistoryServiceImpl implements EventHistoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionNotificationServiceImpl.class);

    @Autowired
    private EventHistoryRepository repository;


    @Override
    public void salvarEventHistory(EventHistory eventHistory) {
        repository.saveAndFlush(eventHistory);
    }

    @Override
    public List<EventHistory> buscarEventHistoryBySubscription(Subscription subscription) {
        return repository.findBySubscriptionOrderByCreateDateDesc(subscription);
    }
}
