package br.com.globo.desafio.data.repository;

import br.com.globo.desafio.domain.transaction.EventHistory;
import br.com.globo.desafio.domain.transaction.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistory, Long>, JpaSpecificationExecutor<EventHistory> {

    List<EventHistory> findBySubscriptionOrderByCreateDateDesc(Subscription subscription);
}

