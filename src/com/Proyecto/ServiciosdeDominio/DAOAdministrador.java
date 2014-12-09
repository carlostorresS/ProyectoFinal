package com.Proyecto.ServiciosdeDominio;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import com.Proyecto.Modelo.Administrador;


public class DAOAdministrador {
	public boolean registroUsuario(Administrador admin) {
		DAOManager sql = new DAOManager();

		String nombre=admin.getNombre();
		
		sql.Registrar(nombre);
return true;
	}
	 
	
	
	public ArrayList<String> mostrarTodos() throws SQLException {
		DAOManager busqueda = new DAOManager();

		ArrayList<Administrador> lista = (ArrayList<Administrador>) busqueda
				.getUsuarios("select * from administrador");

		ArrayList<String> nombres = new ArrayList<String>();

		for (int i = 0; i <lista.size(); i++) {

			SelectItem item = new SelectItem();
			item.setValue(lista.get(i).getNombre());
			System.out.print("HOLLLAAAAA este es un  "
					+ lista.get(i).getNombre());
			nombres.add(i,lista.get(i).getNombre());

		}

		return nombres;
	}

	
	public void iniciarSesion(Administrador admin){
		
		
	}

}
