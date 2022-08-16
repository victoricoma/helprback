package com.api.helprback.domain;

import com.api.helprback.domain.dtos.ClienteDTO;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Cliente extends Pessoa{

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }
    public Cliente(ClienteDTO objDto){
        super();
        this.id = objDto.getId();
        this.nome = objDto.getNome();
        this.cpf = objDto.getCpf();
        this.email = objDto.getEmail();
        this.senha = objDto.getSenha();
        this.perfis = objDto.getPerfis().stream().map(x ->x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = objDto.getDataCriacao();
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamado) {
        this.chamados = chamado;
    }
}