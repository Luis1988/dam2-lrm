<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="eShop.beans.Cliente"%>
<%@page import="java.util.Hashtable"%>
    <jsp:useBean id="dataManager" scope="application"
  class="eShop.model.DataManager"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmación de Pedido</title>
<link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css"
	type="text/css" />
</head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"/>
<jsp:include page="LeftMenu.jsp" flush="true"/>
<div class="content">
<h2>Confirmación de Pedido</h2>
<%
String nContacto = (String)application.getAttribute("nContacto");
String address = (String)application.getAttribute("address");
String nTarjeta = (String)application.getAttribute("nTarjeta");
String numTarjeta = (String)application.getAttribute("numTarjeta");
String fExp = (String)application.getAttribute("fExp");

Cliente clie = new Cliente();
clie.setNombreEntrega(nContacto);
clie.setDireccionEntrega(address);
clie.setNombreTarjeta(nTarjeta);
clie.setNumeroTarjeta(numTarjeta);
clie.setCaducidadTarjeta(fExp);

long id = dataManager.insertarPedido(clie, (Hashtable<String,String>)application.getAttribute("carritoCompra"));
%>
<p>Gracias por realizar su pedido</p>
<p>Su id de compra es: <%=id %></p>
<%
session.invalidate();
%>
</div>
</body>
</html>