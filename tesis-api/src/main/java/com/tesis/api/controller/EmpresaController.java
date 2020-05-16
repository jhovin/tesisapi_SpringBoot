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
	public Empresa updateEmpresa(@PathVariable(value="id") Long id,@RequestBody Empresa empresa) {
		Empresa emp=empresaService.findById(id);
		emp.setNombre(empresa.getNombre());
		emp.setCorreo(empresa.getCorreo());
		emp.setDireccion(empresa.getDireccion());
		emp.setNombre(empresa.getNombre());
		emp.setTelefono(empresa.getTelefono());
		emp.setRuc(empresa.getRuc());
		emp.setLogo(empresa.getLogo());
		emp.setTipo_emp(empresa.getTipo_emp());
		
		return empresaService.save(emp);
		
	}
	@DeleteMapping("/empresas/{id}")
	public void  eliminarEmpresa(@PathVariable Long id) {
		empresaService.delete(id);
	}
	
}
