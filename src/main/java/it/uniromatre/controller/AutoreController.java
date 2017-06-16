package it.uniromatre.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.uniromatre.model.Autore;
import it.uniromatre.service.AutoriService;

@Controller
public class AutoreController {
	
	@Autowired
	private AutoriService autService;
	
	@GetMapping("/autore")
	public String showFormAutore(Autore autore) {
		return "FormAutore";
	}
	
	@PostMapping("/autore")
	public String addNewAutore(@Valid Autore autore, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "FormAutore";
		}
		autService.inserisci(autore);
		model.addAttribute("autori", autService.getAll());
		return "autori";
	}
	
	@GetMapping("/getAllAutori")
	public String getAllAutori(Model model) {
		model.addAttribute("autori", autService.getAll());
		return "autori";
	}
	
	@RequestMapping("/autore/delete/{id}")
	public String deleteAutore(@PathVariable("id") Long id, Model model) {
		autService.delete(id);
		model.addAttribute("autori", autService.getAll());
		return "redirect:/autori";
	}
	
	@RequestMapping("/autore/edit/{id}")
	public String editAutore(@PathVariable("id") Long id, Model model) {
		model.addAttribute("autore", autService.getOne(id));
		model.addAttribute("autori", autService.getAll());
		return "autore";
	}
	
	
}
