package it.uniromatre.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController implements ErrorController {
	
	private static final String PATH = "/error";
	
	// Login form
		  @RequestMapping("/login")
		  public String login() {
		    return "login";
		  }
		  
		  /*@RequestMapping("/error")
		  public String error() {
			  return "error";
			}*/

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
