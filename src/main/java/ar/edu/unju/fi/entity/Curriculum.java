package ar.edu.unju.fi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "curriculum")
@Component
public class Curriculum implements Serializable {

    private static final long serialVersionUID = -7679397724502218352L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_id")
    private Long curriculumNumber;

    // private Contacto contacto;
    // private String provincia;

    // List@Size(min = 3, max = 15)
    // List@NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name = "cur_nombre")
    private String nombre;

    // List@Size(min = 3, max = 15)
    // List@NotEmpty(message = "El nombre no puede ser vacío")
    @Column(name = "cur_apellido")
    private String apellido;

    // List@Size(min = 3, max = 15)
    // List@NotEmpty(message = "La direccion no puede estar vacío")
    @Column(name = "cur_direccion")
    private String direccion;

    // List@NotEmpty(message = "seleccione una provincia")
    @Column(name = "cur_pais")
    private String pais;

    // private List<Experiencia> experiencia;
    // private List<Educacion> educacion;
    // List@NotEmpty(message = "seleccione una idioma")
    @Column(name = "cur_idioma")
    private String idioma;

    // List@NotEmpty(message = "Los conocimientos no pueden estar vacío")
    @Column(name = "cur_conocimientos")
    private String conocimientos;

    // List@NotEmpty(message = "Los conocimientos no pueden estar vacío")
    @Column(name = "cur_infoComplementaria")
    private String infoComplementaria;

    // List@NotEmpty(message = "Los dato Adicionales no pueden estar vacío")
    @Column(name = "cur_datoAdicionales")
    private String datoAdicionales;

    // @OneToOne(mappedBy = "curriculum", fetch = FetchType.LAZY) va abjaocascade =
    // { CascadeType.ALL }

    // @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
    // "curriculum")
    // @JoinColumn(name = "ciu_id")
    @OneToOne( cascade = CascadeType.ALL, mappedBy = "curriculum")
    private Ciudadano ciudadano;

    public Curriculum() {
    }
    // List

    public Curriculum(Long curriculumNumber, Ciudadano ciudadano, String nombre, String apellido, String direccion,
            String pais, String genero, String idioma, String conocimientos, String infoComplementaria,
            String datoAdicionales) {
        this.curriculumNumber = curriculumNumber;
        this.ciudadano = ciudadano;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.pais = pais;
        this.idioma = idioma;
        this.conocimientos = conocimientos;
        this.infoComplementaria = infoComplementaria;
        this.datoAdicionales = datoAdicionales;
        // this.provincia = provincia;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    // public Contacto getContacto() {
    // return contacto;
    // }

    // public void setContacto(Contacto contacto) {
    // this.contacto = contacto;
    // }

    // public List<Experiencia> getExperiencia() {
    // return experiencia;
    // }

    // public void setExperiencia(List<Experiencia> experiencia) {
    // this.experiencia = experiencia;
    // }

    // public List<Educacion> getEducacion() {
    // return educacion;
    // }

    // public void setEducacion(List<Educacion> educacion) {
    // this.educacion = educacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // public String getProvincia() {
    // return provincia;
    // }

    // public void setProvincia(String provincia) {
    // this.provincia = provincia;
    // }

}
