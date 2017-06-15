package it.uniromatre.controller;

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
import it.uniromatre.service.OpereService;

@Controller
public class OperaController {

	@Autowired
	OpereService operaService;
	
	@GetMapping("/opera")
    public String showForm(Autore autore) {
        return "FormOpera";
    }
	
	@GetMapping("/getAllOpere")
	public ModelAndView getAll() {
		ModelAndView mv = new ModelAndView("/opera");
		mv.addObject("opere", operaService.getAll());
		return mv;
	}
	
	@GetMapping("/opera")
	public ModelAndView add(String titolo, Integer anno, String tecnica, String dimensione, Autore Autore) {
		Opera opera = new Opera (titolo,anno,tecnica,dimensione,Autore);
		ModelAndView mv = new ModelAndView("/FormOpera");
		mv.addObject("opera", opera);
		return mv;
	}
	
	@GetMapping("/opera")
	public ModelAndView add(Opera opera) {
		ModelAndView mv = new ModelAndView("/FormOpera");
		mv.addObject("opera", opera);
		return mv;
	}
	
	@GetMapping("/opera/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		return add(operaService.getOne(id));
	}
	
	@GetMapping("/opera/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		//operaService.delete(id);
		return getAll();
	}
	
	@PostMapping("/opera/save")
	public ModelAndView save(@Valid Opera opera, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return add(opera);
		}
		operaService.inserisci(opera);
		return getAll();
	}
	
	
}
