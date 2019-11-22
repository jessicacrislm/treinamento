package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.enumerators.TipoLocal;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query("Select b From Bairro b Where b.logradouro like %:logradouro%")
	public List<Endereco> findByLogradouro(String logradouro);
	
	@Query("Select b From Bairro b Where b.tipoLocal = :tipoLocal")
	public List<Endereco> findByTipoLocal(TipoLocal tipoLocal);
}