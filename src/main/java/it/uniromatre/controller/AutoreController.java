package it.uniromatre.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.service.AutoriService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoriService autService;
	
	@GetMapping("/autore")
    public String showForm(Autore autore) {
        return "FormAutore";
    }
	
	@GetMapping("/getAllAutori")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("/autore");
		mv.addObject("autori", autService.getAll());
		return mv;
	}
	
	@GetMapping("/autore/add")
	public ModelAndView add(String nome, String cognome, String nazionalità, Date dataNascita, Date dataMorte) {
		Autore autore = new Autore(nome,cognome,nazionalità,dataNascita,dataMorte);
		ModelAndView mv = new ModelAndView("/FormAutore");
		mv.addObject("autore", autore);
		return mv;
	}
	
	@GetMapping("/autore/add")
	public ModelAndView add(Autore autore) {
		ModelAndView mv = new ModelAndView("/FormAutore");
		mv.addObject("autore", autService.getAll());
		return mv;
	}
	
	@GetMapping("/autore/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		return add(autService.getOne(id));
	}
	
	@GetMapping("/autore/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		//autService.delete(id);
		return getAll();
	}
	
	@PostMapping("/autore/save")
	public ModelAndView save(@Valid Autore autore, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return add(autore);
		}
		autService.inserisci(autore);
		return getAll();
	}
}
