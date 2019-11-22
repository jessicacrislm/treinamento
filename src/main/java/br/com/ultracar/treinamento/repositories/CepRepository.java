package br.com.ultracar.treinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Cep;
import br.com.ultracar.treinamento.entities.Endereco;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

	@Query("Select c From Cep c Where c.numero = :numero")
	public Cep findByNumero(Integer numero);
	
	@Query("Select c From Cep c Where c.endereco = :endereco")
	public Cep findByEndereco(Endereco endereco);
}