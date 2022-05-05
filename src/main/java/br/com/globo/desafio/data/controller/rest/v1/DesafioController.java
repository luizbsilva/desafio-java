package br.com.globo.desafio.data.controller.rest.v1;

import br.com.globo.desafio.data.controller.BaseEndPoint;
import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import br.com.globo.desafio.data.model.NotificacaoRequest;
import br.com.globo.desafio.data.service.TransactionNotificationService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value = "/desafio-globo/notificacao")
@AllArgsConstructor
@Slf4j
public class DesafioController extends BaseEndPoint {

    @Autowired
    private TransactionNotificationService service;

    @ApiOperation(value = "Dados de Notificação de assinaturas", notes = "Valida os tipos de requisições de assinaturas")
    @PostMapping("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificarNotificacaoDeAssinatura(@Valid @RequestBody NotificacaoRequest request) throws BusinessRuleException {
        return Response.ok(service.verificarNotificacaoDeAssinatura(request)).build();
    }

    @ApiOperation(value = "Consulta Dados por um codigo de Subscription", notes = "Consulta Dados por um codigo de Subscription")
    @GetMapping("/{subscription}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response migrationTransacionByToken(@PathVariable String subscription) throws BusinessRuleException {
        return Response.ok(service.consultarDadosSubscription(subscription)).build();
    }
}
