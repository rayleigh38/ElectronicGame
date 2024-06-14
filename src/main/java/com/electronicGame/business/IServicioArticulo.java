package com.electronicGame.business;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Articulo;
import com.electronicGame.entities.Imagen;
import com.electronicGame.entities.Valoracion;

public interface IServicioArticulo {
	//Buscar articulo por nombre
	public List<Articulo> buscador(String nombre) throws AdminException;
	public List<Articulo> getArticulo(@PathVariable String nombre) throws AdminException;
	public Articulo getArticulo(@PathVariable Integer id) throws AdminException;
	public Optional<Imagen> getImagenArticulo(int id);
	public Optional<Valoracion> getValoracionArticulo(int id);

}
