package com.electronicGame.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.electronicGame.admin.exceptions.AdminException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws AdminException {
        log.info("logout");
        
        // Invalida la sesion (opcional, depende de tu configuracion de seguridad)
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        // Redirige a la pagina de inicio
        try {
            response.sendRedirect("/"); 
            return null;  // Explicitly return null to prevent further processing
        } catch (IOException e) {
            log.error("Error during logout redirection", e);
            throw new AdminException();
        }
    }
	@GetMapping("/loginError")
    public String error() {
		log.info("login error");
		
        return "loginError";
    }
	
	@GetMapping("/login")
    public String login() {
		log.info("login");
		
        return "login";
    }
}
