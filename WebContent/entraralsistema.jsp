<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/estiloPagina.css" type="text/css" rel="stylesheet"/>
<link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- css personalizados-->
    <link href="css/freelancer.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de sesion</title>
</head>
<body>    
	<!-- Navigation -->
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
                <a class="navbar-brand" href="#page-top">Seleccion de administrador </a>
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
	
	
	
	 
	<f:view>
		<h:form>
		<center>
<h:outputText value="selecione al administrador"></h:outputText>

 
<h:selectOneMenu value="#{administrador.nombre}">  
    <f:selectItems value="#{dAOAdministrador.mostrarTodos()}" />  
</h:selectOneMenu>  


<h:inputSecret value="#{administrador.password}"></h:inputSecret>   
 
  
   
				
		 		  
				    
				<h:commandButton  styleClass=" btn btn-default" value="volver" ></h:commandButton>
				<h:commandButton styleClass="btn btn-default"  value="iniciarSesion" ></h:commandButton>
		</center>
		</h:form>

	</f:view>
</body>
</html>