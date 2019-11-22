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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_bairro")
public class Bairro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro_sequence")
	@SequenceGenerator(name = "bairro_sequence", sequenceName = "bairro_id_sequence", allocationSize = 1)
	@Column(name = "id_bairro", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "ds_nome", length = 100, nullable = false)
	@Size(max = 100)
	private String nome;
	
	@NotNull
	@JoinColumn(name = "id_cidade", nullable = false, foreignKey = @ForeignKey(name = "fk_bairro_cidade"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidade cidade;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bairro")
	@Builder.Default
	private Set<Endereco> enderecos = new HashSet<>();
	
}