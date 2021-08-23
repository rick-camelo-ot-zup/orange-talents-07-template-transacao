package br.rickcm.transacaoapp.kafka.listener;

import br.rickcm.transacaoapp.kafka.dto.EventoDeTransacao;
import br.rickcm.transacaoapp.model.Transacao;
import br.rickcm.transacaoapp.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    private TransacaoRepository repository;

    public ListenerDeTransacao(TransacaoRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        Transacao transacao = eventoDeTransacao.toModel();
        repository.save(transacao);
        logger.info("Recebida transação id={} para o cartao={}.", transacao.getId(), transacao.getCartao().getIdCartao());

        ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

}