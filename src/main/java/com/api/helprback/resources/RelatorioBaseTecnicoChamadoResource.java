package com.api.helprback.resources;

import com.api.helprback.domain.RelatorioBaseTecnicoChamado;
import com.api.helprback.services.RelatorioBaseTecnicoChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/relatorios")

public class RelatorioBaseTecnicoChamadoResource {
    @Autowired
    private RelatorioBaseTecnicoChamadoService relatorioBaseTecnicoChamadoService;
    @GetMapping(value = "/contagem/prioridade/{idCountPrioridade}")
    public ResponseEntity<List<RelatorioBaseTecnicoChamado>> countTecnicoChamadoPrioridadeId(@PathVariable Integer idCountPrioridade){
        List<RelatorioBaseTecnicoChamado> reportResourcePrioridade = relatorioBaseTecnicoChamadoService.reportByTecnicoOrderByPrioridade(idCountPrioridade);
        return ResponseEntity.ok().body(reportResourcePrioridade);
    }
    @GetMapping(value = "/contagem/status/{idCountStatus}")
    public ResponseEntity<List<RelatorioBaseTecnicoChamado>> countTecnicoChamadoStatusId(@PathVariable Integer idCountStatus){
        List<RelatorioBaseTecnicoChamado> reportResourceStatus = relatorioBaseTecnicoChamadoService.reportByTecnicoGroupByStatus(idCountStatus);
        return ResponseEntity.ok().body(reportResourceStatus);
    }
}
