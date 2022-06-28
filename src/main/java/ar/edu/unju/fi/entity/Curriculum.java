package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "curriculum")
@Component
public class Curriculum implements Serializable{

    private static final long serialVersionUID = -7679397724502218352L;
    @Id
    @Column(name="cur_id")
    private Long curriculumNumber;
	private Ciudadano ciudadano;
    private Contacto contacto;
   // private List<Experiencia> experiencia;
   // private List<Educacion> educacion;
    private String idioma;
    private String conocimientos;
    private String infoComplementaria;
    private String datoAdicionales;

    public Curriculum() {
    }

    public Curriculum(Ciudadano ciudadano, Contacto contacto, List<Experiencia> experiencia, List<Educacion> educacion,
            String idioma, String conocimientos, String infoComplementaria, String datoAdicionales) {
        this.ciudadano = ciudadano;
        this.contacto = contacto;
       // this.experiencia = experiencia;
       // this.educacion = educacion;
        this.idioma = idioma;
        this.conocimientos = conocimientos;
        this.infoComplementaria = infoComplementaria;
        this.datoAdicionales = datoAdicionales;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    //public List<Experiencia> getExperiencia() {
    //    return experiencia;
    //}

    //public void setExperiencia(List<Experiencia> experiencia) {
    //    this.experiencia = experiencia;
    // }

   // public List<Educacion> getEducacion() {
   //     return educacion;
   // }

   // public void setEducacion(List<Educacion> educacion) {
   //     this.educacion = educacion;
   // }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
    }

    public String getInfoComplementaria() {
        return infoComplementaria;
    }

    public void setInfoComplementaria(String infoComplementaria) {
        this.infoComplementaria = infoComplementaria;
    }

    public String getDatoAdicionales() {
        return datoAdicionales;
    }

    public void setDatoAdicionales(String datoAdicionales) {
        this.datoAdicionales = datoAdicionales;
    }

    public Long getCurriculumNumber() {
        return curriculumNumber;
    }

    public void setCurriculumNumber(Long curriculumNumber) {
        this.curriculumNumber = curriculumNumber;
    }

    
}
