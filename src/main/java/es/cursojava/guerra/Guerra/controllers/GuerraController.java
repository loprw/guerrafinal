package es.cursojava.guerra.Guerra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class GuerraController {

	@GetMapping("/")
	public String iniciar() {
		return "index";
	}
	
	@GetMapping("/registrar")
	 public String registrar() {
		 System.out.println("Entrando en registro");
		 
		 return "register";
	 }
}
