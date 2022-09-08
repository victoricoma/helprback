package com.api.helprback.domain.dtos;


import com.api.helprback.domain.Mensagem;
import com.api.helprback.domain.Tecnico;
import java.io.Serializable;

public class MensagemDTO implements Serializable {

        private static final long serialVersionUID = 1L;


        private Integer id;
        private String mensagem;

        private Tecnico tecnico;

        public MensagemDTO(Integer id, String mensagem, Tecnico tecnico) {
            this.id = id;
            this.mensagem = mensagem;
            this.tecnico = tecnico;
        }

        public MensagemDTO(Mensagem mensagem) {
        this.id = mensagem.getId();
        this.mensagem = mensagem.getMensagem();
        this.tecnico = mensagem.getTecnico();
    }

        public MensagemDTO() {
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
}

