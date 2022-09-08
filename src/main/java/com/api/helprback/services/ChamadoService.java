package com.api.helprback.services;

import com.api.helprback.domain.*;
import com.api.helprback.domain.dtos.ChamadoDTO;
import com.api.helprback.domain.enums.Prioridade;
import com.api.helprback.domain.enums.Status;
import com.api.helprback.repositories.ChamadoRepository;
import com.api.helprback.repositories.LogChamadoPrioridadeRepository;
import com.api.helprback.repositories.LogUpdateStatusRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private LogUpdateStatusRepository statusRepository;

    @Autowired
    private LogChamadoPrioridadeRepository logChamadoRepository;


    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existe chamado com ID: "+id));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO objDto) {
        objDto.setId(null);
        return repository.save(newChamado(objDto));
    }
    public Chamado update(Integer id, ChamadoDTO objDto) {
        objDto.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDto);
        return repository.save(oldObj);        
    }

    public List<LogChamadoPrioridade> findDiaLogChamado() {
        Optional<List<LogChamadoPrioridade>> obj = logChamadoRepository.findLogChamadoPrioridadeDia();
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existem Logs de Prioridades no momento."));
    }


    private Chamado newChamado(ChamadoDTO obj){
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null){
            chamado.setId(obj.getId());
        }
        if (obj.getStatus().equals(2)){
            chamado.setDataFechamento(LocalDate.now());
        }
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());

        return chamado;
    }

    public List<Chamado> reportSemanalChamadosTecnico(Integer idTecnico) {
        Optional<List<Chamado>> obj = repository.reportByTecnicoChamadoSemanal(idTecnico);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existem chamados neste semana para:"+idTecnico));
    }

    public List<Chamado> reportByTecnicoUltimosTresDias(Integer idTecnico) {
    Optional<List<Chamado>> obj = repository.reportByTecnicoUltimosTresDias(idTecnico);
    return obj.orElseThrow(()-> new ObjectNotFoundException(("Não existe chamado nos ultimos três dias.")));
    }

    public List<Chamado> reportTresDiasChamadosAbertosTecnico(Integer idTecnico) {
        Optional<List<Chamado>> obj = repository.reportByTecnicoChamadosAbertosTresDias(idTecnico);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existem chamados abertos nos últimos três dias para: " + idTecnico));
    }

    public List<LogUpdateStatus> logChamadoStatus() {
        Optional<List<LogUpdateStatus>> obj = statusRepository.findLogChamadoStatus();
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existem logs de status disponíveis no momento."));
    }

    public List<Chamado> findByClienteId(Integer clienteId) {
        Optional<List<Chamado>> obj = repository.findByClienteId(clienteId);
        return  obj.orElseThrow(() -> new ObjectNotFoundException("Não existem chamados para este id no momento."));
    }

    public List<Chamado> reportByClienteEmAberto() {
        Optional<List<Chamado>> obj = repository.reportByClienteEmAberto();
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existem clientes com chamados em aberto."));
    }

    public List<Chamado> reportByChamadosUrgentesUltimosTresDias(Integer idTecnico) {
        Optional<List<Chamado>> obj = repository.reportByChamadosUrgentesUltimosTresDias(idTecnico);
        return obj.orElseThrow(()-> new ObjectNotFoundException(("Não existem chamados urgentes nos últimos três dias")));
    }
    
    public List<Chamado> reportClienteChamados(Integer idCliente) {
        Optional<List<Chamado>> obj = repository.findByClienteId(idCliente);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Lista de clientes logado:"+idCliente));
    }
}
