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

import lombok.Builder;
import lombok.Data;

@Entity
@SuppressWarnings("serial")
@Data
@Builder
@Table(name = "tb_solicitante")
public class Solicitante implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitante_sequence")
	@SequenceGenerator(name = "solicitante_sequence", sequenceName = "solicitante_id_sequence", allocationSize = 1)
	@Column(name = "id_solicitante", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "id_endereco", nullable = false, foreignKey = @ForeignKey(name = "fk_solicitante_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
		
}