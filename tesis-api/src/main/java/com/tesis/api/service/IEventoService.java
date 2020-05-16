package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Evento;

public interface IEventoService {
	
	public List<Evento>findAll();
	
	public Evento save(Evento evento);
	
	public Evento findById(Long id);
	
	public void delete(Long id);
}
