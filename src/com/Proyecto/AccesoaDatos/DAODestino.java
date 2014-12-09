package com.Proyecto.AccesoaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.Proyecto.Modelo.Destino;
import com.Proyecto.Modelo.Ruta;
import com.Proyecto.ServiciosdeDominio.DAOManager;
import com.Proyecto.ServiciosdeDominio.DAOServices;

public class DAODestino  extends DAOManager implements DAOServices{

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
					.prepareStatement("insert into destino(NombreDestino,Latitud,Longitud) values(?,?,?) ");

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

		ResultSet resultado = null;
		Connection conexion = null;
		int i = 0;
		ArrayList<Destino> lista = new ArrayList<Destino>();

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
			resultado = SQL.executeQuery("select * from destino");

			while (resultado.next()) {
				lista.add(i,
						new Destino(resultado.getInt(1), resultado.getString(2),resultado.getFloat(3),resultado.getFloat(4)));
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
			item.setValue(lista.get(x).getDestino());
			System.out.print("HOLLLAAAAA este es un  "
					+ lista.get(x).getDestino());
			nombres.add(x, lista.get(x).getDestino());

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
