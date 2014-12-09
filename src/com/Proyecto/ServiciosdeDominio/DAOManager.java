package com.Proyecto.ServiciosdeDominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Proyecto.Modelo.Administrador;

//Prueba para ver si funciona la conexion a la base de datos

public class DAOManager {
	private DataSource ds;

	public DAOManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/proyecto");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Connection Conectar() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/proyecto", "root", "");
		return con;

	}

	
	
	
}
