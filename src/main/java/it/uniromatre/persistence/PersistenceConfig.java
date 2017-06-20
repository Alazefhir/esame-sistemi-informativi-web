package it.uniromatre.persistence;

import it.uniromatre.model.Autore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;




@Configuration

public class PersistenceConfig {
	
	/*@Bean ({"CrudRepositoryJPA"})
	@Scope ("Singleton")
	@Lazy
	public CrudRepositoryJPA CrudRepositoryJPA(T t) {

		CrudRepositoryJPA crud = new CrudRepositoryJPA ((Class) t);
		
		return crud;
	}
	
	@Bean ({"AutoriRepository"})
	@Scope ("Singleton")
	@Lazy
	public CrudRepositoryJPA AutoriRepository() {
		
		CrudRepositoryJPA crud = new AutoriRepository ();
		
		return crud;
	}
	
	@Bean ({"OpereRepository"})
	@Scope ("Singleton")
	@Lazy
	public CrudRepositoryJPA OpereRepository() {
		
		CrudRepositoryJPA crud = new OpereRepository ();
		
		return crud;
	}*/
	
}
