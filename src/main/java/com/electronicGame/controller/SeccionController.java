package com.electronicGame.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.business.ServicioSeccion;
import com.electronicGame.entities.Articulo;

@Controller
@RequestMapping("/seccion")
public class SeccionController extends HeaderController{
	public static final Logger log = LoggerFactory.getLogger(SeccionController.class);
	
	@Autowired
	ServicioSeccion servicio;
	
    @GetMapping("/{seccion}")
    public String mostrarSeccion(@PathVariable("seccion") String seccion, Model model) throws AdminException {
    	log.info("mostrarSeccion");
    	log.debug("seccion:"+seccion);
        model.addAttribute("seccion",seccion);
        List<String> datosCategorias= servicio.obtenerDatosSeccion(seccion);
        model.addAttribute("categorias",datosCategorias);
//        List<Articulo> datosSubCategoria= servicio.obtenerDatosCategoria(datosCategoria.ge);
//        model.addAttribute("secciones",datosSubCategoria);
        return "t_seccion";
    }
	

}
