package br.com.globo.desafio.data.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum NotificationTypeEnum implements EnumConverter<String> {
    SUBSCRIPTION_PURCHASED("SUBSCRIPTION_PURCHASED", "Compra Realizada "),
    SUBSCRIPTION_CANCELED("SUBSCRIPTION_CANCELED", "Compra Cancelada"),
    SUBSCRIPTION_RESTARTED("SUBSCRIPTION_RESTARTED", "Compra Recuperada");


    private String codigo;

    private String descricao;

    NotificationTypeEnum(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    public final String getDescricao() {
        return this.descricao;
    }
}
