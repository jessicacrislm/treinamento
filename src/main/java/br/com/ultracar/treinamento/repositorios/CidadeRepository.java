package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	@Query("Select cidade From Cidade cidade " + 
			"Inner Join cidade.estado estado " + 
			"Where estado.sigla like :estadoSigla")
	public List<Cidade> findByEstado(String estadoSigla);
}
