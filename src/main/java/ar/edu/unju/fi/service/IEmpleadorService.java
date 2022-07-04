package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Ciudadano;
import ar.edu.unju.fi.entity.Empleador;

public interface IEmpleadorService {

	public void saveEmpleador(Empleador empleador);

	public Empleador getEmpleadorByCuit(Long cuit)throws Exception;
}
