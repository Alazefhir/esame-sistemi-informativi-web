package it.uniromatre.persistence;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;

@Repository
@Scope (value = "singleton")
public class OpereRepository extends CrudRepositoryJPA<Opera> {
	
	@Autowired
	public OpereRepository() {
		super (Opera.class);
	}
	
	@PostConstruct
	public void setEntityClass() {
		this.entityClass = Opera.class;
	}
}
