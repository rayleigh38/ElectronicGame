package com.electronicGame.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.business.IServicioIndex;
import com.electronicGame.entities.Articulo;
import com.electronicGame.entities.Valoracion;

@Controller
@RequestMapping("/")
public class IndexController {
	public static final Logger log = LoggerFactory.getLogger(BuscadorArticuloController.class);
	
	@Autowired
	IServicioIndex servicio;
	
	@GetMapping
	public String buscarArticulo(Model model) throws AdminException {
		log.info("[Indice]");
		log.debug("[Indice]");
		List<Articulo> valorados = servicio.mejorValorados();
		for (Articulo articulo : valorados) {
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
		
		// Ordenar la lista por mediaValoraciones en orden descendente
	    //valorados.sort(Comparator.comparingDouble(Articulo::getMediaValoraciones).reversed());
		//model.addAttribute("valorados", valorados);
	    
		// Ordenar la lista por mediaValoraciones en orden descendente y limitar a 5
	    List<Articulo> topValorados = valorados.stream()
	            .sorted(Comparator.comparingDouble(Articulo::getMediaValoraciones).reversed())
	            .limit(5)
	            .collect(Collectors.toList());

	    model.addAttribute("valorados", topValorados);
		

		
		
		return "index";
	}
	
	
}
