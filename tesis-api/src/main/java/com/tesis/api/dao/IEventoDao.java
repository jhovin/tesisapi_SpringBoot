package com.tesis.api.dao;



import org.springframework.data.repository.CrudRepository;

import com.tesis.api.entities.Evento;

public interface IEventoDao extends CrudRepository<Evento,Long>{
	
	
}
