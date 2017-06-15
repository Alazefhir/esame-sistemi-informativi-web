package it.uniromatre.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.uniromatre.model.Opera;

@Repository
public class OpereRepository extends CrudRepositoryJPA<Opera> {
	
	@Autowired
	public OpereRepository() {
		super (Opera.class);
	}
}
