package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.entity.Educacion;

public class ListaEducacion {
	private ArrayList<Educacion> estadoC;
        
	public ListaEducacion(){
        estadoC = new ArrayList<Educacion>();
        estadoC.add(new Educacion("Primario Completo"));
        estadoC.add(new Educacion("Secundario Completo"));
        estadoC.add(new Educacion("Terceario/Universidad Completo"));
	}
}
