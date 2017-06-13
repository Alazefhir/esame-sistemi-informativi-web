package it.uniromatre.service;

import it.uniromatre.model.Opera;


public class OpereRepository extends CrudRepositoryJPA<Opera> {

	/*public OpereRepository(EntityManager em) {
		super(em, Opere.class);
	}*/
	
	public OpereRepository() {
		super (Opera.class);
	}
}
