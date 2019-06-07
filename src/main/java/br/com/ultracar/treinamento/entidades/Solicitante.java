package br.com.ultracar.treinamento.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "tb_solicitante")
public class Solicitante implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitante_sequence")
	@SequenceGenerator(name = "solicitante_sequence", sequenceName = "solicitante_id_sequence", allocationSize = 1)
	@Column(name = "id_solicitante", nullable = false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
