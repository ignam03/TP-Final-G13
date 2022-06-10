package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.entity.EstadoCivil;

public class ListaEstadoCivil {
	private ArrayList<EstadoCivil> estadoC;
    
    
	public ListaEstadoCivil(){
        estadoC = new ArrayList<EstadoCivil>();
        estadoC.add(new EstadoCivil("Soltero"));
        estadoC.add(new EstadoCivil("Casado"));
	}
}
