package br.rickcm.transacaoapp.rest.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartoes", url = "${cartoes.url}")
public interface CartaoClient {

    @GetMapping("/{id}")
    ResponseEntity<?> getCartao(@PathVariable("id") String idCartao);
}
