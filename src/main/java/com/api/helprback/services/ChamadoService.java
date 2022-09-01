package com.api.helprback.services;

import com.api.helprback.domain.Chamado;
import com.api.helprback.domain.Cliente;
import com.api.helprback.domain.Tecnico;
import com.api.helprback.domain.dtos.ChamadoDTO;
import com.api.helprback.domain.enums.Prioridade;
import com.api.helprback.domain.enums.Status;
import com.api.helprback.repositories.ChamadoRepository;
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
}
