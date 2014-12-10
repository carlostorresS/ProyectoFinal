package com.Proyecto.AccesoaDatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import com.Proyecto.Modelo.Destino;
import com.Proyecto.Modelo.Posicion;
import com.Proyecto.Modelo.Ruta;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAOPosiciones  extends DAOManager implements DAOServices{

	
	
	
	
	@Override
	public boolean registro(Object entidad, Object... args) {
		PreparedStatement SQL;
		Connection conexion = null;
		boolean bandera = true;
		try {
			conexion = this.Conectar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			SQL = conexion
					.prepareStatement("insert into posiciones(latitud,longitud,idRuta) values(?,?,?) ");

			SQL.setObject(1, ((Posicion) entidad).getLatitud());
			
			SQL.setObject(2, ((Posicion)entidad).getLongitud());
SQL.setObject(3, ((Ruta)args[0]).getID());
			
			if (SQL.execute()) {
				bandera = true;
			} else {
				bandera = false;
		
			}
			SQL.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bandera;


	
	
	
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
