package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Complemento;
import br.com.ultracar.treinamento.entities.Endereco;

@Repository
public interface ComplementoRepository extends JpaRepository<Complemento, Long> {

	@Query("Select c From Complemento c Where c.numero Like %:nome% " + "And c.complemento Like %:complemento%")
	public Complemento findByNumeroComplemento(Integer numero, String complemento);

	@Query("Select c From Complemento c Where c.endereco = :endereco")
	public List<Complemento> findByEndereco(Endereco endereco);
	
}