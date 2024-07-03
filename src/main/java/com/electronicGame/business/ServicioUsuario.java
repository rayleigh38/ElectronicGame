package com.electronicGame.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.electronicGame.entities.Authorities;
import com.electronicGame.entities.Usuario;
import com.electronicGame.repositories.AuthoritiesRepository;
import com.electronicGame.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicioUsuario {
	Logger log = LoggerFactory.getLogger(ServicioUsuario.class);

	@Autowired
	private UsuarioRepository usuarioRepository;



	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	public Usuario  getUsuario(String username) throws Exception{
		log.info("getUsuario");
		log.debug("username:"+ username);
		Usuario usuario;
		usuario = usuarioRepository.findUsuarioByUsername(username);
		return usuario;
	}

	@Transactional
	public void registerUser(Usuario usuario) throws Exception {
		log.info("registerUser");
		log.debug("usuario:", usuario);
		try {
			usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
			usuarioRepository.save(usuario);

			// Asignar rol (autoridad) al usuario
			Authorities authorities = new Authorities();
			authorities.setUsername(usuario.getUsername());
			authorities.setAuthority("ROLE_USER");

			// Guardar la autoridad en la base de datos
			authoritiesRepository.save(authorities);

			log.debug("authorities:", authorities);

			log.info("Usuario {} registrado con rol ROLE_USER", usuario.getUsername());
		} catch (Exception e) {
			log.error("Error registro", e);

		}
		
	}
	public PasswordEncoder passwordEncoder() { return new
			  BCryptPasswordEncoder(); }
}