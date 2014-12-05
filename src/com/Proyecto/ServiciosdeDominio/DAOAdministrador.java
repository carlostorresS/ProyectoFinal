package com.Proyecto.ServiciosdeDominio;

import com.Proyecto.Modelo.Administrador;


public class DAOAdministrador {
	public boolean registroUsuario(Administrador admin) {
		DAOManager sql = new DAOManager();

		String nombre=admin.getNombre();
		
		sql.Registrar(nombre);
return true;
	}

}
