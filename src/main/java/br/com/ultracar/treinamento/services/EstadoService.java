package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Estado;
import br.com.ultracar.treinamento.repositories.EstadoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EstadoService {

	@Autowired
	private EstadoRepository repositorio;

	public void salvarEstado(Estado estado) {
		this.repositorio.save(estado);
	}
	
	public Estado buscarSalvar(Estado estado) {
		if (this.repositorio.exists(Example.of(estado, ExampleMatcher.matchingAll().withIgnoreCase()))) {
			return this.repositorio.findBySigla(estado.getSigla());
		} else {
			return this.repositorio.save(estado);
		}
	}

	public void deletarEstado(Estado estado) {
		this.repositorio.deleteById(estado.getId());
	}

	public void deletarEstados(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}

	public Estado findBySigla(String sigla) {
		return this.repositorio.findBySigla(sigla);
	}

	public Optional<Estado> findById(Long id) {
		return this.repositorio.findById(id);
	}

	public List<Estado> findByNome(String nome) {
		return this.repositorio.findByNome(nome);
	}
}
