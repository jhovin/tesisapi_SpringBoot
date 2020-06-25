package com.tesis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.api.entities.Usuario;
import com.tesis.api.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
    private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public Usuario login(@RequestParam String email, @RequestParam String password)throws Exception {
		Usuario usuario = authenticationService.login(email, password);
		return usuario;
	}
	
}
