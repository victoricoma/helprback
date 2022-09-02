package com.api.helprback.repositories;

import com.api.helprback.domain.LogUpdateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LogUpdateStatusRepository extends JpaRepository<LogUpdateStatus, Integer> {
    @Query(value="SELECT * FROM log_update_status WHERE dt_alteracao = CURRENT_DATE()", nativeQuery = true)
    Optional<List<LogUpdateStatus>> findLogChamadoStatus();
}
