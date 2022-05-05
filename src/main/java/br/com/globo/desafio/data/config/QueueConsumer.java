package br.com.globo.desafio.data.config;
import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.service.TransactionNotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @Autowired
    private TransactionNotificationService transactionNotificationService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) throws BusinessRuleException {
        String message = transactionNotificationService.verificarNotificacaoDeAssinaturaMessage(fileBody);
        System.out.println("Message: " + message);
    }
}
