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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tb_cep")
public class Cep implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cep_sequence")
	@SequenceGenerator(name = "cep_sequence", sequenceName = "cep_id_sequence", allocationSize = 1)
	@Column(name = "id_cep", nullable = false)
	private Long id;
	
	@NotBlank
	@Column(name = "nm_numero")
	private Integer numero;
	
	@NotNull
	@JsonManagedReference
	@JoinColumn(name = "id_endereco", nullable = false, foreignKey = @ForeignKey(name = "fk_cep_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;

}