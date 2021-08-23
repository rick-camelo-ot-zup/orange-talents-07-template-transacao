package br.rickcm.transacaoapp.rest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class IniciarTransacoesRequest {

    @NotBlank
    private String id;
    @NotBlank
    @Email
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
