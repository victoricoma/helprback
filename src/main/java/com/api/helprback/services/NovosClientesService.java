package com.api.helprback.services;

import com.api.helprback.domain.NovosClientes;
import com.api.helprback.domain.dtos.NovosClientesDTO;
import com.api.helprback.repositories.NovosClientesRopository;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovosClientesService {

    @Autowired
    private NovosClientesRopository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public NovosClientes findById(Integer id) {
        Optional<NovosClientes> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Incontrado com id!:" + id));
    }

    public List<NovosClientes> findAll() {
        return repository.findAll();
    }

    public NovosClientes create(NovosClientesDTO objDto) {
        objDto.setId(null);
        NovosClientes newObj = new NovosClientes(objDto);
        return repository.save(newObj);
    }

    public NovosClientes update(Integer id, NovosClientesDTO objDto) {
        objDto.setId(id);
        NovosClientes oldObj = findById(id);
        oldObj = new NovosClientes(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        NovosClientes obj = findById(id);
        repository.deleteById(id);
    }
}

