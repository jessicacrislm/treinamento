package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ultracar.treinamento.entidades.Menu;
import br.com.ultracar.treinamento.entidades.Usuario;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	@Query("Select menu From Menu menu" 
			+ "Inner Join menu.permissaoAcesso permissaoAcesso "
			+ "Inner Join permissaoAcesso.grupoAcesso grupoAcesso " 
			+ "Inner Join grupoAcesso.usuario usuario "
			+ "Where usuario = :usuario")
	public List<Menu> findMenuByUsuario(Usuario usuario);
	
	@Query("Select menu From Menu menu" 
			+ "Inner Join menu.permissaoAcesso permissaoAcesso "
			+ "Inner Join permissaoAcesso.grupoAcesso grupoAcesso " 
			+ "Inner Join grupoAcesso.usuario usuario "
			+ "Where usuario.id = :IdUsuario")
	public List<Menu> findMenuByIdUsuario(Long IdUsuario);
}
