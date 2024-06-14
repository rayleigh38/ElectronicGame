package com.electronicGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.electronicGame.business.ServicioValoracion;

@Controller
public class MostrarValoracion {


    @Autowired
    private ServicioValoracion servicioValoracion;



    @GetMapping("/valoraciones")
    public String getAllValoraciones(Model model) {
        model.addAttribute("valoraciones", servicioValoracion.getAllValoraciones());
        return "t_valoraciones";
    }
}
