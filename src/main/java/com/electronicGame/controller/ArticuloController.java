package com.electronicGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.business.IServicioArticulo;
import com.electronicGame.entities.Articulo;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {
	public static final Logger log = LoggerFactory.getLogger(ArticuloController.class);
	
	@Autowired
	IServicioArticulo servicio;
	
	
	
    @GetMapping("/{id}")
    public String mostrarArticulo(@PathVariable("id") Integer id, Model model) throws AdminException {
    	log.info("mostrarArticulo");
    	log.debug("id:"+id);
    	//Obtengo el articulo por su id
    	Articulo articulo =servicio.getArticulo(id);

        // Agregar los datos del artículo al modelo
        model.addAttribute("articulo", articulo);
        
        return "t_articulo";
    }
	

}
