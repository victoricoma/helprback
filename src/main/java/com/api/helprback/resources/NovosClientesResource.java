package com.api.helprback.resources;

import com.api.helprback.domain.NovosClientes;
import com.api.helprback.domain.dtos.NovosClientesDTO;
import com.api.helprback.services.NovosClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/novosclientes")
public class NovosClientesResource {

    @Autowired
    private NovosClientesService novosClientesService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NovosClientesDTO> findById(@PathVariable Integer id) {
        NovosClientes obj = this.novosClientesService.findById(id);
        return ResponseEntity.ok().body(new NovosClientesDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<NovosClientesDTO>> findAll() {
        List<NovosClientes> list = novosClientesService.findAll();
        List<NovosClientesDTO> listDto = list.stream().map(obj -> new NovosClientesDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<NovosClientesDTO> create(@Valid @RequestBody NovosClientesDTO objDto) {
        NovosClientes obj = novosClientesService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<NovosClientesDTO> update(@PathVariable Integer id, @Valid @RequestBody NovosClientesDTO objDto){
        NovosClientes newObj = novosClientesService.update(id,objDto);
      return ResponseEntity.ok().body(new NovosClientesDTO(newObj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<NovosClientesDTO> delete(@PathVariable Integer id){
        novosClientesService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}

