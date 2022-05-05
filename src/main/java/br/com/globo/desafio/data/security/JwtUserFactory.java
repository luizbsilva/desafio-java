package br.com.globo.desafio.data.security;

import br.com.globo.desafio.domain.dto.UserDataDTO;
import br.com.globo.desafio.domain.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() {
    }


    public static JwtUser create(UserDataDTO userDataDTO) {
        return new JwtUser(userDataDTO.getCode(), userDataDTO.getEmail(), userDataDTO.getPassword(),
                mapToGrantedAuthorities(userDataDTO.getProfile()));
    }


    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profile) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(profile.toString()));
        return authorities;
    }

}
