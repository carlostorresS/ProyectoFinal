<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
      #map-canvas {
        width: 500px;
        height: 400px;
      }
    </style>
</head>
<body>
     
	 Registro de posiciones de la ruta
	 	<form id="google" name="google" action="#">
 
		<p><label>Direcci&oacute;n: </label>
		<input style="width:400px" type="text" id="direccion" name="direccion" value=""/>
		<button id="pasar">Obtener coordenadas del lugar</button> 
		</p>
		
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script> 
    var lat = null;
	var lng = null;
	var map = null;
	var geocoder = null;
	var marker = null;
	         
	jQuery(document).ready(function(){
	     //obtenemos los valores en caso de tenerlos en un formulario ya guardado en la base de datos
	     lat = jQuery('#lat').val();
	     lng = jQuery('#long').val();
	     //Asignamos al evento click del boton la funcion codeAddress
	     jQuery('#pasar').click(function(){
	        codeAddress();
	        return false;
	     });
	     //Inicializamos la función de google maps una vez el DOM este cargado
	    initialize();
	});
	     
	    function initialize() {
	     
	      geocoder = new google.maps.Geocoder();
	        
	       //Si hay valores creamos un objeto Latlng
	       if(lat !='' && lng != '')
	      {
	         var latLng = new google.maps.LatLng(lat,lng);
	      }
	      else
	      {
	         var latLng = new google.maps.LatLng(32.658643,-115.478541);
	      }
	      //Definimos algunas opciones del mapa a crear
	       var myOptions = {
	          center: latLng,//centro del mapa
	          zoom: 15,//zoom del mapa
	          mapTypeId: google.maps.MapTypeId.ROADMAP //tipo de mapa, carretera, híbrido,etc
	        };
	        //creamos el mapa con las opciones anteriores y le pasamos el elemento div
	        map = new google.maps.Map(document.getElementById("map-canvas"), myOptions);
	         
	        //creamos el marcador en el mapa
	        marker = new google.maps.Marker({
	            map: map,//el mapa creado en el paso anterior
	            position: latLng,//objeto con latitud y longitud
	            draggable: true //que el marcador se pueda arrastrar
	        });
	        
	       //función que actualiza los input del formulario con las nuevas latitudes
	       //Estos campos suelen ser hidden
	        updatePosition(latLng);
	         
	         
	    }
	     
	    //funcion que traduce la direccion en coordenadas
	    function codeAddress() {
	         
	        //obtengo la direccion del formulario
	        var address = document.getElementById("direccion").value;
	        //hago la llamada al geodecoder
	        geocoder.geocode( { 'address': address}, function(results, status) {
	         
	        //si el estado de la llamado es OK
	        if (status == google.maps.GeocoderStatus.OK) {
	            //centro el mapa en las coordenadas obtenidas
	            map.setCenter(results[0].geometry.location);
	            //coloco el marcador en dichas coordenadas
	            marker.setPosition(results[0].geometry.location);
	            //actualizo el formulario      
	            updatePosition(results[0].geometry.location);
	             
	            //Añado un listener para cuando el markador se termine de arrastrar
	            //actualize el formulario con las nuevas coordenadas
	            google.maps.event.addListener(marker, 'dragend', function(){
	                updatePosition(marker.getPosition());
	            });
	      } else {
	          //si no es OK devuelvo error
	          alert("No se encontro la direcion: " + status);
	      }
	    });
	  }
	   
	  //funcion que simplemente actualiza los campos del formulario
	  function updatePosition(latLng)
	  {
	       
	       jQuery('#lat').val(latLng.lat());
	       jQuery('#long').val(latLng.lng());
	   
	  }
    
    </script>
 		

<f:view>
Soy el mapa
    <div id="map-canvas"></div>
  
  <h:form>
  <h:inputText  value="#{posicion.latitud }"  r id="lat"/>
		 Longitud: <h:inputText value="#{posicion.longitud}" id="long"/>
	Ruta:<h:selectOneMenu value="#{ruta.nombreRuta}">  
    <f:selectItems value="#{daoRuta.listar()}" />  
</h:selectOneMenu>    
  
  </h:form>
 
		
		
		
		</f:view>
</body>
</html>