package br.com.globo.desafio.data.mapper;

import br.com.globo.desafio.data.model.EventHistoryDTO;
import br.com.globo.desafio.domain.transaction.EventHistory;
import br.com.globo.desafio.domain.transaction.Subscription;
import br.com.globo.desafio.util.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventHistoryAdapter {

    public static final String FORMAT_DATE = "dd/MM/yyyy 'at' hh:mm a";

    public static EventHistory converttoEntity(Subscription subscription, String notificationType) {
        EventHistory eventHistory = getEntity(new EventHistory(), subscription, notificationType);
        eventHistory.setActive(Boolean.TRUE);
        eventHistory.setCreateDate(LocalDateTime.now());
        return eventHistory;
    }

    public static EventHistory preencherEventHistory(EventHistory eventHistory, Subscription subscription, String notificationType, Boolean active) {
        EventHistory newEventHistory = getEntity(eventHistory, subscription, notificationType);
        newEventHistory.setActive(active);
        newEventHistory.setUpdateDate(LocalDateTime.now());
        return newEventHistory;
    }

    public static List<EventHistoryDTO> preencherDTO(List<EventHistory> eventsHistory) {
        List<EventHistoryDTO> eventHistoryDTOList = new ArrayList<>();
        eventsHistory.forEach( eventHistory -> eventHistoryDTOList.add(preencherDTO(eventHistory)));
        return eventHistoryDTOList;
    }

    private static EventHistoryDTO preencherDTO(EventHistory eventHistory) {
        EventHistoryDTO eventHistoryDTO = new EventHistoryDTO();
        eventHistoryDTO.setTypeEvent(eventHistory.getTypeEvent());
        eventHistoryDTO.setStatusEvento(eventHistory.isActive());
        eventHistoryDTO.setDataAltercao(DateUtil.localDateTimeToString(eventHistory.getCreateDate(), FORMAT_DATE));
        return eventHistoryDTO;
    }

    private static EventHistory getEntity(EventHistory eventHistory, Subscription subscription, String notificationType) {
        eventHistory.setSubscription(subscription);
        eventHistory.setTypeEvent(notificationType);
        return eventHistory;
    }
}
