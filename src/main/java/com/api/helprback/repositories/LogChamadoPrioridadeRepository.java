package com.api.helprback.repositories;

import com.api.helprback.domain.LogChamadoPrioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LogChamadoPrioridadeRepository extends JpaRepository<LogChamadoPrioridade, Integer> {
    @Query(value = "SELECT * FROM log_chamado_prioridade WHERE dt_alteracao=CURRENT_DATE()", nativeQuery = true)
    Optional<List<LogChamadoPrioridade>> findLogChamadoPrioridadeDia();
}

