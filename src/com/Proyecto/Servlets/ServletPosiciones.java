package com.Proyecto.Servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Proyecto.AccesoaDatos.DAOPosiciones;
import com.Proyecto.Modelo.Posicion;
import com.Proyecto.Modelo.Ruta;

/**
 * Servlet implementation class ServletPosiciones
 */
@WebServlet("/ServletPosiciones")
public class ServletPosiciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPosiciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	boolean valido;
	double latitud;
	double longitud; 
Posicion posicion=new Posicion();
Ruta ruta=new Ruta();
DAOPosiciones daoPosicion=new DAOPosiciones();
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	       String lat= request.getParameter("lat");
	       String lon=request.getParameter("lng");
	     String idRuta=request.getParameter("idruta");
	     int iD=Integer.parseInt(idRuta);
	       latitud=Double.parseDouble(lat);
	       longitud=Double.parseDouble(lon);
	       
	     ruta.setID(iD);  
	    posicion.setLatitud(latitud);
	       posicion.setLongitud(longitud);
	     boolean bandera=  daoPosicion.registro(posicion, ruta);
	  
	       if(bandera){
	    	   out.print("<h1>ERROR</h1>");
	       }
	       else{
	    	   out.print("<h1>Coordenada registrada</h1>");
	    	   response.sendRedirect("http://localhost:8080/ProyectoFinal/faces/mapa.jsp");

	       }
	       
	       
	       
	       
	}  

}
