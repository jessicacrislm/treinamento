package br.com.ultracar.treinamento.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "tb_grupoAcesso")
public class GrupoAcesso implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupoAcesso_sequence")
	@SequenceGenerator(name = "permissao_sequence", sequenceName = "grupoAcesso_id_sequence", allocationSize = 1)
	@Column(name = "id_grupoAcesso", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max =45)
	@Column(name = "tp_descricao", nullable = false)
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoAcesso")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@NotNull
	@JoinColumn(name = "ID_USUARIO", nullable = false, foreignKey = @ForeignKey(name = "fk_grupo_acesso_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<PermissaoAcesso> getPermissoesAcesso() {
		return permissoesAcesso;
	}

	public void setPermissoesAcesso(Set<PermissaoAcesso> permissoesAcesso) {
		this.permissoesAcesso = permissoesAcesso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
