package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Operacao;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.enumerators.Crud;
import br.com.ultracar.treinamento.repositories.OperacaoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OperacaoService {

	@Autowired
	private OperacaoRepository repositorio;

	public void salvarOperacao(Operacao operacao) {
		this.repositorio.save(operacao);
	}

	public void deletarOperacao(Operacao operacao) {
		this.repositorio.deleteById(operacao.getId());
	}

	public void deletarOperacaos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Operacao> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Operacao> findByTipo(Crud tipoOperacao) {
		return this.repositorio.findByTipo(tipoOperacao);
	}
	
	public List<Operacao> findByDescricao(String descricao) {
		return this.repositorio.findByDescricao(descricao);
	}
	
	public List<Operacao> findByUsuario(Usuario usuario) {
		return this.repositorio.findByUsuario(usuario);
	}
}
