package br.com.globo.desafio.data.controller.rest.v1;

import br.com.globo.desafio.data.controller.BaseEndPoint;
import br.com.globo.desafio.data.model.NotificacaoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/desafio-globo/rabbit")
@Slf4j
public class RabbitSendController extends BaseEndPoint {

    public RabbitSendController(AmqpTemplate queueSender) {
        this.queueSender = queueSender;
    }

    private final AmqpTemplate queueSender;

    @ApiOperation(value = "Envia dados para a Fila do Rabbit", notes = "Envia dados para a Fila do Rabbit")
    @PostMapping("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String send(@Valid @RequestBody NotificacaoRequest request) throws JsonProcessingException {
        Gson gson = new Gson();
        queueSender.convertAndSend("desafio-java", "routing-desafio-globo",  gson.toJson(request));
        return "ok. done";
    }
}
