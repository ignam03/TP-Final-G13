package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Provincia;

@Component
public class ListaProvincia {

    private List<Provincia> provincias;

    public ListaProvincia() {
        provincias = new ArrayList<Provincia>();;
        provincias.add(new Provincia(2, "Buenos Aires"));
        provincias.add(new Provincia(3, "Catamarca"));
        provincias.add(new Provincia(4, "Chaco"));
        provincias.add(new Provincia(5, "Chubut"));
        provincias.add(new Provincia(6, "Córdoba"));
        provincias.add(new Provincia(7, "Entre Ríos"));
        provincias.add(new Provincia(8, "Formosa"));
        provincias.add(new Provincia(9, "Jujuy"));
        provincias.add(new Provincia(10, "La Pampa"));
        provincias.add(new Provincia(11, "La Rioja"));
        provincias.add(new Provincia(12, "Mendoza"));
        provincias.add(new Provincia(13, "Misiones"));
        provincias.add(new Provincia(14, "Neuquén"));
        provincias.add(new Provincia(15, "Río Negro"));
        provincias.add(new Provincia(16, "Salta"));
        provincias.add(new Provincia(17, "San Juan"));
        provincias.add(new Provincia(18, "San Luis"));
        provincias.add(new Provincia(19, "Santa Cruz"));
        provincias.add(new Provincia(20, "Santa Fe"));
        provincias.add(new Provincia(21, "Santiago del Estero"));
        provincias.add(new Provincia(22, "Tierra del Fuego, Antártida e Islas del Atlántico Sur"));
        provincias.add(new Provincia(23, "Tucumán"));
    }

    public ListaProvincia(List<Provincia> provincias) {
        super();
        this.provincias = provincias;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

}
