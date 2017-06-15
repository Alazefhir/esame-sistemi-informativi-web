package it.uniromatre.persistence;

import it.uniromatre.model.Autore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AutoriRepository  extends CrudRepositoryJPA<Autore> {
	
	@Autowired
	public AutoriRepository() {
		super (Autore.class);
	}
}
