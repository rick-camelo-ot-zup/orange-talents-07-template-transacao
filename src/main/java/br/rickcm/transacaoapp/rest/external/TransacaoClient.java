package br.rickcm.transacaoapp.rest.external;

import br.rickcm.transacaoapp.rest.dto.IniciarTransacoesRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transacoes", url = "${transacoes.url}")
public interface TransacaoClient {

    @PostMapping
    ResponseEntity<?> comecarGerarTransacoes(@RequestBody IniciarTransacoesRequest body);

    @DeleteMapping("/{id}")
    ResponseEntity<?> encerrarGerarTransacoes(@PathVariable("id") String idCartao);
}
