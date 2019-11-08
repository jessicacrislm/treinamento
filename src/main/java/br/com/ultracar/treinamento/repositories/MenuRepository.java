package br.com.ultracar.treinamento.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Menu;
import br.com.ultracar.treinamento.entities.PermissaoAcesso;
import br.com.ultracar.treinamento.entities.Usuario;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	@Query("Select m From Menu m "
		 + "Inner Join m.permissaoAcesso pa "
		 + "Where pa = :permissao")
	public List<Menu> findByPermissaoAcesso(PermissaoAcesso permissao);
	
	@Query("Select m From Menu m Where m.descricao = :descricao")
	public List<Menu> findByDescricao(String descricao);
	
	@Query("Select m From Menu m "
		 + "Inner Join m.permissaoAcesso pa "
		 + "Inner Join pa.usuario u "
		 + "Where u = :usuario")
	public List<Menu> findByUsuario(Usuario usuario);
	
}