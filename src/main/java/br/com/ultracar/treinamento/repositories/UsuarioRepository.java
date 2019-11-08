package br.com.ultracar.treinamento.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entities.Operacao;
import br.com.ultracar.treinamento.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, CustomizedUsuarioRepository {

	@Query("Select operacoes From Usuario usuario " + "Inner Join ususario.permissoesAcesso permissoesAcesso "
			+ "Inner Join permissoesAcesso.operacoes operacoes " + "Where usuario = :usuario ")
	public List<Operacao> findOperacaoByUsuatio(Usuario usuario);

	@Nullable
	@Query("Select u From Usuario u Where u.login = :login")
	public Usuario findByLogin(String login);

	@Query("Select u From Usuario u")
	public Page<Usuario> findAll(Pageable pageable);

}
