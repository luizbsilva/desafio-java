package br.com.globo.desafio.data.model;

import br.com.globo.desafio.data.model.enums.NotificationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private NotificationTypeEnum statusNotification;
    private String eventHistory;
}
