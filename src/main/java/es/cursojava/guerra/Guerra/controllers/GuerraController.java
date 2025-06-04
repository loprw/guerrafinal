package es.cursojava.guerra.Guerra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;
import es.cursojava.guerra.Guerra.services.GuerraService;
import jakarta.servlet.http.HttpSession;

@Controller
public class GuerraController {

	@Autowired
	private UserDTO user;

	@Autowired
	private GuerraService service;

	@GetMapping("/guerra")
	public String iniciar(@ModelAttribute("usuario") UserDTO user) {
		return "war";
	}

	@GetMapping("/guerra/registrar")
	public String registrar(@ModelAttribute("usuario") UserDTO user) {
		System.out.println("Entrando en registro");

		return "register";
	}

	@PostMapping("/guerra/comprobar_usuario")
	public String comprobar(@ModelAttribute("usuario") UserDTO user, Model model, HttpSession session) {
		user = (UserDTO) model.getAttribute("usuario");
		List<VehiculoGuerra> vehiculos = service.obtenerVehiculos();

		if (service.comprobar(user)) {
			model.addAttribute("listado", vehiculos);
			return "war_vehicles";
		} else {
			return "war";
		}
	}

	@PostMapping("/guerra/registrar_usuario")
	public String registrarUsuario(@ModelAttribute("usuario") UserDTO user) {
		service.validarEmail(user);

		if (!user.isValidated()) {
			return "register";
		} else {
			service.agregarUser(user);
			return "war";
		}
	}

	@GetMapping("/guerra/borrar")
	public String borrar(Model model, @ModelAttribute VehiculoGuerra veh) {

		service.borrarVehiculo(veh.getId());
		
		List<VehiculoGuerra> vehiculos = service.obtenerVehiculos();
		model.addAttribute("listado", vehiculos);

		return "war_vehicles";
	}
	
	@GetMapping("/guerra/modificar_guerreros")
	public String modificarGuerreros() {
		
		
		return "";
	}
	
	@GetMapping("/guerra/anadir")
	public String añadir() {
		
		
		return "agregar_vehiculo";
	}
	
	@GetMapping("/guerra/enfrentamiento")
	public void enfrentar() {
		
	}
}