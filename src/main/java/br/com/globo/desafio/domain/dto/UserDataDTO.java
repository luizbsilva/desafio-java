package br.com.globo.desafio.domain.dto;

import br.com.globo.desafio.domain.config.UserData;
import br.com.globo.desafio.domain.enums.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {
    private Long code;
    private String email;
    private String password;
    private ProfileEnum profile;

    public UserDataDTO(UserData entity) {
        this.code = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.profile = entity.getProfile();
    }
}
