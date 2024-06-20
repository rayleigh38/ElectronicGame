package com.electronicGame.business;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Articulo;
import com.electronicGame.entities.Imagen;
import com.electronicGame.entities.Valoracion;

public interface IServicioIndex {

	public List<Articulo> mejorValorados() throws AdminException;

}
