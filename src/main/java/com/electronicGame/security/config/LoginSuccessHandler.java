package com.electronicGame.security.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.electronicGame.business.ServicioUsuario;
import com.electronicGame.entities.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);
	
	@Autowired
	ServicioUsuario servicio;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("onAuthenticationSuccess");
		
		HttpSession session = request.getSession();
		Usuario datosUsuario = null;
		try {
			log.info("NOMBRE DEL PRINCIPAL:"+authentication.getName());
			datosUsuario = servicio.getUsuario(authentication.getName());
			log.info("datosUsuario" + datosUsuario.toString());
			session.setAttribute("usuario", datosUsuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Redirigir al usuario a una página de inicio personalizada
        response.sendRedirect("/rutinas"); // Puedes ajustar la URL según tu configuración
	}

}