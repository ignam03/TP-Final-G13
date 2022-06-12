package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.entity.Idioma;

public class ListaIdiomas {
private ArrayList<Idioma> estadoC;
    
	public ListaIdiomas(){
        estadoC = new ArrayList<Idioma>();
        estadoC.add(new Idioma("Español"));
        estadoC.add(new Idioma("Ingles"));
        estadoC.add(new Idioma("Portugues"));
        estadoC.add(new Idioma("Chino"));
        estadoC.add(new Idioma("Aleman"));
        estadoC.add(new Idioma("Ruso"));
	}
}
