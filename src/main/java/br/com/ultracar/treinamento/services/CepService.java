package br.com.ultracar.treinamento.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.ultracar.treinamento.dto.CepExternoDTO;
import br.com.ultracar.treinamento.entities.Bairro;
import br.com.ultracar.treinamento.entities.Cep;
import br.com.ultracar.treinamento.entities.Cidade;
import br.com.ultracar.treinamento.entities.Endereco;
import br.com.ultracar.treinamento.entities.Estado;
import br.com.ultracar.treinamento.enumerators.TipoLocal;
import br.com.ultracar.treinamento.repositories.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private BairroService bairroService;

	public void salvarCep(Cep cep) {
		this.repositorio.save(cep);
	}
	
	public Optional<Cep> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public Cep findByNumero(Integer numero) {
		return this.repositorio.findByNumero(numero);
	}

	private Cep findByNumeroExternal(Integer numero) {
		String url = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + numero + "&formato=jsonp";
		CepExternoDTO dto = this.restTemplate.getForObject(url, CepExternoDTO.class);
		
		if (StringUtils.isBlank(dto.getLogradouro())) {
			return null;
		}
		
		Estado estado = Estado.builder().sigla(StringUtils.upperCase(dto.getUf())).build();
		estado = this.estadoService.buscarSalvar(estado);
		
		Cidade cidade = Cidade.builder().nome(StringUtils.upperCase(dto.getCidade())).estado(estado).build();
		cidade = this.cidadeService.buscarSalvar(cidade);
		
		Bairro bairro = Bairro.builder().nome(StringUtils.upperCase(dto.getBairro())).cidade(cidade).build();
		bairro = this.bairroService.buscarSalvar(bairro);
		
		Endereco endereco = Endereco.builder().logradouro(StringUtils.upperCase(dto.getLogradouro()))
				.tipoLocal(TipoLocal.valueOf(StringUtils.upperCase(dto.getTipoLogradouro())))
				.bairros(new HashSet<>(Arrays.asList(bairro))).build();
		endereco = this.enderecoService.buscarSalvar(endereco);
		
		Cep cep = Cep.builder().numero(numero).endereco(endereco).build();
		cep = this.repositorio.save(cep);
		return this.repositorio.findByNumero(cep.getNumero());
	}
}
