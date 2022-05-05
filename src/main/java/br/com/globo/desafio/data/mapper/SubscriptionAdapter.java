package br.com.globo.desafio.data.mapper;

import br.com.globo.desafio.data.model.EventHistoryDTO;
import br.com.globo.desafio.data.model.SubscriptionEventDTO;
import br.com.globo.desafio.data.model.enums.StatusEnum;
import br.com.globo.desafio.domain.transaction.Subscription;

import java.time.LocalDateTime;
import java.util.List;

public class SubscriptionAdapter {

    public static Subscription converttoEntity(String code, StatusEnum statusEnum) {
        Subscription subscription = getEntity(new Subscription(), code, statusEnum);
        subscription.setActive(Boolean.TRUE);
        subscription.setCreateDate(LocalDateTime.now());
        return subscription;
    }

    public static Subscription preencherSubscription(Subscription subscription, StatusEnum statusEnum, String code) {
        Subscription newSubscription = getEntity(subscription, code, statusEnum);
        newSubscription.setUpdateDate(LocalDateTime.now());
        return newSubscription;
    }

    public static SubscriptionEventDTO preencherDTO(Subscription subscription, List<EventHistoryDTO> eventHistoryDTOS) {
        SubscriptionEventDTO subscriptionEventDTO = new SubscriptionEventDTO();
        subscriptionEventDTO.setCode(subscription.getCode());
        subscriptionEventDTO.setStatusEnum(subscription.getStatus());
        subscriptionEventDTO.setEventHistory(eventHistoryDTOS);
        return subscriptionEventDTO;
    }

    private static Subscription getEntity(Subscription subscription, String code, StatusEnum statusEnum) {
        subscription.setCode(code);
        subscription.setStatus(statusEnum);
        return subscription;
    }
}
