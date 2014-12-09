package com.Proyecto.ServiciosdeDominio;

import java.util.ArrayList;

public interface DAOServices {
	
	
	public boolean registro(Object entidad);
	public ArrayList<?>listar();
	public boolean borrar(Object Entidad);
	public boolean consultaIndividual(Object Entidad, String SQL);

}
