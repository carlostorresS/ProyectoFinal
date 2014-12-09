package com.Proyecto.Sesiones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.Proyecto.Modelo.Administrador;
import com.Proyecto.ServiciosdeDominio.DAOManager;

public class SessionManager  extends DAOManager{
	
	 
	
	
	public boolean validarSesion(Administrador admin){
		System.out.print(admin.getID());
		System.out.print(admin.getNombre());
		System.out.print(admin.getPassword());
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
					.prepareStatement("select Nombre,Pass from administrador where Nombre=? and Pass=?");
			SQL.setString(1, admin.getNombre());
			SQL.setString(2, admin.getPassword());
			
			ResultSet resultado=SQL.executeQuery();
			if (resultado.first()) {
				bandera = true;
				this.redireccionar(bandera);

			  
			} else {
				bandera = false;
				this.redireccionar(bandera);
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
	
	
	
	public void redireccionar(boolean bandera){
		ExternalContext ctx = 
			      FacesContext.getCurrentInstance().getExternalContext();
			  
			  try {  
			   if(true){
				  
				  ctx.redirect("http://localhost:8080/ProyectoFinal/faces/bienvenidaAdmin.jsp");
			   } 
			   
			  else{
				
				   
				   ctx.redirect("http://localhost:8080/ProyectoFinal/faces/error.jsp");
			  }
			    
			   } catch (IOException ex) {
			    ex.printStackTrace();
	}
}
}