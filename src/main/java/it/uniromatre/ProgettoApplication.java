package it.uniromatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@SpringBootTest
@ImportResource("Beans.xml")
@SpringBootApplication
public class ProgettoApplication  {
	
	//@Test
	public static void main(String args[]) {

		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		SpringApplication.run(ProgettoApplication.class, args);
		//System.out.print("hello");
		//context.close();
	}

}
