package com.Proyecto.AccesoaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.Proyecto.Modelo.Administrador;
import com.Proyecto.Modelo.Ruta;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;


public class DAOAdministrador extends DAOManager implements DAOServices {
	
	
	
	


	@Override
	public boolean registro(Object entidad, Object... args) {
	
		
		
		
		
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public ArrayList<?> listar() {
		
		
		ResultSet resultado = null;
		Connection conexion = null;
		int i = 0;
		ArrayList<Administrador> lista = new ArrayList<Administrador>();

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
			resultado = SQL.executeQuery("select * from administrador");

			while (resultado.next()) {
				lista.add(i,
						new Administrador(resultado.getInt(1), resultado.getString(2),resultado.getString(3)));
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
			item.setValue(lista.get(x).getNombre());
			System.out.print("HOLLLAAAAA este es un  "
					+ lista.get(x).getNombre());
			nombres.add(x, lista.get(x).getNombre());

		}

		return nombres;

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
