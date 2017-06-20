package it.uniromatre.persistence;

import javax.annotation.PostConstruct;

import it.uniromatre.model.Autore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope (value = "singleton")
public class AutoriRepository  extends CrudRepositoryJPA<Autore> {
	
	@Autowired
	public AutoriRepository() {
		super (Autore.class);
	}
	
	@PostConstruct
	public void setEntityClass() {
		this.entityClass = Autore.class;
	}
}
