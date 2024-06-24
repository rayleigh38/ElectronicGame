package com.electronicGame.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.electronicGame.business.ServicioArticulo;
import com.electronicGame.business.ServicioHeader;

@Controller
public class HeaderController {
	public static final Logger log= LoggerFactory.getLogger(ServicioArticulo.class);


    @Autowired
    ServicioHeader servicioHeader;

    @GetMapping("/header")
    public String mostrarPagina(Model model) {
    	log.info("[mostrarPagina]");
        List<String> secciones = servicioHeader.obtenerSecciones();
        model.addAttribute("secciones", secciones);
        // Otros atributos que puedas necesitar para la página
        return "t_articulo"; // Nombre de la vista principal que incluye el fragmento
    }
}