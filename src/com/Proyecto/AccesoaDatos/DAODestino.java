package com.Proyecto.AccesoaDatos;

import java.util.ArrayList;

import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAODestino  extends DAOManager implements DAOServices{

	@Override
	public boolean registro(Object entidad, Object... args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<?> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(Object Entidad, Object... args) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consultaIndividual(Object Entidad, String SQL) {
		// TODO Auto-generated method stub
		return false;
	}

}
