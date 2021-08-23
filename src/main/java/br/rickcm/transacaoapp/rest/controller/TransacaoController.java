package br.rickcm.transacaoapp.rest.controller;

import br.rickcm.transacaoapp.rest.dto.IniciarTransacoesRequest;
import br.rickcm.transacaoapp.rest.dto.PararTransacaoRequest;
import br.rickcm.transacaoapp.rest.external.ServicoCartao;
import br.rickcm.transacaoapp.rest.external.TransacaoClient;
import feign.FeignException.FeignClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransacaoController {

    private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

    private ServicoCartao servicoCartao;
    private TransacaoClient transacaoClient;

    public TransacaoController(ServicoCartao servicoCartao, TransacaoClient transacaoClient) {
        this.servicoCartao = servicoCartao;
        this.transacaoClient = transacaoClient;
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
}
