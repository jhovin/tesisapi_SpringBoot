package com.tesis.api.service;

import java.util.List;

import com.tesis.api.entities.Empresa;

public interface IEmpresaService {
	
	public List<Empresa>findAll();
	
	public Empresa findById(Long id);
	
	public Empresa save(Empresa empresa);
	
	public void delete(Long id);
	

}
