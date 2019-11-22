package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.PermissaoAcesso;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.enumerators.Situacao;
import br.com.ultracar.treinamento.repositories.PermissaoAcessoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PermissaoAcessoService {

	@Autowired
	private PermissaoAcessoRepository repositorio;

	public void salvarPermissaoAcesso(PermissaoAcesso permissaoAcesso) {
		this.repositorio.save(permissaoAcesso);
	}

	public void deletarPermissaoAcesso(PermissaoAcesso permissaoAcesso) {
		this.repositorio.deleteById(permissaoAcesso.getId());
	}

	public void deletarPermissaoAcessos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<PermissaoAcesso> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<PermissaoAcesso> findByUsuario(Usuario usuario) {
		return this.repositorio.findByUsuario(usuario);
	}
	
	public List<PermissaoAcesso> findBySituacao(Situacao situacao) {
		return this.repositorio.findBySituacao(situacao);
	}
}
