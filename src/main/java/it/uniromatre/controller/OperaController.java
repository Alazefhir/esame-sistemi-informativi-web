package it.uniromatre.controller;

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
	
	@PostMapping("/opera")
	public String addNewOpera(@Valid Opera opera, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "FormOpera";
		}
		operaService.inserisci(opera);
		model.addAttribute("opera", operaService.getAll());
		return "opera";
	}
	
	@GetMapping("/getAllOpere")
	public String getAllAutori(Model model) {
		model.addAttribute("opere", operaService.getAll());
		return "opere";
	}
	
	@RequestMapping("/opera/delete/{id}")
	public String deleteAutore(@PathVariable("id") Long id) {
		operaService.delete(id);
		return "redirect:/opere";
	}
	
	@RequestMapping("/autore/edit/{id}")
	public String editAutore(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera", operaService.getOne(id));
		model.addAttribute("opere", operaService.getAll());
		return "opera";
	}
}