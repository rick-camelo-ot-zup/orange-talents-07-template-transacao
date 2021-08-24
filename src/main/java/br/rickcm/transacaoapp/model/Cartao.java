package br.rickcm.transacaoapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Cartao {
    private String idCartao;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.idCartao = id;
        this.email = email;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }
}
