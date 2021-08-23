package br.rickcm.transacaoapp.rest.dto;

import javax.validation.constraints.NotBlank;

public class PararTransacaoRequest {

    @NotBlank
    private String idCartao;

    public String getIdCartao() {
        return idCartao;
    }
}
