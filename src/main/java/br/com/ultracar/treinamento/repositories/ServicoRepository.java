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
	@Query("Select servico From Servico servico " + "Inner Join servico.operacao operacao "
			+ "Where operacao.tipoOperacao = :tipoOperacao")
	public List<Servico> findByTipoOperacao(Crud tipoOperacao);

	@Modifying
	@Query("Update servico From Servico servico " + "Set servico.solicitante.id = :novoSolicitante "
			+ "Where servico.solicitante.id = :idSolicitante ")
	public void updateBySolicitante(Long novoSolicitante, Long idSolicitante);

}