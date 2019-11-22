package br.com.ultracar.treinamento.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Entity
@SuppressWarnings("serial")
@Data
@Builder
@Table(name = "tb_cidade")
public class Cidade implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade_sequence")
	@SequenceGenerator(name = "cidade_sequence", sequenceName = "cidade_id_sequence", allocationSize = 1)
	@Column(name = "id_cidade", nullable = false)
	private Long id;
	
	@Size(min = 5, max = 38)
	@Column(name = "ds_nome", length = 38, nullable = false)
	private String nome;

	@NotNull
	@JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name = "fk_cidade_estado"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Estado estado;
	
}