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

import com.tesis.api.entities.Evento;
import com.tesis.api.service.IEventoService;

@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private IEventoService eventoService;
	
	@GetMapping("/eventos")
	public List<Evento>listaEventos(){
		return eventoService.findAll();
	}
	
	@GetMapping("/eventos/{id}")
	public Evento obtener(@PathVariable Long id) {
		return eventoService.findById(id);
	}

	
	
	@PostMapping("/eventos")
	public Evento crear(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}
	
	@PutMapping("/eventos/{id}")
	public Evento update(@PathVariable(value="id") Long id,@RequestBody Evento evento) {
		Evento eve=eventoService.findById(id);
		eve.setNombre(evento.getNombre());
		eve.setLugar(evento.getLugar());
		eve.setFecha_even(evento.getFecha_even());
		eve.setDescripcion(evento.getDescripcion());
		eve.setLogo(eve.getLogo());
		
		return eventoService.save(eve);	
	}
	@DeleteMapping("/eventos/{id}")
	public void eliminarEvento(@PathVariable Long id) {
		eventoService.delete(id);
	}

}
