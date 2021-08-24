package br.rickcm.transacaoapp.model;

import br.rickcm.transacaoapp.rest.dto.TransacaoResponse;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @Embedded
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                "}, efetivadaEm=" + efetivadaEm +
                '}';
    }

    public TransacaoResponse toDto(){
        return new TransacaoResponse(id,
                valor,
                estabelecimento.getNomeEstabelecimento(),
                estabelecimento.getCidade(),
                estabelecimento.getEndereco(),
                cartao.getIdCartao(),
                cartao.getEmail(),
                efetivadaEm);
    }
}
