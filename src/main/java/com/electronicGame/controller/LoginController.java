package com.electronicGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/logout")
    public String irse() {
		log.info("irse");
		
        return "index";
    }
	@GetMapping("/loginError")
    public String daerror() {
		log.info("daerror");
		
        return "loginError";
    }
	
	@GetMapping("/login")
    public String venirse() {
		log.info("venirse");
		
        return "login";
    }
}
