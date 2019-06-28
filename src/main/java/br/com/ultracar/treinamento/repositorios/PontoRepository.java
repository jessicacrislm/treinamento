package br.com.ultracar.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Cidade;
import br.com.ultracar.treinamento.entidades.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Query("Delete ponto From Ponto ponto "
			+ "Inner Join ponto.endereco endereco "
			+ "Inner Join endereco.bairro bairro "
			+ "Inner Join bairro.cidade cidade "
			+ "Where cidade = :cidade")	
	public boolean deleteByCidade (Cidade cidade);
}
