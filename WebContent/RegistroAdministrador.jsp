<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>
 <h:form>
			<center>
				<h:panelGrid columns="3">
					<h:outputLabel for="txtNombre" value="Nombre del administrador:" />
					<h:inputText id="txtNombre" label="Nombre" required="true"
						value= "#{administrador.nombre}" />
					<h:message for="txtNombre" />


					<h:commandButton styleClass="btn btn-default" value="Enviar"
						action="#{dAOAdministrador.registroUsuario(administrador)}" />
					<h:outputText value=" bienvenido a bordo #{administrador.nombre}"></h:outputText>

				</h:panelGrid>
			</center>
		</h:form>

		<h:form>
			<center>
				
			</center>
		</h:form>
 
</f:view>
</body>
</html>