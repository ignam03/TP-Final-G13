package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ciudadano {
	private int dni;
	private String a;
	private String email;
	private ArrayList<EstadoCivil> estadoC;
	private ArrayList<Provincia> provincia;
	private int telefono;
	private LocalDate fechaNac;
	private String contrasena;

}
