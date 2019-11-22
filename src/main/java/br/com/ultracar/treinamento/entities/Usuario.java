package br.com.ultracar.treinamento.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.enumerators.Situacao;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Builder
@Table(name = "tb_usuario")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_id_sequence", allocationSize = 1)
	@Column(name = "id_usuario", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max =45)
	@Column(name = "ds_login", length = 45, nullable = false)
	private String login;
	
	@NotBlank
	@Column(name = "ds_senha", length = 45, nullable = false)
	private String senha;
	
	@Email
	@Column(name = "ds_email", length = 45)
	private String email;
	
	@NotNull
	@Column(name = "dt_ultimo_acesso", length = 45)
	private Date ultimoAcesso;

	@NotNull
	@Column(name = "lg_administrador", nullable = false)
	private boolean administrador;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_situacao", nullable = false)
	private Situacao situacao;

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<PermissaoAcesso> permissoesAcesso = new HashSet<>();
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<GrupoAcesso> gruposAcesso = new HashSet<>();
	
	@Transient
	private String token;
	
}
