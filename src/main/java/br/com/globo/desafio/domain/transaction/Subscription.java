package br.com.globo.desafio.domain.transaction;

import br.com.globo.desafio.data.model.enums.StatusEnum;
import br.com.globo.desafio.domain.EntidadeBase;
import br.com.globo.desafio.util.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(schema = Constants.SCHEMA_PUBLIC, name = "subscription")
public class Subscription extends EntidadeBase<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_subscription")
    private String code;

    @Column(name = "status")
    private StatusEnum status;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscription")
    private List<EventHistory> eventHistoryList;

    @NotNull
    @Column(name = "active")
    private boolean active;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;

}
