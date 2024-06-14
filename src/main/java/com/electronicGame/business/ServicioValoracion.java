package com.electronicGame.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicGame.entities.Valoracion;
import com.electronicGame.repositories.ValoracionRepository;

@Service
public class ServicioValoracion implements IServicioValoracion{

    @Autowired
    private ValoracionRepository valoracionRepository;

    public List<Valoracion> getAllValoraciones() {
        return valoracionRepository.findAll();
    }
}