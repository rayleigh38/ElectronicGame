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
        // Aquí podrías implementar la lógica para obtener los datos del artículo con el nombre proporcionado
        // Supongamos que ya tienes la lógica para obtener los datos y los has almacenado en un objeto llamado 'articulo'
    	
    	Articulo articulo =servicio.getArticulo(id);

        // Agregar los datos del artículo al modelo para que puedan ser renderizados en la plantilla
        model.addAttribute("articulo", articulo);
        
        // Devolver el nombre de la plantilla que deseas renderizar
        return "t_articulo";
    }
	

}
