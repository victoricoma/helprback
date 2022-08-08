package com.api.helprback.repositories;

import com.api.helprback.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

      Optional<Pessoa> findByCpf(String cpf);
}

