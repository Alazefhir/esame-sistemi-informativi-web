package it.uniromatre.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.persistence.EntityManagerFactoryUnit;
import it.uniromatre.service.BasicService;
import it.uniromatre.service.OpereService;
import it.uniromatre.service.AutoriService;



public class TestMainForm {

	
	
	public static void main(String[] args) {
		// OperaODO Auto-generated method stub
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EntityManagerFactoryUnit emf = (EntityManagerFactoryUnit) context.getBean("entitymanager");
		BasicService service = (OpereService) context.getBean("opereservice");
		BasicService serviceAutore = (AutoriService) context.getBean("autoriservice");
		//OpereRepository repository = (OpereRepository) context.getBean("crud");
		
		
		Autore autore1 = new Autore();
		Autore autore2 = new Autore();
		Autore autore3 = new Autore();
		Opera opera1 = new Opera();
		Opera opera2 = new Opera();
		Opera opera3 = new Opera();
		Opera opera4 = new Opera();

		
		autore1.setNome("huehue");
		autore1.setOpera(opera1);
		autore1.setOpera(opera2);
		autore1.setOpera(opera3);
		autore2.setNome("autore poco prolifico");
		autore2.setOpera(opera4);
		autore3.setNome("è costui un autore?");
		
		opera1.setAutore(autore1);
		opera1.setDescrizione("It's a me, opera!");
		opera1.setNome("Opera Operapolis");
		opera2.setAutore(autore1);
		opera2.setDescrizione("It's a me, opera2!");
		opera2.setNome("Wat.");
		opera3.setAutore(autore1);
		opera3.setDescrizione("It's a me, opera3!");
		opera3.setNome("Operaerziaria");
		opera4.setAutore(autore2);
		opera4.setDescrizione("It's a me, opera4!");
		opera4.setNome("Alone");
		
		service.inserisci(opera1);
		service.inserisci(opera2);
		service.inserisci(opera3);
		service.inserisci(opera4);
		serviceAutore.inserisci(autore3);
		
		List<Opera> opere = new ArrayList<Opera>();
		
		/*opere = service.getAll();
		
		//visualizzazione della query
		System.out.println();
		
		for(Opera operaIterativa: opere){
			System.out.println(operaIterativa.toString());
		}*/
		
		System.out.println();
		
		String attribute = "nome";
		
		opere = service.getAll();
		
		//visualizzazione della query
		System.out.println();
				
		for(Opera operaIterativa: opere){
				System.out.println(operaIterativa);
		}
				
		System.out.println();
		
		
		//questo metodo ritorna un errore, è da rivedere
		//sort
		List<Opera> opere2 = (List<Opera>) service.getByAttribute(attribute);

		//visualizzazione della query
		System.out.println();
		
		for(Opera operaIterativa2: opere2){
				System.out.println(operaIterativa2);
		}
		
		
		System.out.println();
		
		//pulizia database
		
		service.delete(opera1);
		service.delete(opera2);
		service.delete(opera3);
		service.delete(opera4);
		
		serviceAutore.delete(autore1);
		serviceAutore.delete(autore2);
		serviceAutore.delete(autore3);
		
		context.registerShutdownHook();
		context.close();
	}

}
