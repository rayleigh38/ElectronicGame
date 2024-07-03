package com.electronicGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.electronicGame.business.ServicioUsuario;
import com.electronicGame.entities.Usuario;

@Controller
public class RegistroController {
	Logger log = LoggerFactory.getLogger(RegistroController.class);

	@Autowired
	private ServicioUsuario servicioUsuario;

	@GetMapping("/register")
	public String registro(Model model) {
		log.info("Accediendo a la página de registro");
		Usuario users = new Usuario();
        model.addAttribute("users", users);
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(Usuario user, Model model) {
	    log.info("registerUser");
	    log.info("user:"+ user.toString());
	    try {
	    	// Registrar el usuario usando el servicio
            servicioUsuario.registerUser(user);

            model.addAttribute("message", "Usuario registrado con éxito");
	    } catch (Exception e) {
	        log.error("Error al registrar el usuario", e);
	        model.addAttribute("error", "Error al registrar el usuario. Por favor, inténtalo de nuevo.");
	        return "register";
	    }
	    return "login";
	}
}
