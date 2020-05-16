package com.tesis.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre_est;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre_est() {
		return nombre_est;
	}

	public void setNombre_est(String nombre_est) {
		this.nombre_est = nombre_est;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
