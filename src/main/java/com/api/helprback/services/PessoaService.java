package com.api.helprback.services;

import com.api.helprback.domain.Pessoa;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    public Pessoa findByEmail(String email){
        Optional<Pessoa> obj = repository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
