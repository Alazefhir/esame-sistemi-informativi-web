package it.uniromatre.service;

import javax.annotation.PostConstruct;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.persistence.CrudRepositoryJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope (value = "singleton")
public class AutoriService<T> extends BasicService<Autore> {

	
	@Autowired
	public AutoriService () {
		super (Autore.class);
	}
	
	@PostConstruct
	public void setEntityClass() {
		this.entityClass = Autore.class;
	}
}
