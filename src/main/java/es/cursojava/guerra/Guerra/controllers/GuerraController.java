package es.cursojava.guerra.Guerra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.services.GuerraService;
import jakarta.servlet.http.HttpSession;

@Controller
public class GuerraController {
	
	@Autowired
	private UserDTO user;

	@Autowired
	private GuerraService service;
	
	@GetMapping("/guerra")
	public String iniciar(@ModelAttribute("usuarioComprobar") UserDTO user) {
		return "war";
	}
	
	@GetMapping("/guerra/registrar")
	 public String registrar(@ModelAttribute("nuevoUsuario") UserDTO user) {
		 System.out.println("Entrando en registro");
		 
		 return "register";
	 }
	
	@PostMapping("/guerra/comprobar_usuario")
	public String comprobar(@ModelAttribute("usuarioComprobar") UserDTO user, Model model, HttpSession session) {
		user = (UserDTO) model.getAttribute("usuarioComprobar");
		
		if (service.comprobar(user)) {
			return "war_vehicles";
		} else {
			return "war";
		}
	}
	
	@PostMapping("/guerra/registrar_usuario")
	public String registrarUsuario(@ModelAttribute("nuevoUsuario") UserDTO user) {
		service.validarEmail(user);
		
		if (!user.isValidated()) {
			return "register";
		} else {
			return "war";
		}
	}
}