package com.api.helprback.services;

import com.api.helprback.domain.FuturosClientes;
import com.api.helprback.domain.dtos.FuturosClientesDTO;
import com.api.helprback.repositories.FuturosClientesRepository;
import com.api.helprback.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.helprback.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class FuturosClientesService {

    @Autowired
    private FuturosClientesRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public FuturosClientes findById(Integer id){
        Optional<FuturosClientes> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com Id!:" +id));
    }

    public List<FuturosClientes> findAll(){
        return repository.findAll();
    }

    public FuturosClientes create(FuturosClientesDTO objDto){
        objDto.setId(null);
        FuturosClientes newObj = new FuturosClientes(objDto);
        return repository.save(newObj);
    }

    public FuturosClientes update(Integer id, FuturosClientesDTO objDto){
        objDto.setId(id);
        FuturosClientes oldObj = findById(id);
        oldObj = new FuturosClientes(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id){
        FuturosClientes obj = findById(id);
       repository.deleteById(id);
    }



}
