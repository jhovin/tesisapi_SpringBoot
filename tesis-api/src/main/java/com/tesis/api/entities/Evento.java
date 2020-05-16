package com.tesis.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="eventos")
public class Evento implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String lugar;
	@Temporal(TemporalType.DATE)
	private Date fecha_even;
	private String descripcion;
	private String logo;
	private Long empresa_id;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="donacion_id",referencedColumnName="id")
	private List<Donacion>donacion=new ArrayList<>();
	
	
	public List<Donacion> getDonacion() {
		return donacion;
	}

	public void setDonacion(List<Donacion> donacion) {
		this.donacion = donacion;
	}

	public Evento() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public Date getFecha_even() {
		return fecha_even;
	}

	public void setFecha_even(Date fecha_even) {
		this.fecha_even = fecha_even;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Long empresa_id) {
		this.empresa_id = empresa_id;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
