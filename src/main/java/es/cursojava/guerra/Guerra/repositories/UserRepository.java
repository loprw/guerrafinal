package es.cursojava.guerra.Guerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cursojava.guerra.Guerra.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public boolean findByNameAndPassword(String name, String password);

}
