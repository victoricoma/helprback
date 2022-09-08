package com.api.helprback.domain;

import com.api.helprback.domain.dtos.MensagemDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "Tecnico_id")
    private Tecnico tecnico;

    public Mensagem(Integer id, String mensagem, Tecnico tecnico) {
        this.id = id;
        this.mensagem = mensagem;
        this.tecnico = tecnico;
    }

    public Mensagem() {
    }

    public Mensagem(MensagemDTO objDto) {
        this.id = objDto.getId();
        this.mensagem = objDto.getMensagem();
        this.tecnico = objDto.getTecnico();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensagem)) return false;

        Mensagem mensagem = (Mensagem) o;

        return id != null ? id.equals(mensagem.id) : mensagem.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
