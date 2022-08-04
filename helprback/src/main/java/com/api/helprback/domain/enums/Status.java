package com.api.helprback.domain.enums;

public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer condigo;
    private String descricao;

    Status(Integer condigo, String descricao) {
        this.condigo = condigo;
        this.descricao = descricao;
    }

    public Integer getCondigo() {
        return condigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Status x: Status.values()) {
            if(cod.equals(x.getCondigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status invalido");
    }
}
