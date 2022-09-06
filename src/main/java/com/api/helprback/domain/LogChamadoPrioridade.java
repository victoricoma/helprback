package com.api.helprback.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
public class LogChamadoPrioridade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dtAlteracao;

    private String prioridadeAntigo;
    private String prioridadeNovo;

    public LogChamadoPrioridade() {
        super();
    }

    public LogChamadoPrioridade(Integer id, LocalDate dtAlteracao, String prioridadeAntigo, String prioridadeNovo) {
        super();
        this.id = id;
        this.dtAlteracao = dtAlteracao;
        this.prioridadeAntigo = prioridadeAntigo;
        this.prioridadeNovo = prioridadeNovo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(LocalDate dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public String getPrioridadeAntigo() {
        return prioridadeAntigo;
    }

    public void setPrioridadeAntigo(String prioridadeAntigo) {
        this.prioridadeAntigo = prioridadeAntigo;
    }

    public String getPrioridadeNovo() {
        return prioridadeNovo;
    }

    public void setPrioridadeNovo(String prioridadeNovo) {
        this.prioridadeNovo = prioridadeNovo;
    }
}

