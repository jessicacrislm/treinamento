package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.GrupoAcesso;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.repositories.GrupoAcessoRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GrupoAcessoService {

	@Autowired
	private GrupoAcessoRepository repositorio;

	public void salvarGrupoAcesso(GrupoAcesso grupoAcesso) {
		this.repositorio.save(grupoAcesso);
	}

	public void deletarGrupoAcesso(GrupoAcesso grupoAcesso) {
		this.repositorio.deleteById(grupoAcesso.getId());
	}

	public void deletarGrupoAcessos(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<GrupoAcesso> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Usuario> findBySituacao(GrupoAcesso grupoAcesso) {
		return this.repositorio.findUsuarioByGrupoAcesso(grupoAcesso);
	}
	
	public List<GrupoAcesso> findGrupoAcessoByDescricao(String descricao) {
		return this.repositorio.findGrupoAcessoByDescricao(descricao);
	}
}
