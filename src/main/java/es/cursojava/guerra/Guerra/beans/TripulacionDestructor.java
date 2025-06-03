package es.cursojava.guerra.Guerra.beans;

import es.cursojava.guerra.Guerra.entities.Guerrero;
import es.cursojava.guerra.Guerra.utils.Utils;

public abstract class TripulacionDestructor extends Guerrero {

	public TripulacionDestructor(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
		Utils.validarFuerza(fuerza, this);
		Utils.validarResistencia(resistencia, this);
		Utils.validarAtributosGuerrero(fuerza, resistencia, this);
	}
	
	public TripulacionDestructor(String nombre) {
		super(nombre);
	}
	
	public TripulacionDestructor() {
	}
}
