package com.Proyecto.Modelo;

public class Ruta {
private int ID; 
	public Ruta(int ID, String Ruta) {
		this.ID=ID;
		this.nombreRuta=Ruta;		
		
	// TODO Auto-generated constructor stub
}
	
	
	public Ruta(){
		
	}
	/**
 * @return the iD
 */
public int getID() {
	return ID;
}
/**
 * @param iD the iD to set
 */
public void setID(int iD) {
	ID = iD;
}
/**
 * @return the nombreRuta
 */
public String getNombreRuta() {
	return nombreRuta;
}
/**
 * @param nombreRuta the nombreRuta to set
 */
public void setNombreRuta(String nombreRuta) {
	this.nombreRuta = nombreRuta;
}
	private String nombreRuta;
}
