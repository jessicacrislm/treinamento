package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Bairro;
import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.repositories.BairroRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BairroService {

	@Autowired
	private BairroRepository repositorio;

	public void salvarBairro(Bairro bairro) {
		this.repositorio.save(bairro);
	}
	
	public Bairro buscarSalvar(Bairro bairro) {
		if (this.repositorio.exists(Example.of(bairro, ExampleMatcher.matchingAll().withIgnoreCase()))) {
			return this.repositorio.findByNomeCidade(bairro.getNome(), bairro.getCidade().getNome());
		} else {
			return this.repositorio.save(bairro);
		}
	}

	public void deletarBairro(Bairro bairro) {
		this.repositorio.deleteById(bairro.getId());
	}

	public void deletarBairros(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Bairro> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public Bairro findByNome(String nome) {
		return this.repositorio.findByNome(nome);
	}
	
	public List<Bairro> findByCidade(Cidade cidade) {
		return this.repositorio.findByCidade(cidade);
	}
	
	public Bairro findByNomeCidade(String nomeBairro, String nomeCidade) {
		return this.repositorio.findByNomeCidade(nomeBairro, nomeCidade);
	}
}
