package br.rickcm.transacaoapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    private String nomeEstabelecimento;
    private String cidade;
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nomeEstabelecimento = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
