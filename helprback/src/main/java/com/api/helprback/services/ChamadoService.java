package com.api.helprback.services;

import com.api.helprback.domain.Chamado;
import com.api.helprback.repositories.ChamadoRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;


    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não existe chamado com ID: "+id));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }
}
