package com.api.helprback.services;

import com.api.helprback.domain.LogPessoa;
import com.api.helprback.repositories.LogPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogPessoaService {
    @Autowired
    private LogPessoaRepository logPessoaRepository;

    public List<LogPessoa> findAll() {
        return logPessoaRepository.findAll();
    }
}
