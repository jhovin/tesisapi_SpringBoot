package com.tesis.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.tesis.api.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Long>{
	
	public Usuario findByEmail(String email);
	public Usuario findByEmailAndPassword(String email,String password);
	
}
