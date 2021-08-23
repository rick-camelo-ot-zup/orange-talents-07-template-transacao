package br.rickcm.transacaoapp.repository;

import br.rickcm.transacaoapp.model.Transacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, String> {
}
