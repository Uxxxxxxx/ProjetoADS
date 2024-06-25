package com.projeto.ads.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto.ads.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
	
	@Query("SELECT i FROM Usuario i WHERE i.email=:email")
	public Usuario findByEmail(String email);
	
}
