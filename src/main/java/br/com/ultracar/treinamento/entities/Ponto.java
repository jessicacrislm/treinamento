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
@Table(name = "tb_ponto")
public class Ponto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_sequence")
	@SequenceGenerator(name = "ponto_sequence", sequenceName = "ponto_id_sequence", allocationSize = 1)
	@Column(name = "id_ponto", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "id_endereco", nullable = false, foreignKey = @ForeignKey(name = "fk_ponto_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
}