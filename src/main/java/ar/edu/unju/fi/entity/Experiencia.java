package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="experiencias")
@Component
public class Experiencia implements Serializable {

    private static final long serialVersionUID = -4866292561636000824L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exp_id")
    private Long expNumber;
	private String tipoEmpleo;
    private String lugar;
    private String nombrePuesto;
    private LocalDate anioExp;

    public Experiencia() {
    }

    public Experiencia(String tipoEmpleo, String lugar, String nombrePuesto, LocalDate anioExp) {
        this.tipoEmpleo = tipoEmpleo;
        this.lugar = lugar;
        this.nombrePuesto = nombrePuesto;
        this.anioExp = anioExp;
    }

    public String getTipoEmpleo() {
        return tipoEmpleo;
    }

    public void setTipoEmpleo(String tipoEmpleo) {
        this.tipoEmpleo = tipoEmpleo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public LocalDate getAnioExp() {
        return anioExp;
    }

    public void setAnioExp(LocalDate anioExp) {
        this.anioExp = anioExp;
    }

}
