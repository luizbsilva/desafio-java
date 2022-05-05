package br.com.globo.desafio.data.model;

import br.com.globo.desafio.data.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEventDTO {
    private String code;
    private StatusEnum statusEnum;
    private List<EventHistoryDTO> eventHistory;
}
