package com.api.helprback.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa {

    private static final long serialVersionUID = 1L;


    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamado = new ArrayList<>();


    public Tecnico() {
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Chamado> getChamado() {
        return chamado;
    }

    public void setChamado(List<Chamado> chamado) {
        this.chamado = chamado;
    }
}
