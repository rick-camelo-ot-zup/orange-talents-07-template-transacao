package br.rickcm.transacaoapp.rest.external;

import br.rickcm.transacaoapp.error.ApiErrorException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ServicoCartao {

    private final CartaoClient cartaoClient;

    public ServicoCartao(CartaoClient cartaoClient) {
        this.cartaoClient = cartaoClient;
    }

    public void validaCartao(String idCartao){
        try{
            ResponseEntity<?> responseFromCartao = cartaoClient.getCartao(idCartao);
        }catch (FeignException.FeignClientException e){
            if(e.status() == 404){
                throw new ApiErrorException(HttpStatus.NOT_FOUND,"Cartão não encontrado!");
            }else{
                throw new ApiErrorException(HttpStatus.valueOf(e.status()),"Não foi possivel validar o cartão.");
            }
        }
    }
}
