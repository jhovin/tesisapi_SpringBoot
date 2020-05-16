package com.tesis.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empresas")
public class Empresa implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String ruc;
	private String correo;
	private String telefono;
	private String direccion;
	private String tipo_emp;
	private String logo;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empresa_id",referencedColumnName="id")
	private List<Evento>evento=new ArrayList<>();
	
	

	public List<Evento> getEvento() {
		return evento;
	}
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
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
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo_emp() {
		return tipo_emp;
	}
	public void setTipo_emp(String tipo_emp) {
		this.tipo_emp = tipo_emp;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", ruc=" + ruc + ", correo=" + correo + ", telefono="
				+ telefono + ", direccion=" + direccion + ", tipo_emp=" + tipo_emp + ", logo=" + logo + "]";
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
