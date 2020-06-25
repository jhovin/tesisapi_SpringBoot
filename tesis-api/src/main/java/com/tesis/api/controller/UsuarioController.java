package com.tesis.api.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tesis.api.entities.Usuario;
import com.tesis.api.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario>listaUsuario(){
		List<Usuario> usuarios=usuarioService.findAll();
		return usuarios;
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
	@GetMapping("/usuarios/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
	
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}

	@PostMapping("/usuarios")
	public Usuario crear(@RequestParam(name="foto", required=false) MultipartFile foto,@RequestParam("nombre") String nombre, @RequestParam("email") String email,
			@RequestParam("password")String password,@RequestParam("apellido")String apellido,
			@RequestParam("dni")String dni,@RequestParam("telefono")String telefono,
			@RequestParam("direccion")String direccion) throws Exception {
		
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setTelefono(telefono);
		usuario.setDireccion(direccion);
		usuario.setEmail(email);
		usuario.setPassword(password);
		
		if (foto != null && !foto.isEmpty()) {
			String filename = System.currentTimeMillis() + foto.getOriginalFilename().substring(foto.getOriginalFilename().lastIndexOf("."));
			usuario.setFoto(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(foto.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		usuarioService.save(usuario);
		
		return usuario;
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
			usuarioService.updateUsuario(usu);
			return new ResponseEntity<>(usu, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Void> EliminarUsuario(@PathVariable(value="id")Long id) {
		usuarioService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
