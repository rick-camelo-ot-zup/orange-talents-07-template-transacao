package br.rickcm.transacaoapp.kafka.dto;

import br.rickcm.transacaoapp.model.Estabelecimento;

public class EstabelecimentoDto {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento toModel(){
        return new Estabelecimento(this.nome,this.cidade,this.endereco);
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
