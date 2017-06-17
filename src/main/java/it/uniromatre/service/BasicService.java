package it.uniromatre.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniromatre.persistence.CrudRepositoryJPA;
import it.uniromatre.persistence.OpereRepository;


public class BasicService<T> implements ServiceInterface<T> {
	
	private EntityManager em;
	@Autowired
	private CrudRepositoryJPA <T> repository;
	
	

	public BasicService () {
	
	}
	
	//deprecato
	@PostConstruct
	public void init() {}
	
	@Override
	@Transactional
	public T inserisci(T entity){

		repository.save(entity);
		return entity;
	}
	
	@Override
	@Transactional
	public List<T> getAll() {
		List<T> entities = repository.findAll();
		return entities;
	}
	
	@Override
	@Transactional
	public List<T> getByAttribute(String attribute) {
		List<T> entities = repository.findAttribute(attribute);
		return entities;
	}

	@Override
	@Transactional
	public T getOne(Long identifier) {	
		T entity = repository.findOne(identifier);	
		return entity;
	}
	
	@Override
	@Transactional
	public void delete (T entity){
		
		repository.delete(entity);
	}
	
	@Override
	@Transactional
	public void delete (Long id){
		
		repository.delete (id);
	}

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public CrudRepositoryJPA<T> getRepository() {
		return repository;
	}

	public void setRepository(CrudRepositoryJPA<T> repository) {
		this.repository = repository;
	}
}
