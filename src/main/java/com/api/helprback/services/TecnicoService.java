package com.api.helprback.services;

import com.api.helprback.domain.Pessoa;
import com.api.helprback.domain.Tecnico;
import com.api.helprback.domain.dtos.TecnicoDTO;
import com.api.helprback.repositories.PessoaRepository;
import com.api.helprback.repositories.TecnicoRepository;
import com.api.helprback.services.exceptions.DataIntegrityViolationException;
import com.api.helprback.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!: "+id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDto) {
        objDto.setId(null);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        validaPorCpfEEmail(objDto);
        Tecnico newObj = new Tecnico(objDto);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(TecnicoDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("E-mail já existente no sistema!");
        }
    }

    public Tecnico update(Integer id, TecnicoDTO objDto) {
        objDto.setId(id);
        objDto.setSenha(encoder.encode(objDto.getSenha()));
        Tecnico oldObj = findById(id);
        if(!objDto.getSenha().equals(oldObj.getSenha())){
            objDto.setSenha(encoder.encode(objDto.getSenha()));
        }
        validaPorCpfEEmail(objDto);
        oldObj = new Tecnico(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException(
                    "O técnico possui ordens de chamados e não pode ser excluido."
            );
        }
        repository.deleteById(id);
    }
    public List<Tecnico> reportTecnicoChamadoPrioridadeDia(){
        Optional<List<Tecnico>> obj = repository.reportByTecnicoChamadoPrioridadeDia();
        return obj.orElseThrow(() -> new ObjectNotFoundException("Neste dia não há tecnicos em urgência."));
    }
}
