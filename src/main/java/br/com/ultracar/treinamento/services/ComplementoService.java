package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Complemento;
import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.repositories.ComplementoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ComplementoService {

	@Autowired
	private ComplementoRepository repositorio;

	public void salvarComplemento(Complemento complemento) {
		this.repositorio.save(complemento);
	}

	public void deletarComplemento(Complemento complemento) {
		this.repositorio.deleteById(complemento.getId());
	}

	public void deletarComplementos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Complemento> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Complemento> findByEndereco(Endereco endereco) {
		return this.repositorio.findByEndereco(endereco);
	}
	
	public Complemento findByNumeroComplemento(Integer numero, String endereco) {
		return this.repositorio.findByNumeroComplemento(numero, endereco);
	}
}
