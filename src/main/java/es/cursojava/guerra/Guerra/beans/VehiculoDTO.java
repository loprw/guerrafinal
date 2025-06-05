package es.cursojava.guerra.Guerra.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.cursojava.guerra.Guerra.entities.Guerrero;

@Component
public class VehiculoDTO {

	private Long id;
	private String nombre;
	private int puntosVida;
	private int ataque;
	private int defensa;
	private String tipo;
	private List<Guerrero> guerrerosEmbarcados = new ArrayList<Guerrero>();
	
	public VehiculoDTO() {
	}

	public VehiculoDTO(Long id, String nombre, int puntosVida, int ataque, int defensa, String tipo,
			List<Guerrero> guerrerosEmbarcados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.tipo = tipo;
		this.guerrerosEmbarcados = guerrerosEmbarcados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Guerrero> getGuerrerosEmbarcados() {
		return guerrerosEmbarcados;
	}

	public void setGuerrerosEmbarcados(List<Guerrero> guerrerosEmbarcados) {
		this.guerrerosEmbarcados = guerrerosEmbarcados;
	}
}
