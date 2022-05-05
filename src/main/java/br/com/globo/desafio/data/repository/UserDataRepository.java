package br.com.globo.desafio.data.repository;

import br.com.globo.desafio.domain.config.UserData;
import br.com.globo.desafio.domain.dto.UserDataDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>, JpaSpecificationExecutor<UserData> {
    UserDataDTO findByEmail(String email);
}

