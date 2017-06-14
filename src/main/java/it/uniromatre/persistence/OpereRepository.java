package it.uniromatre.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniromatre.model.Opera;

@Service
public class OpereRepository extends CrudRepositoryJPA<Opera> {
	
	@Autowired
	public OpereRepository() {
		super (Opera.class);
	}
}
