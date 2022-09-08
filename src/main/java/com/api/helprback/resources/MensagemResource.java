package com.api.helprback.resources;


import com.api.helprback.domain.Mensagem;
import com.api.helprback.domain.dtos.MensagemDTO;
import com.api.helprback.services.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/mensagens")
public class MensagemResource {

    @Autowired
    private MensagemService mensagem;

    @GetMapping
    public ResponseEntity<List<MensagemDTO>> findAll(){
        List<Mensagem> list = mensagem.findAll();
        List<MensagemDTO> listDto = list.stream().map(obj -> new MensagemDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MensagemDTO> findById(@PathVariable Integer id){
        Mensagem obj = mensagem.findById(id);
        return ResponseEntity.ok().body(new MensagemDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MensagemDTO> create(@Valid @RequestBody MensagemDTO objDto){
        Mensagem obj = mensagem.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MensagemDTO> update(@PathVariable Integer id, @Valid @RequestBody MensagemDTO objDto){
        Mensagem newObj = mensagem.update(id,objDto);
        return ResponseEntity.ok().body(new MensagemDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MensagemDTO> delete(@PathVariable Integer id){
        mensagem.delete(id);
        return ResponseEntity.noContent().build();
    }

}