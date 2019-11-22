package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.entities.Ponto;

public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Modifying
	@Query("Delete ponto From Ponto ponto "
			+ "Inner Join ponto.endereco endereco "
			+ "Inner Join endereco.bairro bairro "
			+ "Inner Join bairro.cidade cidade "
			+ "Where cidade = :cidade")	
	public boolean deleteByCidade (Cidade cidade);
	
	@Query("Select p From Ponto p Where p.endereco = :endereco")
	public List<Ponto> findByEndereco(Endereco endereco);
}
