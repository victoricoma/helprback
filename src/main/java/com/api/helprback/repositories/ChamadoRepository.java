package com.api.helprback.repositories;

import com.api.helprback.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    Optional<List<Chamado>> findByClienteId(Integer clienteId);

    @Query(value="CALL sps_relatorio_andamento_tecnico_semanal(:idTecnico, CURRENT_DATE())", nativeQuery=true)
    Optional<List<Chamado>> reportByTecnicoChamadoSemanal(Integer idTecnico);

    @Query(value = "Call sps_chamados_ultimos_tres_dias(:idTecnico, CURRENT_DATE())", nativeQuery = true)
    Optional<List<Chamado>> reportByTecnicoUltimosTresDias(Integer idTecnico);

    @Query(value = "CALL sps_relatorio_aberto_tecnico_tres_dias(:idTecnico, CURRENT_DATE())", nativeQuery = true)
    Optional<List<Chamado>> reportByTecnicoChamadosAbertosTresDias(Integer idTecnico);

    @Query(value = "CALL sps_chamado_aberto_cliente(CURRENT_DATE())", nativeQuery = true)
    Optional<List<Chamado>> reportByClienteEmAberto();

    @Query(value = "CALL sps_chamados_urgentes_prioridade_alta_tres_dias(:idTecnico, CURRENT_DATE())", nativeQuery = true)
    Optional<List<Chamado>> reportByChamadosUrgentesUltimosTresDias(Integer idTecnico);

}
