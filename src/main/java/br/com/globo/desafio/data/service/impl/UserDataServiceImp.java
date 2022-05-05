package br.com.globo.desafio.data.service.impl;

import br.com.globo.desafio.data.repository.UserDataRepository;
import br.com.globo.desafio.data.service.UserDataService;
import br.com.globo.desafio.domain.dto.UserDataDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDataServiceImp implements UserDataService {

    @Autowired
    private UserDataRepository userDataMigrationRepository;

    @Override
    public Optional<UserDataDTO> findByEmail(String email) {
        return Optional.ofNullable(userDataMigrationRepository.findByEmail(email));
    }
}
