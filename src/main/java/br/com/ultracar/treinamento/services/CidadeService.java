package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
