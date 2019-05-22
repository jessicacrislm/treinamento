package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.ultracar.treinamento.entidades.enumeradores.Situacao;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_permissao_acesso")
public class PermissaoAcesso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_acesso_sequence")
	@SequenceGenerator(name = "permissao_acesso_sequence", sequenceName = "permissao_acesso_id_sequence", allocationSize = 1)
	@Column(name = "id_permissao_acesso", nullable = false)
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_situacao", nullable = false)
	private Situacao situacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

}
