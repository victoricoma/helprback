package com.api.helprback.services;

import com.api.helprback.domain.Chamado;
import com.api.helprback.domain.dtos.ChamadoDTO;
import com.api.helprback.repositories.ChamadoRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;
    private Function<? super ChamadoDTO,?> obj;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("O chamado não existe em nosso sistema."));
    }

    public List<Chamado> findAll() {return repository.findAll();}
}
