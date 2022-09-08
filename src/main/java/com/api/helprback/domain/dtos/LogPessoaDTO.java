package com.api.helprback.domain.dtos;

import com.api.helprback.domain.LogPessoa;

import java.io.Serializable;
import java.time.LocalDate;

public class LogPessoaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer codLog;
    private LocalDate dtAlteracao;
    private String tipoAlteracao;
    private Integer id;
    private Integer perfilAdd;
    private Integer perfilDel;


    public LogPessoaDTO() {
        super();
    }

    public LogPessoaDTO(LogPessoa obj) {
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