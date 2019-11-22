package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Operacao;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.enumerators.Crud;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	@Query("Select op From Operacao op Where op.tipoOperacao = :tipoOperacao")
	public List<Operacao> findByTipo(Crud tipoOperacao);
	
	@Query("Select op From Operacao op Where op.descricao like %:descricao%")
	public List<Operacao> findByDescricao(String descricao);
	
	@Query("Select op From Operacao op "
		 + "Inner Join Fetch op.permissoesAcesso pa "
		 + "Inner Join Fetch pa.usuario u "
		 + "Where u = :usuario")
	public List<Operacao> findByUsuario(Usuario usuario);
	
}