package com.electronicGame.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.entities.Imagen;
import com.electronicGame.repositories.ImagenRepository;

@Service
public class ServicioImagen implements IServicioImagen{

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> getAllImagenes() {
        return imagenRepository.findAll();
    }
}