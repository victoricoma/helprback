package com.api.helprback.services;

import com.api.helprback.domain.RelatorioBaseTecnicoChamado;
import com.api.helprback.repositories.RelatorioBaseTecnicoChamadoRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RelatorioBaseTecnicoChamadoService {
    @Autowired
    private RelatorioBaseTecnicoChamadoRepository relatorioBaseTecnicoChamadoRepository;
    public List<RelatorioBaseTecnicoChamado> reportByTecnicoOrderByPrioridade(Integer id) {
        Optional<List<RelatorioBaseTecnicoChamado>> reportServicePrioridade = relatorioBaseTecnicoChamadoRepository.reportCountChamadoTecnicoPrioridade(id);
        return reportServicePrioridade.orElseThrow(() -> new ObjectNotFoundException("Sem relatorios para o técnico:" + id));
    }
    public List<RelatorioBaseTecnicoChamado> reportByTecnicoGroupByStatus(Integer id) {
        Optional<List<RelatorioBaseTecnicoChamado>> reportServiceStatus = relatorioBaseTecnicoChamadoRepository.reportCountChamadoTecnicoStatus(id);
        return reportServiceStatus.orElseThrow(() -> new ObjectNotFoundException("Sem relatorios para o técnico: " + id));
    }
}
