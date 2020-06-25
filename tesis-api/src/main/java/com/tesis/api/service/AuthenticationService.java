package com.tesis.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tesis.api.dao.AuthenticationRepository;
import com.tesis.api.entities.Usuario;

@Service
public class AuthenticationService {
	
private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
    private AuthenticationRepository authenticationRepository;
	
	public Usuario login(String email, String password) throws Exception {
		logger.info("login("+email+", "+password+")");
        return authenticationRepository.login(email, password);
    }
	
	public Usuario findByUsername(String email) throws EmptyResultDataAccessException{
		logger.info("findByUsername("+email+")");
		return authenticationRepository.findByUsername(email);
	}

}
