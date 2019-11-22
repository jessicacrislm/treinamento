package br.com.ultracar.treinamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ultracar.treinamento.entities.Cep;
import br.com.ultracar.treinamento.repositories.CepRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CepService {

	@Autowired
	private CepRepository repositorio;

	public void salvarCep(Cep cep) {
		this.repositorio.save(cep);
	}
	
	public Optional<Cep> findById(Long id) {
		return this.repositorio.findById(id);
	}
	
	public Cep findByNumero(Integer numero) {
		return this.repositorio.findByNumero(numero);
	}
}
