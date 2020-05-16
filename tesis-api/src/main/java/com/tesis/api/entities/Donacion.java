package com.tesis.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="donaciones")
public class Donacion implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date fecha_don;
	private Long evento_id;
	
	public Donacion() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha_don() {
		return fecha_don;
	}

	public void setFecha_don(Date fecha_don) {
		this.fecha_don = fecha_don;
	}

	public Long getEvento_id() {
		return evento_id;
	}

	public void setEvento_id(Long evento_id) {
		this.evento_id = evento_id;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
