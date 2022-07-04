package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "empleador")
@Component
public class Empleador implements Serializable {
	
	//id
	private static final long serialVersionUID = -3611893865263492725L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empleadorNumber;
	//cuit
	@Column(name = "emp_cuit")
	private Long cuit;
	
	//password
	@NotBlank(message = "El campo password no puede estar vacio")
	@Size(min = 3, message = "La contraseña debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_contrasena")
	private String contrasena;
	
	//razon social
	@NotBlank(message = "El campo razon social no puede estar vacio")
	@Size(min = 3, message = "La razon social debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_rz_scl")
	private String razon_social;
	
	//nombre comercial
	@NotBlank(message = "El campo nombre comercial no puede estar vacio")
	@Size(min = 3, message = "El nombre comercial debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_nom_com")
	private String nom_comercial;
	
	//inicio actividad
	@Column(name = "emp_fechaInic")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInic;

	@Column(name = "emp_perfil")
	private String perfil;
	
	//email
	@NotEmpty
	@Email
	@Column(name = "emp_email")
	private String email;
	
	//telefono
	@Size(min = 5, max = 10)
	@NotEmpty(message = "El telefono no puede ser vacío")
	@Column(name = "emp_telefono")
	private String telefono;
	
	//domicilio
	@NotBlank(message = "El campo domicilio no puede estar vacio")
	@Size(min = 3, message = "El domicilio debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_domicilio")
	private String domicilio;
	
	//provincia
	@NotNull(message = "Debe seleccionar una provincia")
	@Column(name = "emp_provincia")
	private String provincia;
	
	//pag web
	@NotBlank(message = "El campo pagina web no puede estar vacio")
	@Size(min = 3, message = "La pagina web debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_pagweb")
	private String pag_web;
	
	//descripcion
	@NotBlank(message = "El campo descripcion no puede estar vacio")
	@Size(min = 3, message = "La descripcion debe tener entre 3 a 20 caracteres")
	@Column(name = "emp_descripcion")
	private String descripcion;

	public Empleador() {
	}

	public Empleador(Long cuit, String contrasena, String razon_social, String nom_comercial,
			 LocalDate fechaInic, String email, String telefono, String domicilio, String provincia, String pag_web, String descripcion) {
		this.cuit = cuit;
		this.contrasena = contrasena;
		this.razon_social = razon_social;
		this.nom_comercial = nom_comercial;
		this.fechaInic = fechaInic;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.pag_web = pag_web;
		this.descripcion = descripcion;
	}
	
	public Long getEmpleadorNumber() {
		return empleadorNumber;
	}

	public void setEmpleadorNumber(Long empleadorNumber) {
		this.empleadorNumber = empleadorNumber;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNom_comercial() {
		return nom_comercial;
	}

	public void setNom_comercial(String nom_comercial) {
		this.nom_comercial = nom_comercial;
	}

	public LocalDate getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(LocalDate fechaInic) {
		this.fechaInic = fechaInic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPag_web() {
		return pag_web;
	}

	public void setPag_web(String pag_web) {
		this.pag_web = pag_web;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	

}
