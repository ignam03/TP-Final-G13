package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="contactos")
@Component
public class Contacto implements Serializable{
    private static final long serialVersionUID = 7445182392453978341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="con_id")
    private Long contacoNumber;
	private String telefono;
    private String linkedin;
    private String email;

    public Contacto() {
    }

    public Contacto(String telefono, String linkedin, String email) {
        this.telefono = telefono;
        this.linkedin = linkedin;
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
