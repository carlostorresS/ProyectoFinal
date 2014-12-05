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

	
	public boolean Registrar(String nombre) {
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
					.prepareStatement("insert into administradores (ID,Nombre) values(0,?)");
			SQL.setString(1, nombre);
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

//	public ArrayList<?> getUsuarios(String consulta) {
//		ResultSet resultado = null;
//		Connection conexion = null;
//		int i=0;
//		ArrayList<Object> lista = new ArrayList<Object>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			conexion = this.Conectar();
//
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			java.sql.Statement SQL = conexion.createStatement();
//			resultado = SQL.executeQuery(consulta);
//
//			while (resultado.next()) {
//				 lista.add(i,new Usuario(resultado.getInt(1),resultado.getString(2)
//                         ,resultado.getInt(3),resultado.getInt(4),resultado.getInt(5)));
//                           i++;
//
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//
//	}
	
	
	
	
//	public ArrayList<?> getCategorias(String consulta) {
//		ResultSet resultado = null;
//		Connection conexion = null;
//		int i=0;
//		ArrayList<Object> lista = new ArrayList<Object>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			conexion = this.Conectar();
//
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			java.sql.Statement SQL = conexion.createStatement();
//			resultado = SQL.executeQuery(consulta);
//
//			while (resultado.next()) {
//				 lista.add(i,new Categoria(resultado.getString(1)));
//                           i++;
//
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//
//	}
//	
//
//	
//	
//	
//	public ArrayList<String> realizarConsultaporCategoria(String consulta,String categoria) {
//		ResultSet resultado = null;
//		Connection conexion = null;
//		ArrayList<String> lista = new ArrayList<String>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			conexion = this.Conectar();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			java.sql.PreparedStatement SQL = conexion.prepareStatement(consulta);
//			SQL.setString(1, categoria);
//resultado=SQL.executeQuery();
//			while (resultado.next()) {
//				lista.add(resultado.getString(1));
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			conexion.close();
//			resultado.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//
//	}
//
//	
//	public boolean actualizarGanador(String user){
//		Connection conexion = null;
//		boolean bandera = false;
//		try {
//			conexion = this.Conectar();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			PreparedStatement SQL = conexion
//					.prepareStatement("UPDATE usuarios SET PartidasGanadas=PartidasGanadas+1,PartidasJugadas=PartidasJugadas+1 where nombre=?;");
//			SQL.setString(1, user);
//			if (SQL.execute()) {
//				bandera = true;
//			} else {
//				bandera = false;
//			}
//
//			SQL.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return bandera;
//
//		
//		
//	}
//	public boolean actualizarPerdedor(String user){
//		Connection conexion = null;
//		boolean bandera = false;
//		try {
//			conexion = this.Conectar();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			PreparedStatement SQL = conexion
//					.prepareStatement("UPDATE usuarios SET PartidasPerdidas=PartidasPerdidas+1, PartidasJugadas=PartidasJugadas+1 where nombre=?;");
//			SQL.setString(1, user);
//			if (SQL.execute()) {
//				bandera = true;
//			} else {
//				bandera = false;
//			}
//
//			SQL.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return bandera;
//
//		
//		
//	}

}
