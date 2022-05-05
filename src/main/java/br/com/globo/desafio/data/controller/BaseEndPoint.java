package br.com.globo.desafio.data.controller;

import br.com.globo.desafio.data.exception.exceptionhandler.BusinessRuleException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BaseEndPoint {

    @Autowired
    private HttpServletRequest request;

    public Response fromResponseDeBusinessRuleException(BusinessRuleException e) {
        return fromResponseDeBusinessRuleException(Response.Status.BAD_REQUEST, e);
    }

    public Response fromResponseDeBusinessRuleException(Response.Status status, BusinessRuleException e) {
        return Response.status(status).entity(e).type(MediaType.APPLICATION_JSON).build();
    }

    public HttpServletRequest getRequest() {
        return request;
    }


}
