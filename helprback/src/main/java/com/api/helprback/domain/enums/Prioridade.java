package com.api.helprback.domain.enums;

public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer condigo;
    private String descricao;

    Prioridade(Integer condigo, String descricao) {
        this.condigo = condigo;
        this.descricao = descricao;
    }

    public Integer getCondigo() {
        return condigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(Prioridade x: Prioridade.values()) {
            if(cod.equals(x.getCondigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Prioridade invalido");
    }
}

