package br.rickcm.transacaoapp.repository;

import br.rickcm.transacaoapp.model.Transacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String> {

    List<Transacao> findTop10ByCartao_IdCartaoOrderByEfetivadaEmDesc(String id);
}
