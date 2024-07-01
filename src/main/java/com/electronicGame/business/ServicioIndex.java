package com.electronicGame.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Articulo;
import com.electronicGame.repositories.ArticuloRepository;

@Service
public class ServicioIndex implements IServicioIndex{
	
	public static final Logger log= LoggerFactory.getLogger(ServicioArticulo.class);
	
	@Autowired
	ArticuloRepository repository;
	
	public List<Articulo> mejorValorados() throws AdminException {
		log.info("[mejorValorados]");
		log.debug("[mejorValorados");
		List<Articulo> valorados = new ArrayList<Articulo>();
		try {
						
			valorados = repository.findAll();
			log.info(valorados.toString());
			
		}catch(Exception e) {
			log.error(e.toString());
			throw new AdminException();
		}
		
		return valorados;
	}
}
