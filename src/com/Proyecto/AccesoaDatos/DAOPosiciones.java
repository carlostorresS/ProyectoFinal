package com.Proyecto.AccesoaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Proyecto.Modelo.Destino;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAOPosiciones  extends DAOManager implements DAOServices{

	@Override
	public boolean registro(Object entidad, Object... args) {
	
		PreparedStatement SQL;
		Connection conexion = null;
		boolean bandera = false;
		try {
			conexion = this.Conectar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			SQL = conexion
					.prepareStatement("insert into posiciones(NombreDestino,Latitud,Longitud) values(?,?,?) ");

			SQL.setObject(1, ((Destino) entidad).getDestino());
			SQL.setObject(2, ((Destino)entidad).getLatitud());
			SQL.setObject(3, ((Destino)entidad).getLongitud());

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
