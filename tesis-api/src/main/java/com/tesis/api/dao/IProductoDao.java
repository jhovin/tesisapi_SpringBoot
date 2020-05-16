package com.tesis.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.tesis.api.entities.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
