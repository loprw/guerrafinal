package es.cursojava.guerra.Guerra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.beans.VehiculoDTO;
import es.cursojava.guerra.Guerra.services.GuerraService;
import jakarta.servlet.http.HttpSession;

@Controller
public class GuerraController {

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
		List<VehiculoDTO> vehiculos = service.obtenerVehiculos();

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

	@GetMapping("/guerra/borrar/{id}")
	public String borrar(Model model, @ModelAttribute VehiculoDTO veh, @PathVariable long id) {

		service.borrarVehiculo(id);
		
		List<VehiculoDTO> vehiculos = service.obtenerVehiculos();
		model.addAttribute("listado", vehiculos);

		return "war_vehicles";
	}
	
	@GetMapping("/guerra/modificar_guerreros")
	public String modificarGuerreros() {
		
		
		return "";
	}
	
	@GetMapping("/guerra/anadir")
	public String añadir(@ModelAttribute VehiculoDTO dto, Model model) {
		model.addAttribute("vehiculo", dto);

		return "agregar_vehiculo";
	}
	
	@PostMapping("/guerra/anadir2")
	public String añadir2(@ModelAttribute VehiculoDTO dto, Model model) {

		service.añadirVehiculo(dto);
		List<VehiculoDTO> vehiculos = service.obtenerVehiculos();
		model.addAttribute("listado", vehiculos);
		
		return "war_vehicles";
	}
	
	@PostMapping("/guerra/enfrentamiento")
	public void comprobarEnfrentamiento() {
		
	}
	
	
	@GetMapping("/guerra/enfrentamiento/{id1}-{id2}")
	public void enfrentar(@PathVariable long id1, @PathVariable long id2) {
		VehiculoDTO vh1 = service.encontrarVehiculo(id1);
		VehiculoDTO vh2 = service.encontrarVehiculo(id2);
		
		service.enfrentamiento(vh1, vh2);
	}
}