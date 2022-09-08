package com.api.helprback.services;

import com.api.helprback.domain.Mensagem;
import com.api.helprback.domain.dtos.MensagemDTO;
import com.api.helprback.repositories.MensagemRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    public List<Mensagem> findAll(){
        return repository.findAll();
    }


    public Mensagem findById(Integer id) {
        Optional<Mensagem> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não incontrado"));
    }

    public Mensagem create(MensagemDTO objDto) {
        objDto.setId(null);
        Mensagem newObj = new Mensagem(objDto);
        return repository.save(newObj);
    }

    public Mensagem update(Integer id, MensagemDTO objDto) {
        objDto.setId(id);
        Mensagem oldObj = findById(id);
        oldObj = new Mensagem(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Mensagem obj = findById(id);
        repository.deleteById(id);
    }
}


