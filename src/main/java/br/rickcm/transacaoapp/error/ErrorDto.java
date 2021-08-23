package br.rickcm.transacaoapp.error;

import java.util.Collection;

public class ErrorDto {

    private Collection<String> mensagens;

    public ErrorDto(Collection<String> mensagens) {
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens() {
        return mensagens;
    }
}
