package com.Proyecto.AccesoaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.Proyecto.Modelo.Administrador;
import com.Proyecto.Modelo.Ruta;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAORuta extends DAOManager implements DAOServices {

	@Override
	public boolean registro(Object entidad,Object...args) {
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
					.prepareStatement("insert into ruta(NombreRuta) values(?) ");

			SQL.setObject(1, ((Ruta) entidad).getNombreRuta());

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

		ResultSet resultado = null;
		Connection conexion = null;
		int i = 0;
		ArrayList<Ruta> lista = new ArrayList<Ruta>();

		try {
			conexion = this.Conectar();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			java.sql.Statement SQL = conexion.createStatement();
			resultado = SQL.executeQuery("select * from ruta");

			while (resultado.next()) {
				lista.add(i,
						new Ruta(resultado.getInt(1), resultado.getString(2)));
				i++;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}

		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> nombres = new ArrayList<String>();

		for (int x = 0; x <lista.size(); x++) {

			SelectItem item = new SelectItem();
			item.setValue(lista.get(x).getNombreRuta());
			System.out.print("HOLLLAAAAA este es un  "
					+ lista.get(x).getNombreRuta());
			nombres.add(x, lista.get(x).getNombreRuta());

		}

		return nombres;

	}

	@Override
	public boolean borrar(Object Entidad,Object...args) {
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
					.prepareStatement("delete  from ruta where NombreRuta=? ");

			SQL.setObject(1, ((Ruta) Entidad).getNombreRuta());

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
	public boolean consultaIndividual(Object Entidad, String SQL) {
		return false;
	}

}
