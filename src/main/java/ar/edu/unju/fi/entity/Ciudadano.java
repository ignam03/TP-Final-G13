package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ciudadano {
	private int dni;
	private int nroTramite;
	private String email;
	private ArrayList<EstadoCivil> estadoC;
	private ArrayList<Provincia> provincia;
	private int telefono;
	private LocalDate fechaNac;
	private String contrasena;
	
	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNroTramite() {
		return nroTramite;
	}

	public void setNroTramite(int nroTramite) {
		this.nroTramite = nroTramite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<EstadoCivil> getEstadoC() {
		return estadoC;
	}

	public void setEstadoC(ArrayList<EstadoCivil> estadoC) {
		this.estadoC = estadoC;
	}

	public ArrayList<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(ArrayList<Provincia> provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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

	public Ciudadano(int dni, int nroTramite, String email, ArrayList<EstadoCivil> estadoC,
			ArrayList<Provincia> provincia, int telefono, LocalDate fechaNac, String contrasena) {
		super();
		this.dni = dni;
		this.nroTramite = nroTramite;
		this.email = email;
		this.estadoC = estadoC;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.contrasena = contrasena;
	}
	
}
