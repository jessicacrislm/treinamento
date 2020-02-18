package br.com.ultracar.treinamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@SuppressWarnings("serial")
public class CepExternoDTO {
	
	private String uf;
	
	private String cidade;
	
	private String bairro;
	
	@JsonProperty("tipo_logradouro")
	private String tipoLogradouro;
	
	private String logradouro;

}
