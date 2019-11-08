package br.com.ultracar.treinamento.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "servico_sequence", sequenceName = "servico_id_sequence", allocationSize = 1)
	@Column(name = "ID_SERVICO", nullable = false)
	private Long id;
	
	@NotNull
	@JoinColumn(name = "ID_ENDERECO", nullable = false, foreignKey = @ForeignKey(name = "fk_servico_endereco"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@NotNull
	@JoinColumn(name = "ID_SOLICITANTE", nullable = false, foreignKey = @ForeignKey(name = "fk_servico_solicitante"))
	@ManyToOne(fetch = FetchType.LAZY)
	private Solicitante solicitante;
	
	@JoinTable(name = "TB_SERVICO_OPERACAO", joinColumns = {
	@JoinColumn(name = "ID_SERVICO", foreignKey = @ForeignKey(name = "fk_servico_operacao_servico"))}, inverseJoinColumns = {
	@JoinColumn(name = "ID_OPERACAO", foreignKey = @ForeignKey(name = "fk_servico_operacao_operacao"))})
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Operacao> operacoes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

}