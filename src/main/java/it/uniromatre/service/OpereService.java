package it.uniromatre.service;

import it.uniromatre.model.Opera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpereService extends BasicService<Opera> {

	@Autowired
	public OpereService () {
		super (Opera.class);
	}
}
