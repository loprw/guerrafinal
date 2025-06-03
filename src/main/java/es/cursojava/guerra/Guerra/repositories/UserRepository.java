package es.cursojava.guerra.Guerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.guerra.Guerra.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public boolean existsByNameAndPassword(String name, String password);

}
