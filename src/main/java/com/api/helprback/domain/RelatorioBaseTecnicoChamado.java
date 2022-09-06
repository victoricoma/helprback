package com.api.helprback.domain;

import javax.persistence.*;

@Entity
public class RelatorioBaseTecnicoChamado{
    @Id
    private Long cod;
    private String tecnico;
    private Integer status;
    private Integer prioridade;
    private Integer contagem;

    public RelatorioBaseTecnicoChamado() {
        super();
    }

    public RelatorioBaseTecnicoChamado(Long cod, String tecnico, Integer status, Integer prioridade, Integer contagem) {
        super();
        this.cod = cod;
        this.tecnico = tecnico;
        this.status = status;
        this.prioridade = prioridade;
        this.contagem = contagem;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getContagem() {
        return contagem;
    }

    public void setContagem(Integer contagem) {
        this.contagem = contagem;
    }

}


