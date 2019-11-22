package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Servico;
import br.com.ultracar.treinamento.enumerators.Crud;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	@Async
	@Query("Select s From Servico s " + "Inner Join s.operacao o " + "Where o.tipoOperacao = :tipoOperacao")
	public List<Servico> findByTipoOperacao(Crud tipoOperacao);

	@Modifying
	@Query("Update s From Servico s " + "Set s.solicitante.id = :novoSolicitante "
			+ "Where s.solicitante.id = :idSolicitante ")
	public void updateBySolicitante(Long novoSolicitante, Long idSolicitante);

}