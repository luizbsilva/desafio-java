package br.com.globo.desafio.data.service;

import br.com.globo.desafio.domain.dto.UserDataDTO;

import java.util.Optional;


public interface UserDataService {
    Optional<UserDataDTO> findByEmail(String email);
}
