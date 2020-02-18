package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.entities.Estado;
import br.com.ultracar.treinamento.repositories.CidadeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CidadeService {

	@Autowired
	private CidadeRepository repositorio;

	public void salvarCidade(Cidade Cidade) {
		this.repositorio.save(Cidade);
	}
	
	public Cidade buscarSalvar(Cidade cidade) {
		if (this.repositorio.exists(Example.of(cidade, ExampleMatcher.matchingAll().withIgnoreCase()))) {
			return this.repositorio.findByNomeEstado(cidade.getNome(), cidade.getEstado().getNome());
		} else {
			return this.repositorio.save(cidade);
		}
	}

	public void deletarCidade(Cidade Cidade) {
		this.repositorio.deleteById(Cidade.getId());
	}

	public void deletarCidades(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Cidade> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Cidade> findByNome(String nome) {
		return this.repositorio.findByNome(nome);
	}
	
	public List<Cidade> findByEstado(Estado estado) {
		return this.repositorio.findByEstado(estado);
	}
	
	public Cidade findByNomeEstado(String nomeCidade, String nomeEstado) {
		return this.repositorio.findByNomeEstado(nomeCidade, nomeEstado);
	}
}
