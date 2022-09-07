package com.api.helprback.domain.dtos;

import com.api.helprback.domain.FuturosClientes;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FuturosClientesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O Campo NOME é requerido")
    protected String nome;
    @NotNull(message = "O Campo TELEFONE é requerido")
    protected String telefone;
    @NotNull(message = "O Campo EMAIL é requerido")
    protected String email;

    public FuturosClientesDTO() {
        super();
    }

    public FuturosClientesDTO(FuturosClientes obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
