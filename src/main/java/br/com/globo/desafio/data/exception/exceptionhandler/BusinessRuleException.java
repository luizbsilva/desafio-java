package br.com.globo.desafio.data.exception.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties({"message", "suppressed", "localizedMessage", "cause", "stackTrace"})
@Getter
public class BusinessRuleException extends Exception {

    private List<String> mensagens;

    public static BusinessRuleException build() {
        return new BusinessRuleException();
    }

    public static BusinessRuleException build(String mensagem) {
        return build().addMesage(mensagem);
    }

    public static BusinessRuleException build(Collection<String> mensagens) {
        return build().addMessages(mensagens);
    }

    public BusinessRuleException() {
        super("Business Rule Exception");
        mensagens = new ArrayList<>();
    }

    public BusinessRuleException(String mensagem) {
        this();
        addMesage(mensagem);
    }

    public BusinessRuleException addMesage(String mensagem) {
        mensagens.add(mensagem);
        return this;
    }

    public BusinessRuleException addMessages(Collection<String> mensagens) {
        this.mensagens.addAll(mensagens);
        return this;
    }

    public String getLineSeparatedMessages() {
        return mensagens.stream().reduce("", (valorReduzido, valor) -> valorReduzido + valor + "\n");
    }

    public void toThrow() throws BusinessRuleException {
        if (!mensagens.isEmpty()) {
            throw this;
        }
    }
}
