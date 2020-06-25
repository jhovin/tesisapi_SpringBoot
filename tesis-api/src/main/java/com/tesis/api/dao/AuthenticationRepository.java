package com.tesis.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.tesis.api.entities.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class AuthenticationRepository {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario login(String email, String password) throws Exception {
		logger.info("login("+email+", "+password+")");
		
		String sql = "select count(*) from usuarios where email=? and password=?";
		
		Integer exists = jdbcTemplate.queryForObject(sql, Integer.class,email, password);
		
		if(exists == 0) {
			throw new Exception("Usuario y/o clave invalido");
		}
		
		return findByUsername(email);
	}
	
	public Usuario findByUsername(String email) throws EmptyResultDataAccessException {
		logger.info("findByUsername("+email+")");
		
		String sql = "select * from usuarios where email=?";
		
		Usuario usuario = jdbcTemplate.queryForObject(sql, new RowMapper<Usuario>() {
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				
				return usuario;
			}
		}, email);
		
		logger.info("user: " + usuario);
		
		return usuario;
	}

}
