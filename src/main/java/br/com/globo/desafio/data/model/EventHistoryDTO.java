package br.com.globo.desafio.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventHistoryDTO {
    private String typeEvent;
    private Boolean statusEvento;
    private String dataAltercao;
}
