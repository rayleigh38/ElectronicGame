package com.electronicGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronicGame.admin.exceptions.AdminException;

@Controller
@RequestMapping("/seccion")
public class SeccionController extends HeaderController{
	public static final Logger log = LoggerFactory.getLogger(SeccionController.class);
	
    @GetMapping("/{seccion}")
    public String mostrarSeccion(@PathVariable("seccion") String seccion, Model model) throws AdminException {
    	log.info("mostrarSeccion");
    	log.debug("seccion:"+seccion);
        model.addAttribute("seccion",seccion);
        return "t_seccion";
    }
	

}
