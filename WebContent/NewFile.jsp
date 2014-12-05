<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:m="http://code.google.com/p/gmaps4jsf/">
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
                xmlns:ui="http://java.sun.com/jsf/facelets">
    <ui:define name="js">
        <script type="text/javascript"
                src="https://maps.googleapis.com/maps/api/js?sensor=true">
        </script>
    </ui:define>
    <ui:define name="title">
        This is the new title
    </ui:define>
    <ui:define name="content">
        <h1>EL MAPA VA AQUI</h1>

        <h:form id="form">
            <m:map width="500" height="450px" latitude="37.13" longitude="22.43" enableScrollWheelZoom="true">
                <m:marker>
                    <m:htmlInformationWindow htmlText="This is Sparta, Greece"/>
                </m:marker>
            </m:map>
        </h:form>
    </ui:define>
</ui:composition>
</html>