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

import com.tesis.api.entities.Producto;
import com.tesis.api.service.IProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto>listaProductos(){
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto obtener(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	public Producto updateProducto(@PathVariable(value="id")Long id,@RequestBody Producto producto){
		Producto pro=productoService.findById(id);
		pro.setNombre(producto.getNombre());
		pro.setTipo(producto.getTipo());
		pro.setCantidad(producto.getCantidad());
		
		return productoService.save(pro);
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Long id) {
		productoService.delete(id);
	}
	
	
	
}
