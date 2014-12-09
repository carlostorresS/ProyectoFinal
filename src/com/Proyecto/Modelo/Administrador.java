package com.Proyecto.Modelo;

public class Administrador {
 private String nombre;
 private int ID;
 private String password;
public Administrador(int ID, String password,String nombre) {
this.ID=ID;
this.nombre=nombre;
this.password=password;
}
public Administrador(){
	
}

/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}
/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
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
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
 
}
