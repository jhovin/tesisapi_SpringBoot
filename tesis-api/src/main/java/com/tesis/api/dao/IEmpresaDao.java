package com.tesis.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.tesis.api.entities.Empresa;

public interface IEmpresaDao extends CrudRepository<Empresa, Long> {

}
