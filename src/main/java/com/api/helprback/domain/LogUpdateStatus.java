package com.api.helprback.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class LogUpdateStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAlteracao;

    private String statusAntigo;
    private String statusNovo;

    public LogUpdateStatus() {
        super();
    }

    public LogUpdateStatus(Integer id, LocalDate dtAlteracao, String statusAntigo, String statusNovo) {
        super();
        this.id = id;
        this.dtAlteracao = dtAlteracao;
        this.statusAntigo = statusAntigo;
        this.statusNovo = statusNovo;
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

    public String getStatusAntigo() {
        return statusAntigo;
    }

    public void setStatusAntigo(String statusAntigo) {
        this.statusAntigo = statusAntigo;
    }

    public String getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(String statusNovo) {
        this.statusNovo = statusNovo;
    }
}

