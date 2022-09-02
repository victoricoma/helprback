package com.api.helprback.repositories;

import com.api.helprback.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    @Query(value="CALL sps_relatorio_andamento_tecnico_semanal(:idTecnico, CURRENT_DATE())", nativeQuery=true)
    Optional<List<Chamado>> reportByTecnicoChamadoSemanal(Integer idTecnico);

    @Query(value = "Call sps_chamados_ultimos_tres_dias(:idTecnico, CURRENT_DATE())", nativeQuery = true)
    Optional<List<Chamado>> reportByTecnicoUltimosTresDias(Integer idTecnico);
}
