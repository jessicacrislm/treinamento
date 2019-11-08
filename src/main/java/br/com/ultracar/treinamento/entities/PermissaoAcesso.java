package br.com.ultracar.treinamento.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.ultracar.treinamento.enumerators.Situacao;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_permissao_acesso")
public class PermissaoAcesso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissao_sequence")
	@SequenceGenerator(name = "permissao_sequence", sequenceName = "permissao_id_sequence", allocationSize = 1)
	@Column(name = "id_permissao", nullable = false)
	private Long id;

	@NotNull
	@JoinColumn(name = "ID_USUARIO", nullable = false, foreignKey = @ForeignKey(name = "fk_permissao_acesso_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_situacao", nullable = false)
	private Situacao situacao;

	@NotNull
	@JoinColumn(name = "ID_GRUPO_ACESSO", nullable = false, foreignKey = @ForeignKey(name = "fk_permissao_acesso_grupo_acesso"))
	@ManyToOne(fetch = FetchType.LAZY)
	private GrupoAcesso grupoAcesso;

	@JoinTable(name = "TB_PERMISSAO_ACESSO_OPERACAO", joinColumns = { 
	@JoinColumn(name = "ID_PERMISSAO_ACESSO", foreignKey = @ForeignKey(name = "fk_operacao_permissao_acesso_operacao")) }, inverseJoinColumns = { 
	@JoinColumn(name = "ID_OPERACAO", foreignKey = @ForeignKey(name = "fk_permissao_acesso_permissao_acesso_operacao")) })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Operacao> operacoes = new HashSet<>();

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GrupoAcesso getGrupoAcesso() {
		return grupoAcesso;
	}

	public void setGrupoAcesso(GrupoAcesso grupoAcesso) {
		this.grupoAcesso = grupoAcesso;
	}

}
