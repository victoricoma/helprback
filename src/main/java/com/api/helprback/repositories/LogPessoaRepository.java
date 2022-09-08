package com.api.helprback.repositories;

import com.api.helprback.domain.LogPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogPessoaRepository extends JpaRepository<LogPessoa, Integer> {
    @Query(value = "CALL sps_relatorio_pessoa_perfil()", nativeQuery = true)
    List<LogPessoa> FindAll();
}