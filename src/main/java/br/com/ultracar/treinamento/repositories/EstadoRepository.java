package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query("Select e From Estado e Where e.sigla Like :sigla")
	public Estado findBySigla(String sigla);
	
	@Query("Select e From Estado e Where e.nome Like %:nome%")
	public List<Estado> findByNome(String nome);
	
}