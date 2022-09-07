package com.api.helprback.resources;

import com.api.helprback.domain.FuturosClientes;
import com.api.helprback.domain.dtos.FuturosClientesDTO;
import com.api.helprback.services.FuturosClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/futurosclientes")
public class FuturosClientesResource {

    @Autowired
    private FuturosClientesService futurosClientesService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuturosClientesDTO> findById(@PathVariable Integer id) {
        FuturosClientes obj = futurosClientesService.findById(id);
        return ResponseEntity.ok().body(new FuturosClientesDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<FuturosClientesDTO>> findAll() {
        List<FuturosClientes> list = futurosClientesService.findAll();
        List<FuturosClientesDTO> listDto = list.stream().map(obj -> new FuturosClientesDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<FuturosClientesDTO> create(@Valid @RequestBody FuturosClientesDTO objDto) {
        FuturosClientes obj = futurosClientesService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<FuturosClientesDTO> update(@PathVariable Integer id, @Valid @RequestBody FuturosClientesDTO objDto){
        FuturosClientes newObj = futurosClientesService.update(id, objDto);
        return ResponseEntity.ok().body(new FuturosClientesDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FuturosClientesDTO> delete(@PathVariable Integer id){
        futurosClientesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
