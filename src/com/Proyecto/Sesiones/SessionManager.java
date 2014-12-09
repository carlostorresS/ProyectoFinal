package com.Proyecto.Sesiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Proyecto.ServiciosdeDominio.DAOManager;

public class SessionManager  extends DAOManager{
	
	
	
	
	
	public boolean validarSesion(String nombre, String password){
		
		Connection conexion = null;
		boolean bandera = false;
		try {
			conexion = this.Conectar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement SQL = conexion
					.prepareStatement("select Nombre,Pass from administradores where nombre=? and password=?");
			SQL.setString(1, nombre);
			SQL.setString(2, password);
			SQL.getMaxRows();
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
}
