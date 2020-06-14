package com.tesis.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.api.entities.Usuario;
import com.tesis.api.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario>listaUsuario(){
		return(List<Usuario>)usuarioService.findAll();
	}
	@GetMapping("/usuarios/{id}")
	public Usuario obtener(@PathVariable(value="id") Long id) {
		Usuario usu=usuarioService.findById(id);
		if(usu==null) {
			throw new RuntimeException( 
					"No se ha encontrado la identificación de usuario:"+id);
		}
		return usu;
		
	}
	@PostMapping("/usuarios/create")
	public ResponseEntity<Void>crear(@RequestBody Usuario usuario){
		if(usuarioService.findUsuario(usuario)==null) {
			usuarioService.save(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody Usuario usuario){
		Usuario usu = usuarioService.checkUsuarioLogin(usuario);
		if(usu!=null) {
			return new ResponseEntity<>(usu,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?>updateUsuario(@PathVariable(value="id")Long id,@RequestBody Usuario usuario){
		Usuario usu = null;
		usu = usuarioService.findById(id);
		if(usu!=null) {
			usu.setNombre(usuario.getNombre());
			usu.setApellido(usuario.getApellido());
			usu.setDni(usuario.getDni());
			usu.setTelefono(usuario.getTelefono());
			usu.setDireccion(usuario.getDireccion());
			usu.setEmail(usuario.getEmail());
			usu.setPassword(usuario.getPassword());
			usu.setFoto(usuario.getFoto());
			usuarioService.updateUsuario(usu);
			return new ResponseEntity<>(usu, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Void> EliminarUsuario(@PathVariable(value="id")Long id) {
		usuarioService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
