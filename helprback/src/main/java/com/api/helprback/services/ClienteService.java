package com.api.helprback.services;

import com.api.helprback.domain.Cliente;
import com.api.helprback.domain.Pessoa;
import com.api.helprback.domain.dtos.ClienteDTO;
import com.api.helprback.repositories.ClienteRepository;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.services.exceptions.DataIntegrityViolationException;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findByid(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado!: " +id));
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }
    public Cliente create(ClienteDTO objDTO){
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(ClienteDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já existente no sistema!");
        }
    }
        public Cliente update(Integer id, ClienteDTO objDTO){
            objDTO.setId(id);
            Cliente oldObj = findByid(id);
            validaPorCpfEEmail(objDTO);
            oldObj = new Cliente(objDTO);
            return repository.save(oldObj);
        }

        public void delete(Integer id) {
            Cliente obj = findByid(id);
            if (obj.getChamados().size() > 0) {
                throw new DataIntegrityViolationException("");
            }
            repository.deleteById(id);
        }
    }
