package br.com.globo.desafio.data.security.services;

import br.com.globo.desafio.data.security.JwtUserFactory;
import br.com.globo.desafio.data.service.UserDataService;
import br.com.globo.desafio.domain.dto.UserDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDataService userDataService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDataDTO> userData = userDataService.findByEmail(username);
        if (userData.isPresent()) {
            return JwtUserFactory.create(userData.get());
        }
        throw new UsernameNotFoundException("Email não encontrado.");
    }
}
