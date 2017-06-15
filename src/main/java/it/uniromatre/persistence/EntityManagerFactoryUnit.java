package it.uniromatre.persistence;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class EntityManagerFactoryUnit {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private String persistenceUnit;
	
	public EntityManagerFactoryUnit(){
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public String getPersistenceUnit() {
		return persistenceUnit;
	}

	public void setPersistenceUnit(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}
	
	@PostConstruct
	public void init(){
		this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
		this.em = emf.createEntityManager();
	}
	
	@PreDestroy
	public void destroy() {
		em.close();
		emf.close();
	}
}
