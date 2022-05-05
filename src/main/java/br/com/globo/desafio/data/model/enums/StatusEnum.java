package br.com.globo.desafio.data.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum StatusEnum implements EnumConverter<Integer> {
    PURCHASED(1, "Realizada "),
    CANCELED(2, "Cancelada"),
    RESTARTED(3, "Recuperada");


    private Integer codigo;

    private String descricao;

    StatusEnum(final Integer codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Override
    public Integer getCodigo() {
        return this.codigo;
    }

    public final String getDescricao() {
        return this.descricao;
    }
}
