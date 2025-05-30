package es.cursojava.guerra.Guerra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class GuerraController {

	@GetMapping(value="")
	public String inicio() {
		return "index";
	}
	
	 @GetMapping(value="/registrar")
	 public String registro() {
		 System.out.println("Entrando en registro");
		 
		 return "register";
	 }
}
