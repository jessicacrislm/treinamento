package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.entities.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long> {

	@Query("Selectc s From Solicitante s Where s.endereco = :endereco")
	public List<Solicitante> findByEndereco(Endereco endereco);
	
}