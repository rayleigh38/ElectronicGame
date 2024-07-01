package com.electronicGame.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.repositories.ArticuloRepository;

@Service
public class ServicioSeccion {
	public static final Logger log= LoggerFactory.getLogger(ServicioArticulo.class);
	@Autowired
	ArticuloRepository repository;
	
	public List<String> obtenerDatosSeccion(String seccion) {
        log.info("[obtenerDatosSeccion]");
        log.debug("[obtenerDatosSeccion: " + seccion+"]");
        List<String> categorias = repository.datosCategoria(seccion);
        return categorias;
    }
	
	public List<String> obtenerSubcategorias(String categoria){
		log.info("[obtenerSubcategorias]");
		log.debug("[obtenerSubcategorías: "+categoria+"]");
		List<String> subcategorias = repository.datosSubCategoria(categoria);
		return subcategorias;
	}
	
}
