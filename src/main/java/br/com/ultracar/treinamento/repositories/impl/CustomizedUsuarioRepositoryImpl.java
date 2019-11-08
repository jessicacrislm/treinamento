package br.com.ultracar.treinamento.repositories.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import br.com.ultracar.treinamento.entities.Usuario;
import br.com.ultracar.treinamento.repositories.CustomizedUsuarioRepository;

public class CustomizedUsuarioRepositoryImpl implements CustomizedUsuarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<Usuario> findByFilter(Usuario usuario, Pageable pageable){
		StringBuilder jpql = new StringBuilder();
		Map<String, Object> parameters = new HashMap<>();
		jpql.append("Select usuario From Usuario usuario ");
		jpql.append("Inner Join Fetch usuario.permissoesDeAcesso ");
		jpql.append("Where 1=1 ");
		
		if(StringUtils.isNotBlank(usuario.getLogin())) {
			jpql.append("	And usuario.login = :login ");
			parameters.put("login", usuario.getLogin());
		}
		if(!CollectionUtils.isEmpty(usuario.getPermissoesAcesso())) {
			jpql.append("	And usuario.permissao.id In (:ids) ");
			parameters.put("ids", usuario.getPermissoesAcesso()
					.parallelStream()
					.filter(p -> p.getId() != null)
					.map(p -> String.valueOf(p.getId()))
					.collect(Collectors.joining(", ")));
		}
		
		TypedQuery<Usuario> query = this.entityManager.createQuery(jpql.toString(), Usuario.class);
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		query.setFirstResult(pageable.getPageNumber());
		query.setMaxResults(pageable.getPageSize());
		
		
		return new PageImpl<Usuario>(query.getResultList());
	}
}
