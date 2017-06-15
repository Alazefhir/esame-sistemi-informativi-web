package it.uniromatre.service;

import java.util.List;

public interface ServiceInterface <T> {

	public void init();
	public T inserisci(T entity);
	public List <T> getAll();
	public List <T> getByAttribute(String s);
	public T getOne(Long id);
	public void delete(T entity);
	public void delete(Long id);
}
