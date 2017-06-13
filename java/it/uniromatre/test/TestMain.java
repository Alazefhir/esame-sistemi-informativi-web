package it.uniromatre.test;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.service.EntityManagerFactoryUnit;
import it.uniromatre.service.OpereRepository;
import it.uniromatre.service.OpereService;



public class TestMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EntityManagerFactoryUnit emf = (EntityManagerFactoryUnit) context.getBean("entitymanager");
		OpereService service = (OpereService) context.getBean("opereservice");
		//OpereRepository repository = (OpereRepository) context.getBean("crud");
		
		
		Autore autore1 = new Autore();
		Autore autore2 = new Autore();
		Opera opera1 = new Opera();
		Opera opera2 = new Opera();
		Opera opera3 = new Opera();
		Opera opera4 = new Opera();
		
		autore1.setNome("huehue");
		autore1.setOpera(opera1);
		
		opera1.setAutore(autore1);
		opera1.setDescrizione("It's a me, opera!");
		opera1.setNome("Opera Operapolis");
		opera2.setAutore(autore1);
		opera2.setDescrizione("It's a me, opera2!");
		opera2.setNome("Wat.");
		opera3.setAutore(autore1);
		opera3.setDescrizione("It's a me, opera3!");
		opera3.setNome("Terziaria");
		opera1.setAutore(autore1);
		opera1.setDescrizione("It's a me, opera4!");
		opera1.setNome("Alone");
		
		service.inserisciOpera(opera1);
		service.delete(opera1);
		
		context.registerShutdownHook();
		context.close();
	}

}
