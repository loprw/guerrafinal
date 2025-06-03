package es.cursojava.guerra.Guerra.utils;

import es.cursojava.guerra.Guerra.entities.Guerrero;
import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;

public class Utils {

	public static boolean validarAtaque(int atributoOfensivo, VehiculoGuerra vehiculo) {		
		System.out.println("Validando que el valor de Ataque esté entre 0 y 10.");
		if (atributoOfensivo < 0 || atributoOfensivo > 10) {
			System.out.println("Valor de Ataque incorrecto, se inicializa en 5.");
			vehiculo.setAtaque(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarDefensa(int atributoDefensivo, VehiculoGuerra vehiculo) { 
		System.out.println("Validando que el valor de Defensa esté entre 0 y 10.");
		if (atributoDefensivo < 0 || atributoDefensivo > 10) {
			System.out.println("Valor de Defensa incorrecto, se inicializa en 5.");
			vehiculo.setDefensa(5);
			return false;
		}
		return true;
	}
	
	public static boolean validarAtributosVehiculos(int atributoOfensivo, int atributoDefensivo, VehiculoGuerra vehiculo) {
		System.out.println("Validando que los valores de Ataque y Defensa no sumen más de 10.");
		if ((atributoOfensivo + atributoDefensivo) > 10) {
			System.out.println("Suma de valores de Ataque más Defensa incorrecta. Se inicializan en 5.");
			vehiculo.setAtaque(5);
			vehiculo.setDefensa(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarFuerza(int atributoOfensivo, Guerrero guerrero) {		
		System.out.println("Validando que el valor de Ataque esté entre 0 y 10.");
		if (atributoOfensivo < 0 || atributoOfensivo > 10) {
			System.out.println("Valor de Ataque incorrecto, se inicializa en 5.");
			guerrero.setFuerza(5);
			return false;
		}
		
		return true;
	}
	
	public static boolean validarResistencia(int atributoDefensivo, Guerrero guerrero) { 
		System.out.println("Validando que el valor de Defensa esté entre 0 y 10.");
		if (atributoDefensivo < 0 || atributoDefensivo > 10) {
			System.out.println("Valor de Defensa incorrecto, se inicializa en 5.");
			guerrero.setResistencia(5);
			return false;
		}
		return true;
	}
	
	public static boolean validarAtributosGuerrero(int atributoOfensivo, int atributoDefensivo, Guerrero guerrero) {
		System.out.println("Validando que los valores de Ataque y Defensa no sumen más de 10.");
		if ((atributoOfensivo + atributoDefensivo) > 10) {
			System.out.println("Suma de valores de Ataque más Defensa incorrecta. Se inicializan en 5.");
			guerrero.setFuerza(5);
			guerrero.setResistencia(5);
			return false;
		}
		
		return true;
	}
}
