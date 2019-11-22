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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ultracar.treinamento.enumerators.TipoLocal;
import lombok.Builder;
import lombok.Data;

@Entity
@SuppressWarnings("serial")
@Data
@Builder
@Table(name = "tb_endereco")
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
	@SequenceGenerator(name = "endereco_sequence", sequenceName = "endereco_id_sequence", allocationSize = 1)
	@Column(name = "id_endereco", nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 128)
	@Column(name = "ds_logradouro", length = 128, nullable = false)
	private String logradouro;

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Complemento> complementos = new HashSet<>();
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "en_tipo_local", length = 10, nullable = false)
	private TipoLocal tipoLocal;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
	private Set<Cep> ceps = new HashSet<>();
	
	@Builder.Default
	@JoinTable(name = "tb_endereco_bairro", joinColumns = { 
	@JoinColumn(name = "id_endereco", foreignKey = @ForeignKey(name = "fk_bairro_endereco_bairro")) }, inverseJoinColumns = { 
	@JoinColumn(name = "id_bairro", foreignKey = @ForeignKey(name = "fk_endereco_endereco_bairro")) })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Bairro> bairros = new HashSet<>();
	
}	
