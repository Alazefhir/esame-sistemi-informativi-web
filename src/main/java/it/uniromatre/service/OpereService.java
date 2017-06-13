package it.uniromatre.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniromatre.model.Opera;

@Service
public class OpereService {
	
	@Autowired
	private EntityManagerFactoryUnit emfu;
	private EntityManager em;
	private EntityTransaction tx;
	@Autowired
	private CrudRepositoryJPA <Opera> opereRepository;

	public OpereService (){
		
		//TO-DO
	}
	
	@PostConstruct
	public void init() {
		em = emfu.getEm();

		this.tx = em.getTransaction();
	}
	
	public Opera inserisciOpera(Opera opera){
		
		
		this.tx.begin();
		
		opereRepository.save(opera);
		//em.persist(opera);
		
		this.tx.commit();
		return opera;
	}

	public List<Opera> getProdotti() {
			
		this.tx.begin();
		
		List<Opera> prodotti = opereRepository.findAll();
		
		this.tx.commit();
	
		return prodotti;
	}

	public Opera getOneProduct(long identifier) {
		
		this.tx.begin();
		
		Opera Opera = opereRepository.findOne(identifier);
		
		this.tx.commit();
		return Opera;
	}
	
	public void delete (Opera p){

		this.tx.begin();
		
		opereRepository.delete(p);
		
		this.tx.commit();
	}

}
