package ar.edu.unju.fi.entity;

public class Contacto {
	private int numeroTel;
	private String email;
	
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contacto(int numeroTel, String email) {
		super();
		this.numeroTel = numeroTel;
		this.email = email;
	}
	
}
