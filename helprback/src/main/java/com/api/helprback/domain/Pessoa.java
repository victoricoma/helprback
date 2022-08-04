package com.api.helprback.domain;

import com.api.helprback.domain.enums.Perfil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pessoa {
protected Integer id;
protected String nome;
protected String cpf;
protected String email;
protected String senha;
protected Set<Perfil>perfis = new HashSet<>();
protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa() {
        super();
    }
   public Pessoa(Integer id, String nome, String none, String  cpf, String email, String senha)
   {
       super();
       this.id = id;
       this.nome = nome;
       this.cpf = cpf;
       this.email = email;
       this.senha = senha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if(cpf == null){
            if(other.cpf !=null)
                return false;

        }else if(!cpf.equals(other.cpf))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        }else if (!id.equals(other.id))
            return false;
        return true;

    }

    @Override
    public int hashCode() throws {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;

    }

}
