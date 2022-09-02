package com.api.helprback.resources;

import com.api.helprback.domain.FuturosCandidatos;
import com.api.helprback.domain.dtos.FuturosCandidatosDTO;
import com.api.helprback.services.FuturosCandidatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/futuroscandidatos")
public class FuturosCandidatosResource {

    @Autowired
    private FuturosCandidatosService futurosCandidatosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuturosCandidatosDTO> findById(@PathVariable Integer id){
        FuturosCandidatos obj = this.futurosCandidatosService.findById(id);
        return ResponseEntity.ok().body(new FuturosCandidatosDTO(obj));
    }
    @GetMapping
    public ResponseEntity<List<FuturosCandidatosDTO>> findAll(){
        List<FuturosCandidatos> list = futurosCandidatosService.findAll();
        List<FuturosCandidatosDTO> listDto = list.stream().map(obj -> new FuturosCandidatosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    @PostMapping
    public ResponseEntity<FuturosCandidatosDTO> create(@Valid @RequestBody FuturosCandidatosDTO objDto){
        FuturosCandidatos obj = futurosCandidatosService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<FuturosCandidatosDTO> update(@PathVariable Integer id, @Valid @RequestBody FuturosCandidatosDTO objDto){
        FuturosCandidatos newObj = futurosCandidatosService.update(id, objDto);
        return ResponseEntity.ok().body(new FuturosCandidatosDTO(newObj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FuturosCandidatosDTO> delete(@PathVariable Integer id){
        futurosCandidatosService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
