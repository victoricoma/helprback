package com.api.helprback.resources;

import com.api.helprback.domain.LogPessoa;
import com.api.helprback.domain.dtos.LogPessoaDTO;
import com.api.helprback.services.LogPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "service/log/perfil")
public class LogPessoaResource {
    @Autowired
    private LogPessoaService logPessoaService;

    @GetMapping
    public ResponseEntity<List<LogPessoaDTO>> findAll() {
        List<LogPessoa> list = logPessoaService.findAll();
        List<LogPessoaDTO> listDto = list.stream().map(obj -> new LogPessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
