package it.uniromatre.persistence;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class CrudRepositoryJPA<T> implements CrudRepository<T> {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Class<T> entityClass;
	
	public CrudRepositoryJPA(Class<T> entityClass) {
		
		this.entityClass = entityClass;
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
				
		TypedQuery<T> query =  this.em.createQuery ("Select e From " + this.entityClass.getName() + " e", this.entityClass);
		
		return query.getResultList();
	}
	
	@Override

	public List<T> findAttribute (String attribute) {
		
		TypedQuery<T> query =  this.em.createQuery
				("Select e From " + this.entityClass.getName() + " e ORDER BY e." + attribute, this.entityClass);
		
		return query.getResultList();
	}
	
	//questa implementazione presenta problemi con le entità "detached"
	//mentre la implementazione tramite id non presenta problemi
	//lascerò la vecchia implementazione commentata come memento
	@Override

	public void delete(T entity) {
		
		//this.em.remove(entity);
		
		Method getIdMethod = null;

		try {
			getIdMethod = this.entityClass.getMethod("getId");
		}
		catch(NoSuchMethodException | SecurityException e) {
			//e.printStackTrace();
		}

		try {
			
			this.delete((Long)getIdMethod.invoke(entity));
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			//e.printStackTrace();
		}
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
	
	//getters and setters
	
	//deprecato
	@PostConstruct
	public void init(){
		
		//this.em = this.emfu.getEm();
	}
	
	public EntityManagerFactory getEmf() {
		return this.emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext
	protected void setEm(EntityManager em) {
		this.em = em;
	}
	
	protected EntityManager getEm() {
		return this.em;
	}
	
	protected Class<T> getEntityClass() {
		return entityClass;
	}
	
}