package com.api.helprback.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Tecnico extends Pessoa{
    private static final long seralVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public void setChamados(List<Chamado> chamado) {
        this.chamados = chamado;
    }
    public List<Chamado> getChamados() {
        return chamados;
}

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

}



