package es.cursojava.guerra.Guerra.beans;

import es.cursojava.guerra.Guerra.utils.Utils;

public abstract class TripulacionTanque extends es.cursojava.guerra.Guerra.entities.Guerrero {

	public TripulacionTanque(String nombre, int fuerza, int resistencia) {
		super(nombre, fuerza, resistencia);
		Utils.validarFuerza(fuerza, this);
		Utils.validarResistencia(resistencia, this);
		Utils.validarAtributosGuerrero(fuerza, resistencia, this);
	}
	
	public TripulacionTanque(String nombre) {
		super(nombre);
	}
	
	public TripulacionTanque() {
		
	}
}
