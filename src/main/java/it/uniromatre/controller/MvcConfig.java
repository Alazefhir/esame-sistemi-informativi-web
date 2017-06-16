package it.uniromatre.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {	
	
	@Bean
	public TemplateResolver templateResolver() {
		TemplateResolver resolver = new TemplateResolver();
		resolver.setResourceResolver(thymeleafResourceResolver());
		//resolver.setApplicationContext(this.applicationContext);
		resolver.setPrefix("classpath:/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(StandardTemplateModeHandlers.LEGACYHTML5.getTemplateModeName());
		resolver.setCacheable(true);
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	@Bean
	public SpringResourceResourceResolver thymeleafResourceResolver() {
		return new SpringResourceResourceResolver();
	}
	
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}
	
	/*@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		//templateEngine.setEnableSpringELCompiler(true);
		templateEngine.setTemplateResolver(templateResolver());
		//templateEngine.seten
		return templateEngine;
	}*/
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] {"*"});
		viewResolver.setCache(false);
		//viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/Login").setViewName("Login");
        registry.addViewController("/FormOpera").setViewName("FormOpera");
        registry.addViewController("/FormAutore").setViewName("FormAutore");
        registry.addViewController("/Autori").setViewName("Autori");
        registry.addViewController("/ListAutori").setViewName("ListAutori");
        registry.addViewController("/Opere").setViewName("Opere");
    }*/
}