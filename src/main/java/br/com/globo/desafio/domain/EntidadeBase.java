package br.com.globo.desafio.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class EntidadeBase<ID> implements Serializable {

    private static final long serialVersionUID = 2279373407613957602L;

    public abstract void setId(Long id);

    public abstract void setActive(boolean active);

    public abstract void setCreateDate(LocalDateTime createDate);

    public abstract void setUpdateDate(LocalDateTime updateDate);


}
