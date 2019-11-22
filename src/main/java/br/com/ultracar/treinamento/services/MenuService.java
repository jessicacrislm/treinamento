package br.com.ultracar.treinamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Menu;
import br.com.ultracar.treinamento.entities.PermissaoAcesso;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.repositories.MenuRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MenuService {

	@Autowired
	private MenuRepository repositorio;

	public void salvarMenu(Menu menu) {
		this.repositorio.save(menu);
	}

	public void deletarMenu(Menu menu) {
		this.repositorio.deleteById(menu.getId());
	}

	public void deletarMenus(List<Long> ids) {
		ids.stream().filter(this.repositorio::existsById).parallel().forEach(this.repositorio::deleteById);
	}
	
	public Optional<Menu> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public List<Menu> findByPermissaoAcesso(PermissaoAcesso permissao) {
		return this.repositorio.findByPermissaoAcesso(permissao);
	}
	
	public List<Menu> findByDescricao(String descricao) {
		return this.repositorio.findByDescricao(descricao);
	}
	
	public List<Menu> findByUsuario(Usuario usuario) {
		return this.repositorio.findByUsuario(usuario);
	}
}
