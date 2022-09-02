package com.api.helprback.services;

import com.api.helprback.domain.FuturosCandidatos;
import com.api.helprback.domain.dtos.FuturosCandidatosDTO;
import com.api.helprback.repositories.FuturosCandidatosRepository;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuturosCandidatosService {

    @Autowired
    private FuturosCandidatosRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public FuturosCandidatos findById(Integer id){
        Optional<FuturosCandidatos> obj = repository.findById(id);
        return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com Id!:" +id));
    }
    public List<FuturosCandidatos> findAll(){ return repository.findAll(); }

    public FuturosCandidatos create(FuturosCandidatosDTO objDto){
        objDto.setId(null);
        FuturosCandidatos newObj = new FuturosCandidatos(objDto);
        return repository.save(newObj);
    }

    public FuturosCandidatos update(Integer id, FuturosCandidatosDTO objDto){
        objDto.setId(id);
        FuturosCandidatos oldObj = findById(id);
        return repository.save(oldObj);
    }
    public void delete(Integer id){
        FuturosCandidatos obj = findById(id);
    }

}
