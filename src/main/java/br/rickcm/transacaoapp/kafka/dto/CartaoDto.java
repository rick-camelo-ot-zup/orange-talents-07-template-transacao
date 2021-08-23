package br.rickcm.transacaoapp.kafka.dto;

import br.rickcm.transacaoapp.model.Cartao;

public class CartaoDto {

    private String id;
    private String email;

    public Cartao toModel(){
        return new Cartao(this.id, this.email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
