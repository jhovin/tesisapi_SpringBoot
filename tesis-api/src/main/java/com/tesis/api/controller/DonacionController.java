package com.tesis.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.api.entities.Donacion;
import com.tesis.api.service.IDonacionService;


@RestController
@RequestMapping("/api")
public class DonacionController {

	@Autowired
	private IDonacionService donacionService;
	@Autowired
	

	@GetMapping("/donaciones")
	public List<Donacion>listaDonaciones(){
		return donacionService.findAll();
	}
	@GetMapping("/donaciones/{id}")
	public Donacion obtener(@PathVariable Long id) {
		return donacionService.findById(id);
	}
	
	@PostMapping("/donaciones")
	public ResponseEntity<?> crearDonacion(@RequestBody Donacion donacion){
		donacionService.save(donacion);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/donaciones/{id}")
	public void eliminarDonacion(@PathVariable Long id) {
		donacionService.delete(id);
	}
	

}
