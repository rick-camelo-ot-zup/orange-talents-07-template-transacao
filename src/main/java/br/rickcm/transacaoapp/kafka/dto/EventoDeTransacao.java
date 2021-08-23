package br.rickcm.transacaoapp.kafka.dto;

import br.rickcm.transacaoapp.model.Cartao;
import br.rickcm.transacaoapp.model.Estabelecimento;
import br.rickcm.transacaoapp.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoDto estabelecimento;

    private CartaoDto cartao;

    private LocalDateTime efetivadaEm;

    public Transacao toModel(){
        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        Cartao cartao = this.cartao.toModel();
        return new Transacao(id,valor,estabelecimento,cartao,efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento={nome:" + estabelecimento.getNome() +
                ", cidade:"+ estabelecimento.getCidade() +
                ", endereco:"+ estabelecimento.getEndereco()+
                "}, cartao={id:" + cartao.getId() +
                ", email:"+ cartao.getEmail()+
                "}, efetivadaEm=" + efetivadaEm +
                '}';
    }
}
