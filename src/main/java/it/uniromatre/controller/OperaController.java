package it.uniromatre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.uniromatre.model.Autore;
import it.uniromatre.model.Opera;
import it.uniromatre.service.AutoriService;
import it.uniromatre.service.OpereService;

@Controller
public class OperaController {

	@Autowired
	OpereService operaService;
	@Autowired
	AutoriService autService;
	
	@GetMapping("/opera")
    public String showForm(Opera opera) {
        return "FormOpera";
    }
	
	@PostMapping("/opera")
	public String addNewOpera(@Valid Opera opera, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "FormOpera";
		}
		operaService.inserisci(opera);
		model.addAttribute("opere", operaService.getAll());
		model.addAttribute("autori", autService.getAll());
		return "Opere";
	}
	
	@GetMapping("/getAllOpere")
	public String getAllOpere(Model model) {
		model.addAttribute("opere", operaService.getAll());
		model.addAttribute("autori", autService.getAll());
		return "Opere";
	}
	
	@RequestMapping("/opera/delete/{id}")
	public String deleteOpera(@PathVariable("id") Long id, Model model) {
		operaService.delete(id);
		model.addAttribute("opere", operaService.getAll());
		model.addAttribute("autori", autService.getAll());
		return "Opere";
	}
	
	@RequestMapping("/opera/edit/{id}")
	public String editOpera(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera", operaService.getOne(id));
		model.addAttribute("opere", operaService.getAll());
		return "FormOpera";
	}
	
	@RequestMapping("/opera/assign/{idautore}_{idopera}")
	public String assegnaAutore( @PathVariable("idautore") Long idautore, @PathVariable("idopera") Long idopera ,
			Model model,  HttpServletRequest request){
		
		Opera opera = (Opera) operaService.getOne(idopera);
		Autore autore = (Autore) autService.getOne(idautore);
		if (opera!=null)
			opera.setAutore(autore);
		else{
			System.out.println();System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("è nullo, signore.");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
		model.addAttribute("opere", operaService.getAll());
		model.addAttribute("autori", autService.getAll());
		return "Opere";
	}
}