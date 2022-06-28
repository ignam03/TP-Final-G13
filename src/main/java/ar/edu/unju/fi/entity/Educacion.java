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
@Table(name="educacion")
@Component
public class Educacion implements Serializable{

    private static final long serialVersionUID = -868213591416143615L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="edu_id")
    private Long eduNumer;
	private String lugar;
    private String nombre;
    private String nivelAlcanzado;

    public Educacion() {
    }

    public Educacion(String lugar, String nombre, String nivelAlcanzado) {
        this.lugar = lugar;
        this.nombre = nombre;
        this.nivelAlcanzado = nivelAlcanzado;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelAlcanzado() {
        return nivelAlcanzado;
    }

    public void setNivelAlcanzado(String nivelAlcanzado) {
        this.nivelAlcanzado = nivelAlcanzado;
    }

}
