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

import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Builder
@Table(name = "tb_grupoAcesso")
public class GrupoAcesso implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_acesso_sequence")
	@SequenceGenerator(name = "grupo_acesso_sequence", sequenceName = "grupo_acesso_id_sequence", allocationSize = 1)
	@Column(name = "id_grupo_acesso", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max =45)
	@Column(name = "ds_descricao", nullable = false)
	private String descricao;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo_acesso")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@NotNull
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "fk_grupo_acesso_usuario"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

}
