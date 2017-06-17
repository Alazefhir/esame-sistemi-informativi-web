package it.uniromatre.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController  {
	
	// Login form
	@RequestMapping("/login")
	public String login() {
	    return "Login";
	}
		  
	// Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "Login";
	  }	 
}
