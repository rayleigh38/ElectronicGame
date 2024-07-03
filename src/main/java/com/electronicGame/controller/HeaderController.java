package com.electronicGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.electronicGame.business.ServicioHeader;

public abstract class HeaderController {

    @Autowired
    private ServicioHeader servicioHeader;

    @ModelAttribute
    public void addAttributes(Model model) {
        List<String> secciones = servicioHeader.obtenerSecciones();
        model.addAttribute("secciones", secciones);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetails.getUsername());
        }
    }
}