package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.entities.Ponto;
import br.com.ultracar.treinamento.enumerators.Situacao;
import br.com.ultracar.treinamento.repositories.PontoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PontoService {

	@Autowired
	private PontoRepository repositorio;

	public void salvarPonto(Ponto ponto) {
		this.repositorio.save(ponto);
	}

	public void deletarPonto(Ponto ponto) {
		this.repositorio.deleteById(ponto.getId());
	}

	public void deletarPontos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Ponto> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public boolean deleteByCidade (Cidade cidade) {
		return this.deleteByCidade(cidade);
	}
	
	public List<Ponto> findByEndereco(Endereco endereco) {
		return this.repositorio.findByEndereco(endereco);
	}
}
