package com.Proyecto.ServiciosdeDominio;

import java.util.ArrayList;

public interface DAOServices {
	
	
	public boolean registro(Object entidad,Object...args);
	public ArrayList<?>listar();
	public boolean borrar(Object Entidad, Object...args);
	public boolean consultaIndividual(Object Entidad, String SQL);

}
