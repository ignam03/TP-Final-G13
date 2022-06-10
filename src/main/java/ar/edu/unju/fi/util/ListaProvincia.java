package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.entity.Provincia;


public class ListaProvincia {
	private ArrayList<Provincia> provincia;
    
    
	public ListaProvincia(){
        provincia = new ArrayList<Provincia>();
        provincia.add(new Provincia("Buenos Aires"));
        provincia.add(new Provincia("Catamarca"));
        provincia.add(new Provincia("Chaco"));
        provincia.add(new Provincia("Chubut"));
        provincia.add(new Provincia("Córdoba"));
        provincia.add(new Provincia("Entre Ríos"));
        provincia.add(new Provincia("Formosa"));
        provincia.add(new Provincia("Jujuy"));
        provincia.add(new Provincia("La Pampa"));
        provincia.add(new Provincia("La Rioja"));
        provincia.add(new Provincia("Mendoza"));
        provincia.add(new Provincia("Misiones"));
        provincia.add(new Provincia("Neuquén"));
        provincia.add(new Provincia("Río Negro"));
        provincia.add(new Provincia("Salta"));
        provincia.add(new Provincia("San Juan"));
        provincia.add(new Provincia("San Luis"));
        provincia.add(new Provincia("Santa Cruz"));
        provincia.add(new Provincia("Santa Fe"));
        provincia.add(new Provincia("Santiago del Estero"));
        provincia.add(new Provincia("Tierra del Fuego, Antártida e Islas del Atlántico Sur"));
        provincia.add(new Provincia("Tucumán"));
    }

}
