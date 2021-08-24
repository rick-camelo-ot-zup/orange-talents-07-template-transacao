package br.rickcm.transacaoapp.rest.controller;

import br.rickcm.transacaoapp.model.Transacao;
import br.rickcm.transacaoapp.repository.TransacaoRepository;
import br.rickcm.transacaoapp.rest.dto.IniciarTransacoesRequest;
import br.rickcm.transacaoapp.rest.dto.PararTransacaoRequest;
import br.rickcm.transacaoapp.rest.dto.TransacaoResponse;
import br.rickcm.transacaoapp.rest.external.ServicoCartao;
import br.rickcm.transacaoapp.rest.external.TransacaoClient;
import feign.FeignException.FeignClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    private ServicoCartao servicoCartao;
    private TransacaoClient transacaoClient;
    private TransacaoRepository repository;

    public TransacaoController(ServicoCartao servicoCartao, TransacaoClient transacaoClient, TransacaoRepository repository) {
        this.servicoCartao = servicoCartao;
        this.transacaoClient = transacaoClient;
        this.repository = repository;
    }

    @PostMapping("/transacoes")
    public ResponseEntity<?> iniciarTransacoes(@RequestBody @Valid IniciarTransacoesRequest request){

        servicoCartao.validaCartao(request.getId());

        try{
            transacaoClient.comecarGerarTransacoes(request);
            logger.info("Enviada requisição para a geração de transações para o cartao={}", request.getId());
        }catch (FeignClientException e){
            logger.error("Erro ao tentar enviar requisição de geração de transações para o cartao={}", request.getId());
            return ResponseEntity.status(e.status()).build();
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/transacoes")
    public ResponseEntity<?> pararTransacoes(@RequestBody @Valid PararTransacaoRequest request){

        servicoCartao.validaCartao(request.getIdCartao());

        try{
            transacaoClient.encerrarGerarTransacoes(request.getIdCartao());
            logger.info("Enviada requisição para parar geração de transações para o cartao={}", request.getIdCartao());
        }catch (FeignClientException e){
            logger.error("Erro ao tentar enviar requisição para parar a geração de transações para o cartao={}", request.getIdCartao());
            return ResponseEntity.status(e.status()).build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/cartoes/{id}/transacoes")
    public ResponseEntity<?> buscaComprasRecentes(@PathVariable("id") String idCartao){
        servicoCartao.validaCartao(idCartao);

        List<Transacao> listaTransacoes = repository.findTop10ByCartao_IdCartaoOrderByEfetivadaEmDesc(idCartao);

        List<TransacaoResponse> listaDtos = listaTransacoes.stream().map(Transacao::toDto).collect(Collectors.toList());

        return ResponseEntity.ok(listaDtos);
    }
}
