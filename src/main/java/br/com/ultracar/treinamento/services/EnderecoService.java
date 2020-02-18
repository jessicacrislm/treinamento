package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.enumerators.TipoLocal;
import br.com.ultracar.treinamento.repositories.EnderecoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositorio;

	public void salvarEndereco(Endereco endereco) {
		this.repositorio.save(endereco);
	}
	
	public Endereco buscarSalvar(Endereco endereco) {
		Example<Endereco> filtro = Example.of(endereco, ExampleMatcher.matchingAll().withIgnoreCase());
		if (this.repositorio.exists(filtro)) {
			return this.repositorio.findAll(filtro).stream().findFirst().orElse(null);
		} else {
			return this.repositorio.save(endereco);
		}
	}

	public void deletarEndereco(Endereco endereco) {
		this.repositorio.deleteById(endereco.getId());
	}

	public void deletarEnderecos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Endereco> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Endereco> findBySituacao(String logradouro) {
		return this.repositorio.findByLogradouro(logradouro);
	}
	
	public List<Endereco> findByTipoLocal(TipoLocal tipoLocal) {
		return this.repositorio.findByTipoLocal(tipoLocal);
	}
}
