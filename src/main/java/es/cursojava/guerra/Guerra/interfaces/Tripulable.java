package es.cursojava.guerra.Guerra.interfaces;

import es.cursojava.guerra.Guerra.entities.Guerrero;

public interface Tripulable extends Atacar, Defender {

	void embarcarGuerrero(Guerrero guerrero);
	
	void embarcarGuerreros(Guerrero[] guerreros);
}

