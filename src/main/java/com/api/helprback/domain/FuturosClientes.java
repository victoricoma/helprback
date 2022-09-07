package com.api.helprback.domain;

import com.api.helprback.domain.dtos.FuturosClientesDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FuturosClientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(unique = true, nullable = false)
    private String email;

    public FuturosClientes() {
        super();
    }

    public FuturosClientes(FuturosClientesDTO obj) {
        super();
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
