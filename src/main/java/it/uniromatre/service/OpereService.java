package it.uniromatre.service;

import javax.annotation.PostConstruct;

import it.uniromatre.model.Opera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope (value = "singleton")
public class OpereService<T> extends BasicService<Opera> {
	
	@Autowired
	public OpereService () {
		super (Opera.class);
	}
	
	@PostConstruct
	public void setEntityClass() {
		this.entityClass = Opera.class;
	}
}
