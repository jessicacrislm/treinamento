package br.com.ultracar.treinamento.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ultracar.treinamento.entidades.Operacao;
import br.com.ultracar.treinamento.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("Select operacao From Usuario usuario " + "Inner Join usuario.permissoesDeAcesso permissoesDeAcesso "
			+ "Inner Join permissoesDeAcessos.operacoes operacoes " + "Where usuario = :usuario")
	public List<Operacao> findOperacaoByUsuario(Usuario usuario);

	@Query("Select operacao From Usuario usuario " + "Inner Join usuario.permissoesDeAcesso permissoesDeAcesso "
			+ "Inner Join permissoesDeAcessos.operacoes operacoes " + "Where usuario.id = :idUsuario")
	public List<Operacao> findOperacaoByIdUsuario(Long idUsuario);
	
	@Query("Select usuario From Usuario usuario" + "Inner Join usuario.permissoesDeAcesso permissoesDeAcesso "
			+ "Inner Join permissoesDeAcessos.operacoes operacoes " + "Where operacoes.descricao like :descricaoOperacao")
	public List<Usuario> findByOperacao (String descricaoOperacao);
}
