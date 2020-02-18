package br.com.ultracar.treinamento.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SuppressWarnings("serial")
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "tb_estado")
public class Estado implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_sequence")
	@SequenceGenerator(name = "estado_sequence", sequenceName = "estado_id_sequence", allocationSize = 1)
	@Column(name = "id_estado", nullable = false)
	private Long id;
	
	@Max(2)
	@NotBlank
	@Column(name = "ds_sigla", length = 2, nullable = false)
	private String sigla;
	
	@NotBlank
	@Column(name = "ds_nome", nullable = false)
	private String nome;
	
	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private Set<Cidade> cidades = new HashSet<>();

}