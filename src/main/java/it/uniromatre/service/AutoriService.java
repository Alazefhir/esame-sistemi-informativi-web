package it.uniromatre.service;

import it.uniromatre.model.Autore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoriService extends BasicService<Autore> {

	@Autowired
	public AutoriService () {
		super (Autore.class);
	}
}