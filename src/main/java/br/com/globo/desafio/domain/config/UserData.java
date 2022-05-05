package br.com.globo.desafio.domain.config;

import br.com.globo.desafio.domain.EntidadeBase;
import br.com.globo.desafio.domain.enums.ProfileEnum;
import br.com.globo.desafio.util.Constants;
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
@Table(schema = Constants.SCHEMA_PUBLIC, name = "user_data")
public class UserData extends EntidadeBase<Long> {

    private static final long serialVersionUID = -9052191466844207045L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile")
    private ProfileEnum profile;

    @NotNull
    @Column(name = "active")
    private boolean active;

    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;
}
