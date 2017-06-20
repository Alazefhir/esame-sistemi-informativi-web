package it.uniromatre.controller;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.service.AutoriService;
import it.uniromatre.service.OpereService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GalleriaController {
	
	@Autowired
	AutoriService autService;
	
	@Autowired
	OpereService opService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/adminpage")
	public String mainPage(){
		return "AdminPage";
	}

	@RequestMapping ("/autori")
	public String showListAutori(@ModelAttribute Autore autore, Model model) {
		model.addAttribute("autori",autService.getAll());
		return "ListAutori";
	}
	
	@RequestMapping ("/opere")
	public String showListAutori(@ModelAttribute Opera opera, Model model) {
		model.addAttribute("opere",opService.getAll());
		return "ListOpere";
	}
	
	//mapping degli import, una request per ogni import?
	@RequestMapping ("/nav")
	public String importHtml(){
		return "navbar";
	}
}
