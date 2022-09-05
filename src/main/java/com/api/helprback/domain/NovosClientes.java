package com.api.helprback.domain;

import com.api.helprback.domain.dtos.NovosClientesDTO;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class NovosClientes implements Serializable{
    private static final  Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private  String contato;
    private String celular;
    private String rede_social;

    public NovosClientes() {
        super();

    }

    public NovosClientes(NovosClientesDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.contato = obj.getContato();
        this.celular = obj.getCelular();
        this.rede_social = obj.getSocial_social();
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

    public String getRede_social() {
        return rede_social;
    }

    public void setRede_social(String rede_social) {
        this.rede_social = rede_social;
    }
}






