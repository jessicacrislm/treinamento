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
	@Query("Delete p From Ponto p " + "Inner Join Fetch p.endereco e " + "Inner Join Fetch e.bairro b "
			+ "Inner Join Fetch b.cidade c " + "Where c = :cidade")
	public boolean deleteByCidade(Cidade cidade);
	
	@Query("Select p From Ponto p Where p.endereco = :endereco")
	public List<Ponto> findByEndereco(Endereco endereco);
}
