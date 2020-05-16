package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Donacion;

public interface IDonacionService {
	
	public List<Donacion>findAll();
	
	public Donacion findById(Long id);
	
	public Donacion save(Donacion donacion);
	
	public void delete(Long id);

}
