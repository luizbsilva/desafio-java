package br.com.globo.desafio.data.service;

import br.com.globo.desafio.domain.transaction.EventHistory;
import br.com.globo.desafio.domain.transaction.Subscription;

import java.util.List;

public interface EventHistoryService {

    void salvarEventHistory(EventHistory eventHistory);
    List<EventHistory> buscarEventHistoryBySubscription(Subscription subscription);
}
