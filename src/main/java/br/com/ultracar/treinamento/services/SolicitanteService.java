package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.entities.Solicitante;
import br.com.ultracar.treinamento.repositories.SolicitanteRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SolicitanteService {

	@Autowired
	private SolicitanteRepository repositorio;

	public void salvarSolicitante(Solicitante solicitante) {
		this.repositorio.save(solicitante);
	}

	public void deletarSolicitante(Solicitante solicitante) {
		this.repositorio.deleteById(solicitante.getId());
	}

	public void deletarSolicitantes(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Solicitante> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Solicitante> findByEndereco(Endereco endereco) {
		return this.repositorio.findByEndereco(endereco);
	}
}
