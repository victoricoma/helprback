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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Cliente create;
    public Cliente upadate;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return (obj).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!: "+ id));

    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(@Valid ClienteDTO objDto) {
        objDto.setId(null);
        validaPorCpfEEmail(objDto);
        Cliente newObj = new Cliente(objDto);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException(
                    "O cliente possui ordens e chamados e não pode ser excluído."
            );
        }
        repository.deleteById(id);
    }

    public Cliente update(Integer id, ClienteDTO objDto) {
        objDto.setId(id);
        Cliente oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Cliente(objDto);
        return repository.save(oldObj);
    }

    private void validaPorCpfEEmail(ClienteDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("Email já existente no sistema!");
        }

    }
}
