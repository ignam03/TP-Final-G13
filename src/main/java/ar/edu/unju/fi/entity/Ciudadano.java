package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


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
@Table(name = "ciudadanos")
@Component
public class Ciudadano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3611893865263492725L;
	@Min(value = 1000000, message = "El DNI debe ser mayor a 1.000.000")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ciudadanoNumber;
	@Column(name = "ciu_dni")
	private Long dni;
	@Size(min = 3, max = 20, message = "El nombre debe tener entre 3 a 20 caracteres")
	@NotEmpty(message = "El nroTramite del ciudadano no puede ser vacio")
	@Column(name = "ciu_nroTramite")
	private String nroTramite;
	@NotEmpty
	@Email
	@Column(name = "ciu_email")
	private String email;
	@NotNull(message = "Debe seleccionar un docente")
	@Column(name = "ciu_estadoCivil")
	private String estadoCivil;
	@Size(min = 5, max = 10)
	@NotEmpty(message = "El telefono no puede ser vacío")
	@Column(name = "ciu_telefono")
	private String telefono;
	@Column(name = "ciud_fechaNac")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	@NotBlank(message = "El campo password no puede estar vacio")
	@Size(min = 3, message = "La contraseña debe tener entre 3 a 20 caracteres")
	@Column(name = "ciu_contrasena")
	private String contrasena;
	@NotNull(message = "Debe seleccionar una provincia")
	@Column(name = "ciud_provincia")
	private String provincia;
	private String perfil;

	public Ciudadano() {
	}

	public Ciudadano(Long dni, String nroTramite, String email, String estadoCivil,
			String telefono, LocalDate fechaNac, String contrasena, String provincia, String perfil) {
		this.dni = dni;
		this.nroTramite = nroTramite;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.contrasena = contrasena;
		this.provincia = provincia;
		this.perfil = perfil;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNroTramite() {
		return nroTramite;
	}

	public void setNroTramite(String nroTramite) {
		this.nroTramite = nroTramite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Long getCiudadanoNumber() {
		return ciudadanoNumber;
	}

	public void setCiudadanoNumber(Long ciudadanoNumber) {
		this.ciudadanoNumber = ciudadanoNumber;
	}

	public long calcularEdad() {
		LocalDate fechaNa = fechaNac;
		LocalDate now = LocalDate.now();
		long edad = ChronoUnit.YEARS.between(fechaNa, now);
		return edad;
	}

}
