package com.electronicGame.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.repositories.ArticuloRepository;

@Service
public class ServicioHeader {
	
	public static final Logger log= LoggerFactory.getLogger(ServicioArticulo.class);

	@Autowired
	ArticuloRepository repository;
	
	public List<String> obtenerSecciones() {
		log.info("[obtenerSecciones]");
		log.debug("[obtenerSecciones]");		
        return repository.listaSecciones();
    }
}
