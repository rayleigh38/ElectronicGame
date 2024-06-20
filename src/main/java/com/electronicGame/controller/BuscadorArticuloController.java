package com.electronicGame.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.electronicGame.business.IServicioArticulo;
import com.electronicGame.entities.Articulo;
import com.electronicGame.entities.Valoracion;

@Controller
@RequestMapping("/buscador")
public class BuscadorArticuloController {
	public static final Logger log = LoggerFactory.getLogger(BuscadorArticuloController.class);
	
	@Autowired
	IServicioArticulo servicio;
	
	@GetMapping
	//Clase para buscar los articulos por su nombre
	public String buscarArticulo(Model model,@RequestParam(value= "cadena", required = false) String cadena) throws Exception{
		log.info("[buscarArticulo]");
		log.debug("[nombreArticulo:"+cadena+"]");
		List<Articulo> articulos = servicio.buscador(cadena);
		// Calcula la media de valoraciones de cada artículo
        for (Articulo articulo : articulos) {
            double sumaValoraciones = 0;
            int totalValoraciones = 0;
            for (Valoracion valoracion : articulo.getValoraciones()) {
                sumaValoraciones += valoracion.getEstrellas();
                totalValoraciones++;
            }
            double mediaValoraciones = totalValoraciones > 0 ? sumaValoraciones / totalValoraciones : 0;
            //Redondear la media para dejarla en un solo decimal
            mediaValoraciones = new BigDecimal(mediaValoraciones).setScale(1, RoundingMode.HALF_UP).doubleValue();
            articulo.setMediaValoraciones(mediaValoraciones);
        }
		
		model.addAttribute("listArticulo", articulos);
		return "t_buscador";
	}
	
    

}
