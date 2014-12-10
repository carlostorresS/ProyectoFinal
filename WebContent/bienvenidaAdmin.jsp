<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>

<link href="css/estiloPagina.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap.min.css" rel="stylesheet"></link>

    <!-- css personalizados-->
    <link href="css/freelancer.css" rel="stylesheet"/>





<script type="text/javascript">
function showLightbox() {//formulario para registro de rutas
	document.getElementById('over').style.display='block';
	document.getElementById('fade').style.display='block';
}


function hideLightbox() {
	document.getElementById('over').style.display='none';
	document.getElementById('fade').style.display='none';
}

function showLightbox2() {//formulario para borrar rutas
	document.getElementById('borrar').style.display='block';
	document.getElementById('fade2').style.display='block';
}


function hideLightbox2() {
	document.getElementById('borrar').style.display='none';
	document.getElementById('fade2').style.display='none';
}

function showLightbox3() {//formulario para especificar marca
	document.getElementById('marca').style.display='block';
	document.getElementById('fade3').style.display='block';
}


function hideLightbox3() {
	document.getElementById('marca').style.display='none';
	document.getElementById('fade3').style.display='none';
}



</script>
<style type="text/css">
body {
	background-color: #FFFFFF;
	font-family: "Trebuchet MS", Tahoma, Verdana;
	font-size: 12px;
	font-weight: normal;
	color: #666666;
	margin: 10px;
	padding: 0;
}
.fadebox {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index:1001;
	-moz-opacity: 0.8;
	opacity:.80;
	filter: alpha(opacity=80);
}
.overbox {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	z-index:1002;
	overflow: auto;
}
#content {
	background: #FFFFFF;
	border: solid 3px #CCCCCC;
	padding: 10px;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">Gestion de rutas </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                 </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header >
        <div class="container">
         
          </div>
    </header>
	





<center><a href="javascript:showLightbox();">RegistrarRuta</a></center>
<center><a href="javascript:showLightbox2();">BorrarRuta</a></center>
<center><a href="javascript:showLightbox3();">Especificar Marca</center>

  


<f:view>
<center><h:commandButton value="registrarRecorrido"  styleClass= "btn btn-default"></h:commandButton></center>




   

<div id="over" class="overbox">
	<div id="content">
	

<h:form> 
<h:inputText value="#{ruta.nombreRuta}"></h:inputText>
<h:commandButton value="dar de alta" action="#{daoRuta.registro(ruta,ruta)}" ></h:commandButton>
<a href="javascript:hideLightbox();">Cerrar</a>
</h:form>
	  
	</div>
</div>
<div id="fade" class="fadebox">&nbsp;</div> 


<div id="borrar" class="overbox">
	<div id="content">
	

<h:form>
<h:selectOneMenu value="#{ruta.nombreRuta}">  
    <f:selectItems value="#{daoRuta.listar()}" />  
</h:selectOneMenu>    
<h:commandButton value="eliminar la ruta" action="#{daoRuta.borrar(ruta,ruta)}"></h:commandButton>
<a href="javascript:hideLightbox2();">Cerrar</a>


</h:form>
	
	</div>
</div>
<div id="fade" class="fadebox">&nbsp;</div>



<div id="fade3" class="fadebox">&nbsp;</div>


<div id="marca" class="overbox">
	<div id="content">



<h:form> 
<center>
<div>
Marca de camion<h:inputText value="#{marca.nombreMarca}"></h:inputText>
id de ruta<h:inputText value="#{ruta.ID}" ></h:inputText>
<h:commandButton  value="registrar marca" action="#{dAOMarca.registro(marca,ruta)}"></h:commandButton>
<a href="javascript:hideLightbox3();">Cerrar</a>

</div>
</center>
</h:form>

</div>
</div>
<div id="fade3" class="fadebox">&nbsp;</div>



 
</f:view>
</body>
</html>
