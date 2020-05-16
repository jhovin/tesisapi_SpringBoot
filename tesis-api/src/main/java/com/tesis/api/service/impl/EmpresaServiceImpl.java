package com.tesis.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.api.dao.IEmpresaDao;
import com.tesis.api.entities.Empresa;
import com.tesis.api.service.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
	
	@Autowired
	private IEmpresaDao empresaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empresa> findAll() {
	
		return(List<Empresa>)empresaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empresa findById(Long id) {
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empresaDao.deleteById(id);
		
	}

}
