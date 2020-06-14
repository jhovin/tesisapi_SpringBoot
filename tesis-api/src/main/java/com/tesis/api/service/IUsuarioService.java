package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario>findAll();
	
	public Usuario checkUsuarioLogin(Usuario usuario);
	
	public void save(Usuario usuario);
	
	//DEVUELVE UN USUARIO
	public Usuario findUsuario(Usuario usuario);
	
	public Usuario updateUsuario(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public Usuario findByIdSQL(Long id);
	
	public void  delete(Long id);
}
