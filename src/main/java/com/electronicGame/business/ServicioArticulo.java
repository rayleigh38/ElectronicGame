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
	//Metodo buscador que recibe un nombre de articulo devuelve una lista con los articulos que contienen ese nombre
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
			throw new AdminException();
		}
		
		return articulos;
	}
	
	public Optional<Imagen> getImagenArticulo(int articuloId) {
        return imagenRepository.findByArticuloId(articuloId).stream().findFirst();
    }

	@Override
	public List<Articulo> getArticulo(String nombre) throws AdminException {
		return repository.findByNameLike(nombre);
	}
	
	@Override
	public Articulo getArticulo(Integer id) throws AdminException {
		return repository.findById(id).get();
	}
	public Optional<Valoracion> getValoracionArticulo(int articuloId) {
        return valoracionRepository.findByArticuloId(articuloId).stream().findFirst();
    }

}
