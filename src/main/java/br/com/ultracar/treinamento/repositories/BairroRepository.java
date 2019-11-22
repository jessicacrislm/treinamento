package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Bairro;
import br.com.ultracar.treinamento.entities.Cidade;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

	@Query("Select b From Bairro b Where b.nome like %:nome%")
	public Bairro findByNome(String nome);
	
	@Query("Select b From Bairro b Where b.cidade = :cidade")
	public List<Bairro> findByCidade(Cidade cidade);
	
}