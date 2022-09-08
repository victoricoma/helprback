package com.api.helprback.domain;

import com.api.helprback.domain.dtos.LogPessoaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class LogPessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codLog;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAlteracao;

    private String tipoAlteracao;

    private Integer id;

    private Integer perfilAdd;

    private Integer perfilDel;

    public LogPessoa() {
        super();
    }

    public LogPessoa(LogPessoaDTO obj) {
        super();
        this.codLog = obj.getCodLog();
        this.dtAlteracao = obj.getDtAlteracao();
        this.tipoAlteracao = obj.getTipoAlteracao();
        this.id = obj.getId();
        this.perfilAdd = obj.getPerfilAdd();
        this.perfilDel = obj.getPerfilDel();
    }
    public Integer getCodLog() {
        return codLog;
    }

    public void setCodLog(Integer codLog) {
        this.codLog = codLog;
    }

    public LocalDate getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(LocalDate dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public String getTipoAlteracao() {
        return tipoAlteracao;
    }

    public void setTipoAlteracao(String tipoAlteracao) {
        this.tipoAlteracao = tipoAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerfilAdd() {
        return perfilAdd;
    }

    public void setPerfilAdd(Integer perfilAdd) {
        this.perfilAdd = perfilAdd;
    }

    public Integer getPerfilDel() {
        return perfilDel;
    }

    public void setPerfilDel(Integer perfilDel) {
        this.perfilDel = perfilDel;
    }
}

