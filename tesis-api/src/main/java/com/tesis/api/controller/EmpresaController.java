package com.tesis.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.api.entities.Empresa;
import com.tesis.api.service.IEmpresaService;

@RestController
@RequestMapping("/api")
public class EmpresaController{
	
	@Autowired
	private IEmpresaService empresaService;
	
	@GetMapping("/empresas")
	public List<Empresa>listaEmpresas(){
		return empresaService.findAll();
	}
	@GetMapping("/empresas/{id}")
	public Empresa obtener(@PathVariable Long id) {
		return empresaService.findById(id);
	}
	
	@PostMapping("/empresas")
	public Empresa crear(@RequestBody Empresa empresa) {
		return empresaService.save(empresa);
	}
	@PutMapping("/empresas/{id}")
	public Empresa update(@RequestBody Empresa empresa,@PathVariable Long id) {
		Empresa emp=empresaService.findById(id);
		emp.setCorreo(emp.getCorreo());
		emp.setDireccion(emp.getDireccion());
		emp.setNombre(emp.getNombre());
		emp.setTelefono(emp.getTelefono());
		emp.setRuc(emp.getRuc());
		emp.setLogo(emp.getLogo());
		emp.setTipo_emp(emp.getTipo_emp());
		
		return empresaService.save(emp);
		
	}
	@DeleteMapping("/empresas/{id}")
	public void  eliminarEmpresa(@PathVariable Long id) {
		empresaService.delete(id);
	}
	
}
