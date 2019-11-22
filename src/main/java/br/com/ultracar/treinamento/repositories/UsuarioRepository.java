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
import br.com.ultracar.treinamento.enumerators.Situacao;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, CustomizedUsuarioRepository {

	@Query("Select o From Usuario u " + "Inner Join Fetch u.permissoesAcesso pa " + "Inner Join Fetch pa.operacoes o "
			+ "Where u = :usuario")
	public List<Operacao> findOperacaoByUsuatio(Usuario usuario);

	@Nullable
	@Query("Select u From Usuario u Where u.login = :login")
	public Usuario findByLogin(String login);

	@Query("Select u From Usuario u")
	public Page<Usuario> findAll(Pageable pageable);

	@Query("Select u From Usuario u Where u.situacao like :situacao")
	public List<Usuario> findBySituacao(Situacao situacao);

}
