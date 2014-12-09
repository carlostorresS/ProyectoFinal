<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>

<h:outputText value="HOLA"></h:outputText>
hola tu sesion es correcta
   

<h:outputLink ><h:outputText value="registrarRuta"></h:outputText></h:outputLink>
<h:form>
<h:inputText value="#{ruta.nombreRuta}"></h:inputText>
<h:commandButton value="dar de alta" action="#{daoRuta.registro(ruta,ruta) }" ></h:commandButton>
</h:form>






<h:outputLink><h:outputText value="eliminar  Ruta"></h:outputText></h:outputLink>

<h:form>
<h:selectOneMenu value="#{ruta.nombreRuta}">  
    <f:selectItems value="#{daoRuta.listar()}" />  
</h:selectOneMenu>    
<h:commandButton value="eliminar la ruta" action="#{daoRuta.borrar(ruta,ruta)}"></h:commandButton>
</h:form>


<h:form>
Marca de camion<h:inputText value="#{marca.nombreMarca}"></h:inputText>
id de ruta<h:inputText value="#{ruta.ID}" ></h:inputText>
<h:commandButton  value="registrar marca" action="#{dAOMarca.registro(marca,ruta)}"></h:commandButton>
</h:form>


 
</f:view>
</body>
</html>
