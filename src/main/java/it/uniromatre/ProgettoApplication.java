package it.uniromatre;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
