package es.cursojava.guerra.Guerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;

public interface VehiculoRepository extends JpaRepository<VehiculoGuerra, Long> {

	public VehiculoGuerra findById(long id);
	public void deleteById(long id);
}
