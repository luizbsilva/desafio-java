package br.com.globo.desafio.domain.transaction;

import br.com.globo.desafio.domain.EntidadeBase;
import br.com.globo.desafio.util.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(schema = Constants.SCHEMA_PUBLIC, name = "event_history")
public class EventHistory extends EntidadeBase<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_event")
    private String typeEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subscription")
    private Subscription subscription;

    @NotNull
    @Column(name = "active")
    private boolean active;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;

}
