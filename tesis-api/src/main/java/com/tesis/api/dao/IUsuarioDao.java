package com.tesis.api.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tesis.api.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Long>{
	
	@Override
	List<Usuario>findAll();
}
