package com.api.helprback.resources;

import com.api.helprback.domain.Pessoa;
import com.api.helprback.domain.dtos.PessoaDTO;
import com.api.helprback.domain.dtos.TecnicoDTO;
import com.api.helprback.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{email}")
    public ResponseEntity<PessoaDTO> findByEmail(@PathVariable String email){
        Pessoa obj = this.service.findByEmail(email);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }

}
