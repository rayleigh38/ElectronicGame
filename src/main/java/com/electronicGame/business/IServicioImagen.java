package com.electronicGame.business;

import java.util.List;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Imagen;

public interface IServicioImagen {
	public List<Imagen> getAllImagenes() throws AdminException;


}
