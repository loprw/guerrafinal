package es.cursojava.guerra.Guerra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.repositories.UserRepository;

@Service
public class GuerraService {

	@Autowired
	private UserRepository urepo;

	
	public boolean comprobar(UserDTO user) {
				
		if (urepo.findByNameAndPassword(user.getName(), user.getPassword())) {
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
}
