package com.tesis.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.api.dao.IDonacionDao;
import com.tesis.api.entities.Donacion;
import com.tesis.api.service.IDonacionService;

@Service
public class DonacionServiceImpl implements IDonacionService {

	@Autowired
	private IDonacionDao donacionDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Donacion> findAll() {
		return(List<Donacion>)donacionDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Donacion findById(Long id) {
		return donacionDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void save(Donacion donacion) {
		 donacionDao.save(donacion);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		donacionDao.deleteById(id);
	}

}
