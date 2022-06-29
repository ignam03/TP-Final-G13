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
@Table(name="ofertaLaboral")
@Component
public class OfertaLaboral implements Serializable{
    
    private static final long serialVersionUID = -7254071800146150850L;
    @Id
    @Column(name="ofe_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oferNumber;
	private int cantVacantes;
    private String puesto;
    private String resumen;
    private String disponibilidad;
    private String tareas;
    private String datos;
    private String jornada;
    private String requisitos;
    private double salario;
    private String beneficios;
    private Boolean disponible;

    public OfertaLaboral() {
    }

    public OfertaLaboral(int cantVacantes, String puesto, String resumen, String disponibilidad, String tareas,
            String datos, String jornada, String requisitos, double salario, String beneficios, Boolean disponible) {
        this.cantVacantes = cantVacantes;
        this.puesto = puesto;
        this.resumen = resumen;
        this.disponibilidad = disponibilidad;
        this.tareas = tareas;
        this.datos = datos;
        this.jornada = jornada;
        this.requisitos = requisitos;
        this.salario = salario;
        this.beneficios = beneficios;
        this.disponible = disponible;
    }

    public Long getOferNumber() {
		return oferNumber;
	}

	public void setOferNumber(Long oferNumber) {
		this.oferNumber = oferNumber;
	}

	public int getCantVacantes() {
        return cantVacantes;
    }

    public void setCantVacantes(int cantVacantes) {
        this.cantVacantes = cantVacantes;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
