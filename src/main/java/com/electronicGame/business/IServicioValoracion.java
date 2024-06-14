package com.electronicGame.business;

import java.util.List;

import com.electronicGame.admin.exceptions.AdminException;
import com.electronicGame.entities.Valoracion;

public interface IServicioValoracion {
	public List<Valoracion> getAllValoraciones() throws AdminException;


}
