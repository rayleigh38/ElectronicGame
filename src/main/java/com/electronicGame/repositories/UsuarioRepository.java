package com.electronicGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicGame.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	public Usuario findUsuarioByUsername(String username);

}
