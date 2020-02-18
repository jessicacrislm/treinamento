package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.entities.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("Select c From Cidade c Where c.nome Like %:nome%")
	public List<Cidade> findByNome(String nome);
	
	@Query("Select c From Cidade c Where c.estado = :estado")
	public List<Cidade> findByEstado(Estado estado);

	@Query("Select c From Cidade c Where c.nome Like :nomeCidade and c.estado.nome Like :nomeEstado")
	public Cidade findByNomeEstado(String nomeCidade, String nomeEstado);
	
}