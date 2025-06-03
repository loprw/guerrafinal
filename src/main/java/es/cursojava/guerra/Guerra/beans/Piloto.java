package es.cursojava.guerra.Guerra.beans;

import org.springframework.stereotype.Component;

@Component
public class Piloto extends TripulacionDestructor {

	public Piloto(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
		setTipo("Piloto");
	}
	
	public Piloto(String nombre) {
		super(nombre);
		setTipo("Piloto");
		setFuerza(4);
		setResistencia(6);
	}
	
	public Piloto() {
		
	}
}
