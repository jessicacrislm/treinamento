package br.com.ultracar.treinamento.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.ultracar.treinamento.entities.Usuario;

public interface CustomizedUsuarioRepository {

	Page<Usuario> findByFilter (Usuario usuario, Pageable pageable);
	
}
