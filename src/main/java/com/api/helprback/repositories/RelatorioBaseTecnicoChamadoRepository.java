package com.api.helprback.repositories;

import com.api.helprback.domain.RelatorioBaseTecnicoChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RelatorioBaseTecnicoChamadoRepository extends JpaRepository<RelatorioBaseTecnicoChamado,Integer> {
    @Query(value="CALL sps_relatorio_chamados_prioridade_tecnico(:idTecnico)", nativeQuery=true)
    Optional<List<RelatorioBaseTecnicoChamado>> reportCountChamadoTecnicoPrioridade(Integer idTecnico);
}
