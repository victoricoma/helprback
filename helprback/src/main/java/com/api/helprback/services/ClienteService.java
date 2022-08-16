package com.api.helprback.services;

import com.api.helprback.domain.Cliente;
import com.api.helprback.domain.Pessoa;
import com.api.helprback.domain.Tecnico;
import com.api.helprback.domain.dtos.ClienteDTO;
import com.api.helprback.domain.dtos.TecnicoDTO;
import com.api.helprback.repositories.ClienteRepository;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.services.exceptions.DataIntegrityViolationException;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private static ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public static Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não foi encontrado!: " +id));

    }
    public List<Cliente> findAll(){
        return repository.findAll();
    }
    public Cliente create(ClienteDTO objDto) {
        objDto.setId(null);
        validaPorCpfEEmail(objDto);
       Cliente newObj = new Cliente(objDto);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(ClienteDTO objDto){
        Optional<Pessoa> obj=pessoaRepository.findByCpf(objDto.getCpf());
        if(obj.isPresent()&& obj.get().getId() != objDto.getId()){
            throw  new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj= pessoaRepository.findByEmail((objDto.getEmail()));
        if (obj.isPresent()&& obj.get().getId() != objDto.getId()){
            throw  new DataIntegrityViolationException("E-mail já existente no sistema");
        }
    }
    public Cliente update(Integer id, ClienteDTO objDto){
        objDto.setId(id);
        Cliente oldObj=findById(id);
        validaPorCpfEEmail(objDto);
        oldObj=new Cliente(objDto);
        return repository.save(oldObj);
    }
     public static void delete(Integer id){
        Cliente obj = findById(id);
        if(obj.getChamados().size()>0){
            throw  new DataIntegrityViolationException(("O cliente possui ordem de chamados e não pode ser excluido."));
        }
        repository.deleteById(id);
     }
}