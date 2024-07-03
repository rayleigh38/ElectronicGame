package com.electronicGame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	Logger log = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/logout")
    public String logout() {
		log.info("logout");
		
        return "index";
    }
	@GetMapping("/loginError")
    public String error() {
		log.info("login error");
		
        return "loginError";
    }
	
	@GetMapping("/login")
    public String login() {
		log.info("login");
		
        return "login";
    }
}
