package com.tesis.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	
	@Column(unique=true)
	private String dni;
	
	@Column(unique=true)
	private String telefono;
	private String direccion;
	
	@Column(unique=true)
	private String email;
	private String password;
	@Column(length=2000)
	private String foto;
	@Temporal(TemporalType.DATE)
	private Date fecha_usuario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="id")
	private List<Donacion> donacion=new ArrayList<>();
	
	
	
	public List<Donacion> getDonacion() {
		return donacion;
	}

	public void setDonacion(List<Donacion> donacion) {
		this.donacion = donacion;
	}

	@PrePersist()
	public void prePersist(){
		fecha_usuario = new Date();
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getFecha_usuario() {
		return fecha_usuario;
	}
	public void setFecha_usuario(Date fecha_usuario) {
		this.fecha_usuario = fecha_usuario;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", telefono="
				+ telefono + ", direccion=" + direccion + ", email=" + email + ", password=" + password + ", foto="
				+ foto + ", fecha_usuario=" + fecha_usuario + "]";
	}




	private static final long serialVersionUID = 1L;

}