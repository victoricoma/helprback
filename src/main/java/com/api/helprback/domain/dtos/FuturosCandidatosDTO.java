package com.api.helprback.domain.dtos;

import com.api.helprback.domain.FuturosCandidatos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FuturosCandidatosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O campo NOME é reuerido!")
    protected String nome;
    @NotNull(message = "O campo formação é requerido!")
    protected String formacao;
    @NotNull(message = "O campo telefone é requerido!")
    protected String telefone;
    @NotNull(message ="O campo experiência é requerido!")
    protected String experiencia;
    @NotNull(message = "O campo link do linkedin é requerido!")
    protected String linkedin;

    public FuturosCandidatosDTO() {
        super();
    }

    public FuturosCandidatosDTO(FuturosCandidatos obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.formacao = obj.getFormacao();
        this.telefone = obj.getTelefone();
        this.experiencia = obj.getExperiencia();
        this.linkedin = obj.getLink_do_Linkedin();
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getFormacao() { return formacao; }

    public void setFormacao(String formacao) { this.formacao = formacao; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getExperiencia() { return experiencia; }

    public void setExperiencia(String experiencia) { this.experiencia = experiencia; }

    public String getLinkedin() { return linkedin; }

    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

}
