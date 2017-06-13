package it.uniromatre.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudRepositoryJPA<T> implements CrudRepository<T> {
	
	@Autowired
	private EntityManagerFactoryUnit emfu;
	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(Class<T> entityClass) {
		
		this.entityClass = entityClass;
	}
	
	@PostConstruct
	public void init(){
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(emfu.toString());
		System.out.println("wtf");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		this.em = this.emfu.getEm();
	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(em.toString());
		System.out.println("wtf^2");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public EntityManagerFactoryUnit getEmfu() {
		return this.emfu;
	}

	public void setEmfu(EntityManagerFactoryUnit emfu) {
		this.emfu = emfu;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}
	
	protected EntityManager getEm() {
		return this.em;
	}
	
	protected Class<T> getEntityClass() {
		return entityClass;
	}

	private String getEntityClassName() {
		return this.entityClass.getSimpleName();
	}


	public T save(T entity) {
		Method getIdMethod = null;
		
		T persistentEntity = null;

		try {
			getIdMethod = this.entityClass.getMethod("getId");
		}
		catch(NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			
			if(getIdMethod.invoke(entity) == null) {
				this.em.persist(entity);
				persistentEntity = entity;
			}
			else {
				persistentEntity = this.em.merge(entity);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return this.em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		Query query = this.em.createQuery("Select e From " + this.entityClass.getName() + " e");
		return query.getResultList();
	}
	
	public List<T> findAttribute (String attribute) {
		Query query = this.em.createQuery
				("Select e From " + this.entityClass.getName() + " e WHERE e." + attribute + " o ORDER BY o" );
		return query.getResultList();
		
	}

	@Override
	public void delete(T entity) {
		this.em.remove(entity);
	}
	
	@Override
	public void delete (Long id) {
		this.em.remove(findOne(id));
	}

	@Override
	public void deleteAll() {
		Query query = this.em.createQuery("Delete e From " + this.entityClass.getName() + " e");
		query.executeUpdate();
	}
	
}