package com.Proyecto.AccesoaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Proyecto.Modelo.Marca;
import com.Proyecto.Modelo.Ruta;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAOMarca  extends DAOManager implements DAOServices{

	@Override
	public boolean registro(Object entidad,Object ...args) {
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
					.prepareStatement("insert into marca (NombreMarca,idruta) values(?,?) ");

			SQL.setObject(1, ((Marca) entidad).getNombreMarca());
			SQL.setObject(2, ((Ruta)args[0]).getID());

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
		return null;
	}

	@Override
	public boolean borrar(Object Entidad, Object...args) {
		return false;
	}

	@Override
	public boolean consultaIndividual(Object Entidad, String SQL) {
		return false;
	}

}
