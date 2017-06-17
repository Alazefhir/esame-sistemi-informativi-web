package it.uniromatre.service;

import it.uniromatre.model.Autore;
import it.uniromatre.persistence.CrudRepositoryJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AutoriService<T> extends BasicService<Autore> {

	
	@Autowired
	public AutoriService () {
		super ();
	}
}
