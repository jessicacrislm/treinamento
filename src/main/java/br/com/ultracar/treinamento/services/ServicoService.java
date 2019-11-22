package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Servico;
import br.com.ultracar.treinamento.enumerators.Crud;
import br.com.ultracar.treinamento.repositories.ServicoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ServicoService {

	@Autowired
	private ServicoRepository repositorio;

	public void salvarServico(Servico usuario) {
		this.repositorio.save(usuario);
	}

	public void deletarServico(Servico usuario) {
		this.repositorio.deleteById(usuario.getId());
	}

	public void deletarServicos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Servico> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Servico> findByTipoOperacao(Crud tipoOperacao) {
		return this.repositorio.findByTipoOperacao(tipoOperacao);
	}
	
	public void updateBySolicitante(Long novoSolicitante, Long idSolicitante) {
		this.repositorio.updateBySolicitante(novoSolicitante, idSolicitante);
	}
}
