package it.uniromatre.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import it.uniromatre.persistence.CrudRepositoryJPA;
import it.uniromatre.persistence.EntityManagerFactoryUnit;

@Service
public class BasicService<T> implements ServiceInterface<T> {
	
	@Autowired
	private EntityManagerFactoryUnit emfu;
	private EntityManager em;
	private EntityTransaction tx;
	@Autowired
	private CrudRepositoryJPA <T> repository;
	private Class<T> entityClass;

	public BasicService (Class<T> entityClass) {
		
		this.entityClass = entityClass;
	}
	
	@PostConstruct
	public void init() {
		
		em = emfu.getEm();
		this.tx = em.getTransaction();
	}
	
	@Override
	public T inserisci(T entity){

		this.tx.begin();
		
		repository.save(entity);
		//em.persist(opera);
		
		this.tx.commit();
		return entity;
	}
	
	@Override
	public List<T> getAll() {
			
		this.tx.begin();
		
		List<T> entities = repository.findAll();
		
		this.tx.commit();
	
		return entities;
	}
	
	@Override
	public List<T> getByAttribute(String attribute) {
		
		this.tx.begin();
		
		List<T> entities = repository.findAttribute(attribute);
		
		this.tx.commit();
	
		return entities;
	}

	@Override
	public T getOne(Long identifier) {
		
		this.tx.begin();
		
		T entity = repository.findOne(identifier);
		
		this.tx.commit();
		return entity;
	}
	
	@Override
	public void delete (T entity){

		this.tx.begin();
		
		repository.delete(entity);
		
		this.tx.commit();
	}

	public EntityManagerFactoryUnit getEmfu() {
		return emfu;
	}

	public void setEmfu(EntityManagerFactoryUnit emfu) {
		this.emfu = emfu;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public EntityTransaction getTx() {
		return tx;
	}

	public void setTx(EntityTransaction tx) {
		this.tx = tx;
	}

	public CrudRepositoryJPA<T> getRepository() {
		return repository;
	}

	public void setRepository(CrudRepositoryJPA<T> repository) {
		this.repository = repository;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
