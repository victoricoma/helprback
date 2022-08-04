package com.api.helprback.domain;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa{
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



