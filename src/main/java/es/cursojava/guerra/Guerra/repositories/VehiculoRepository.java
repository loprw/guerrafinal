package es.cursojava.guerra.Guerra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.guerra.Guerra.entities.VehiculoGuerra;

public interface VehiculoRepository extends JpaRepository<VehiculoGuerra, Long> {

	
}
