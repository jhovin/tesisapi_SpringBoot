package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario>findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public Usuario updateUsuario(Usuario usuario);

	
	public void  deleteById(Long id);
}
