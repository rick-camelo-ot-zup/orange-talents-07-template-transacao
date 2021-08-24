package br.rickcm.transacaoapp.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private String nomeEstabelecimento;
    private String cidadeEstabelecimento;
    private String enderecoEstabelecimento;
    private String idCartao;
    private String email;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(String id,
                             BigDecimal valor,
                             String nomeEstabelecimento,
                             String cidadeEstabelecimento,
                             String enderecoEstabelecimento,
                             String idCartao,
                             String email,
                             LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.cidadeEstabelecimento = cidadeEstabelecimento;
        this.enderecoEstabelecimento = enderecoEstabelecimento;
        this.idCartao = idCartao;
        this.email = email;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public String getCidadeEstabelecimento() {
        return cidadeEstabelecimento;
    }

    public String getEnderecoEstabelecimento() {
        return enderecoEstabelecimento;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
