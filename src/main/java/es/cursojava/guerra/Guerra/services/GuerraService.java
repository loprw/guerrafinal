package es.cursojava.guerra.Guerra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.entities.User;
import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;
import es.cursojava.guerra.Guerra.repositories.UserRepository;
import es.cursojava.guerra.Guerra.repositories.VehiculoRepository;

@Service
public class GuerraService {

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private VehiculoRepository vrepo;
	
	public boolean comprobar(UserDTO user) {
				
		if (urepo.existsByNameAndPassword(user.getName(), user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validarEmail(UserDTO user) {
		
		if (user.getPassword().equals(user.getRepeatPassword())) {
			user.setValidated(true);
			return true;
		} else {
			user.setValidated(false);
			return false;
		}
	}
	
	public void agregarUser(UserDTO user) {
		
		User usuario = new User(user.getName(), user.getPassword());
		urepo.save(usuario);
	}
	
	public List<VehiculoGuerra> obtenerVehiculos() {
		
		List<VehiculoGuerra> vehiculos=  vrepo.findAll();
		
		return vehiculos;
	}
}
