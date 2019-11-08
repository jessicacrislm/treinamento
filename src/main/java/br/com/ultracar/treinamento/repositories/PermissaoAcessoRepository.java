package br.com.ultracar.treinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.PermissaoAcesso;
import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.enumerators.Situacao;

@Repository
public interface PermissaoAcessoRepository extends JpaRepository<PermissaoAcesso, Long> {

	@Query("Select pa From PermissaoAcesso pa "
		 + "Inner Join pa.usuario u "
		 + "Where u = :usuario")
	public List<PermissaoAcesso> findPermissaoAcessoByUsuario(Usuario usuario);
	
	@Query("Select pa From PermissaoAcesso pa Where pa.situacao = :situacao")
	public List<PermissaoAcesso> findPermissaoAcessoBySituacao(Situacao situacao);
	
}