package com.api.helprback.domain;

import com.api.helprback.domain.dtos.FuturosCandidatosDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FuturosCandidatos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    @Column(unique = true)
    protected String formacao;
    @Column(unique = true)
    protected String telefone;
    @Column(unique = true)
    protected String experiencia;
    @Column(unique = true)
    protected String link_do_Linkedin;

    public FuturosCandidatos() {
        super();
    }

    public FuturosCandidatos(FuturosCandidatosDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.formacao = obj.getFormacao();
        this.telefone = obj.getTelefone();
        this.experiencia = obj.getExperiencia();
        this.link_do_Linkedin = obj.getLinkedin();
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { nome = nome; }

    public String getFormacao() { return formacao; }

    public void setFormacao(String formacao) { this.formacao = formacao; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getExperiencia() { return experiencia; }

    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }

    public String getLink_do_Linkedin() { return link_do_Linkedin; }

    public void setLink_do_Linkedin(String link_do_Linkedin) { this.link_do_Linkedin = link_do_Linkedin; }

}
