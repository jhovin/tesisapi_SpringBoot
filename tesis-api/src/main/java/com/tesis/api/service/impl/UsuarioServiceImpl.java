package com.tesis.api.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.api.dao.IUsuarioDao;
import com.tesis.api.entities.Usuario;
import com.tesis.api.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		
		usuarioDao.save(usuario);
	}

	@Override
	public Usuario findById(Long id) {

		return usuarioDao.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return(Usuario) usuarioDao.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
	
		usuarioDao.deleteById(id);
	}

	
	

	
	
}
