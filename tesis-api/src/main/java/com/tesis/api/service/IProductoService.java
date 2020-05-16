package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Producto;

public interface IProductoService {
	
	public List<Producto>findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
}
