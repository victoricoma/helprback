package com.api.helprback.resources;

import org.springframework.security.access.prepost.PreAuthorize;
import com.api.helprback.domain.Chamado;
import com.api.helprback.domain.LogChamadoPrioridade;
import com.api.helprback.domain.LogUpdateStatus;
import com.api.helprback.domain.dtos.ChamadoDTO;
import com.api.helprback.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/chamados")
public class ChamadoResource {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
        Chamado obj = this.chamadoService.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }
    @GetMapping
    public ResponseEntity<List<ChamadoDTO>> findAll() {
        List<Chamado> list = chamadoService.findAll();
        List<ChamadoDTO> listDto = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @PreAuthorize("hasAnyRole('ROLE_TECNICO')")
    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDto){
        Chamado obj = chamadoService.create(objDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PreAuthorize("hasAnyRole('ROLE_TECNICO')")
    @PutMapping(value="/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Integer id, @Valid @RequestBody ChamadoDTO objDto){
        Chamado newObj = chamadoService.update(id, objDto);
        return ResponseEntity.ok().body(new ChamadoDTO(newObj));
    }
    @PreAuthorize("hasAnyRole('ROLE_TECNICO')")
    @GetMapping(value = "/report/tecnico/{idTecnico}")
    public ResponseEntity<List<ChamadoDTO>> reportByTecnicoChamadoSemanal(@PathVariable Integer idTecnico){
        List<Chamado> report = chamadoService.reportSemanalChamadosTecnico(idTecnico);
        List<ChamadoDTO> reportDto = report.stream().map(rel -> new ChamadoDTO(rel)).collect(Collectors.toList());
        return ResponseEntity.ok().body(reportDto);
    }
    @PreAuthorize("hasAnyRole('ROLE_TECNICO')")
    @GetMapping(value ="/report/chamados/tecnico/{idTecnico}")
    public ResponseEntity<List<ChamadoDTO>>reportByTecnicoUltimosTresDias(@PathVariable Integer idTecnico){
        List<Chamado> obj = chamadoService.reportByTecnicoUltimosTresDias(idTecnico);
        List<ChamadoDTO> reportObj = obj.stream().map(x -> new ChamadoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(reportObj);
    }

    @GetMapping(value = "/report/aberto/{idTecnico}")
    public ResponseEntity<List<ChamadoDTO>> reportByTecnicoChamadosAbertosTresDias(@PathVariable Integer idTecnico){
        List<Chamado> report = chamadoService.reportTresDiasChamadosAbertosTecnico(idTecnico);
        List<ChamadoDTO> reportDto = report.stream().map(rel -> new ChamadoDTO(rel)).collect(Collectors.toList());
        return ResponseEntity.ok().body(reportDto);
    }

    @GetMapping(value = "/report/urgentes/{idTecnico}")
    public ResponseEntity<List<ChamadoDTO>>reportByChamadosUrgentesUltimosTresDias(@PathVariable Integer idTecnico){
        List<Chamado> list = chamadoService.reportByChamadosUrgentesUltimosTresDias(idTecnico);
        List<ChamadoDTO> listDto = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/log/status")
    public ResponseEntity<List<LogUpdateStatus>> findAllStatusLog() {
        List<LogUpdateStatus> log = chamadoService.logChamadoStatus();
        return ResponseEntity.ok().body(log);
    }

    @GetMapping(value = "/cliente/{clienteId}")
    public ResponseEntity<List<ChamadoDTO>> findByClienteId(@PathVariable Integer clienteId) {
        List<Chamado> obj = chamadoService.findByClienteId(clienteId);
        List<ChamadoDTO> objDto = obj.stream().map(rel -> new ChamadoDTO(rel)).collect(Collectors.toList());
        return ResponseEntity.ok().body(objDto);
    }
    @PreAuthorize("hasAnyRole('ROLE_TECNICO')")
    @GetMapping(value= "/report/chamados/cliente")
    public  ResponseEntity<List<ChamadoDTO>> reportByClienteEmAberto(){
        List<Chamado> obj = chamadoService.reportByClienteEmAberto();
        List<ChamadoDTO> reportObj = obj.stream().map(x-> new ChamadoDTO(x)). collect(Collectors.toList());
        return ResponseEntity.ok().body(reportObj);
    }

    @GetMapping(value = "/log/prioridade")
        public ResponseEntity<List<LogChamadoPrioridade>> findLogPrioridadeChamado(){
        List<LogChamadoPrioridade> logList = chamadoService.findDiaLogChamado();
        return ResponseEntity.ok().body(logList);
    }
}
