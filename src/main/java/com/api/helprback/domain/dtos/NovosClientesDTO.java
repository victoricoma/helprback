package com.api.helprback.domain.dtos;

import com.api.helprback.domain.NovosClientes;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class NovosClientesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "o Campo NOME nao pode ser nulo!")
    private String nome;
    @NotNull(message = "O campo CONTATO não pode ser nulo!")
    private String contato;
    @NotNull(message = "O Campo CELULAR não pode ser nulo!")
    private String celular;
    @NotNull(message = "O campo REDE_SOCIAL não pode ficar vazio!")
    private String  social_social;

    public NovosClientesDTO() {
        super();

    }

    public NovosClientesDTO(NovosClientes obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.contato = obj.getContato();
        this.celular = obj.getCelular();
        this.social_social = obj.getRede_social();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSocial_social() {
        return social_social;
    }

    public void setSocial_social(String social_social) {
        this.social_social = social_social;
    }
}



