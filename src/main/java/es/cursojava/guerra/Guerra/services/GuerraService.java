package es.cursojava.guerra.Guerra.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursojava.guerra.Guerra.beans.Destructor;
import es.cursojava.guerra.Guerra.beans.Tanque;
import es.cursojava.guerra.Guerra.beans.UserDTO;
import es.cursojava.guerra.Guerra.beans.VehiculoDTO;
import es.cursojava.guerra.Guerra.entities.User;
import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;
import es.cursojava.guerra.Guerra.repositories.UserRepository;
import es.cursojava.guerra.Guerra.repositories.VehiculoRepository;

@Service
public class GuerraService {

	private static final Logger logger = LoggerFactory.getLogger(GuerraService.class);

	@Autowired
	private UserRepository urepo;

	@Autowired
	private VehiculoRepository vrepo;
	
	private VehiculoGuerra vehiculo = new VehiculoGuerra();
	
	@Autowired
	private VehiculoDTO vhdto;

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

	public List<VehiculoDTO> obtenerVehiculos() {

		List<VehiculoGuerra> veh = vrepo.findAll();
		List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();
		
		for (VehiculoGuerra vehiculo : veh) {
			vehiculos.add(convertVhEntityToDto(vehiculo));
		}

		return vehiculos;
	}

	public VehiculoDTO encontrarVehiculo(long id) {

		return convertVhEntityToDto(vrepo.findById(id));
	}

	public void borrarVehiculo(long id) {
		
		vrepo.deleteById(id);
	}
	
	public void añadirVehiculo(VehiculoDTO dto) {
		VehiculoGuerra veh = convertVhDtoToEntity(dto);
		
//		if (veh.getTipo().equals("Destructor")) {
//			Destructor destr = (Destructor) veh;
//			VehiculoGuerra vh = destr;
//			vrepo.save(vh);
//		} else {
//			Tanque tanque = (Tanque) veh;
//			VehiculoGuerra vh = tanque;
//			vrepo.save(vh);
//		}	
		vrepo.save(veh);
	}

	//Revisar

	public void enfrentamiento(VehiculoDTO vehiculo1, VehiculoDTO vehiculo2) {
		
		VehiculoGuerra vh1 = convertVhDtoToEntity(vehiculo1);
		VehiculoGuerra vh2 = convertVhDtoToEntity(vehiculo2);		
		
		boolean vehiculoUnoDestruido = false;
		boolean vehiculoDosDestruido = false;
		int contador = 1;

		logger.info("Empieza la guerra:\n");

		while (!vehiculoUnoDestruido || !vehiculoDosDestruido) {

			logger.info("\tEmpieza el turno " + contador++ + " del enfrentamiento:");

			int ataque = vh1.atacar();
			int defensa = vh2.defender(ataque);
			vh2.recibirDany(ataque, defensa);

			if (vh2.getPuntosVida() <= 0) {
				vehiculoDosDestruido = true;
			}

			if (vehiculoDosDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vehiculo2.getNombre() + " ha sido destruido.\n");
				break;
			}

			int ataque2 = vh2.atacar();
			int defensa2 = vh1.defender(ataque2);
			vh1.recibirDany(ataque2, defensa2);

			if (vh1.getPuntosVida() <= 0) {
				vehiculoUnoDestruido = true;
			}

			if (vehiculoUnoDestruido) {
				logger.info("\n\t\t\tEl vehículo " + vh1.getNombre() + " ha sido destruido.\n");
				break;
			}
		}
	}
	
	private VehiculoGuerra convertVhDtoToEntity(VehiculoDTO dto) {
		
		vehiculo.setId(dto.getId());
		vehiculo.setNombre(dto.getNombre());
		vehiculo.setPuntosVida(dto.getPuntosVida());
		vehiculo.setAtaque(dto.getAtaque());
		vehiculo.setDefensa(dto.getDefensa());
		vehiculo.setTipo(dto.getTipo());
		vehiculo.setGuerrerosEmbarcados(dto.getGuerrerosEmbarcados());
		
		return vehiculo;
	}
	
	private VehiculoDTO convertVhEntityToDto(VehiculoGuerra vh) {
		
		vhdto.setId(vh.getId());
		vhdto.setNombre(vh.getNombre());
		vhdto.setPuntosVida(vh.getPuntosVida());
		vhdto.setAtaque(vh.getAtaque());
		vhdto.setDefensa(vh.getDefensa());
		vhdto.setTipo(vh.getTipo());
		vhdto.setGuerrerosEmbarcados(vh.getGuerrerosEmbarcados());
		
		return vhdto;
	}
}
