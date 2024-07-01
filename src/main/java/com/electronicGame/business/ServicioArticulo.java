package com.electronicGame.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Articulo;
import com.electronicGame.entities.Imagen;
import com.electronicGame.entities.Valoracion;
import com.electronicGame.repositories.ArticuloRepository;
import com.electronicGame.repositories.ImagenRepository;
import com.electronicGame.repositories.ValoracionRepository;

@Service
public class ServicioArticulo implements IServicioArticulo{
	
	public static final Logger log= LoggerFactory.getLogger(ServicioArticulo.class);
	
	@Autowired
	ArticuloRepository repository;
	
	@Autowired
    private ImagenRepository imagenRepository;
	
	@Autowired
    private ValoracionRepository valoracionRepository;

	@Override
	//Metodo buscador que recibe una cadena con el nombre o parte del nombre de un articulo 
	//y devuelve una lista con los articulos que contienen esa cadena
	public List<Articulo> buscador(String nombreArticulo) throws AdminException {
		log.info("[buscador]");
		log.debug("[nombreArticulo: "+nombreArticulo+"]");
		
		List<Articulo> articulos = new ArrayList<Articulo>();
		try {
			if(nombreArticulo == null|| nombreArticulo.trim().isEmpty()) {
				nombreArticulo="";
			}
			
			articulos = repository.findByNameLike(nombreArticulo);
			
		}catch(Exception e) {
			log.error(e.toString());
			throw new AdminException();
		}
		
		return articulos;
	}
	
	public Optional<Imagen> getImagenArticulo(int articuloId) {
		log.info("[getImagenArticulo]");
		log.debug("[idArticulo: " +articuloId +"]");
        return imagenRepository.findByArticuloId(articuloId).stream().findFirst();
    }

	@Override
	public List<Articulo> getArticulo(String nombre) throws AdminException {
		log.info("[getArticulo]");
		log.debug("[getArticulo: "+nombre+"]");
		return repository.findByNameLike(nombre);
	}
	
	@Override
	//Metodo que obtiene un articulo por su id
	public Articulo getArticulo(Integer id) throws AdminException {
		log.info("[getArticulo]");
		log.debug("[getArticulo: "+id+"]");
		return repository.findById(id).get();
	}
	public Optional<Valoracion> getValoracionArticulo(int articuloId) {
		log.info("[getValoracionArticulo]");
		log.debug("[getArticulo: "+articuloId+"]");
        return valoracionRepository.findByArticuloId(articuloId).stream().findFirst();
    }

}
