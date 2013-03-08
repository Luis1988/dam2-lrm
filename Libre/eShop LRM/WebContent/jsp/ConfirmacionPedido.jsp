<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="eShop.beans.Cliente"%>
<%@page import="java.util.Hashtable"%>
    <jsp:useBean id="dataManager" scope="application"
  class="eShop.model.DataManager"/>
  <jsp:useBean id="cliente" class="eShop.beans.Cliente"/>
  <jsp:setProperty property="*" name="cliente"/>
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
long id = dataManager.insertarPedido(cliente, (Hashtable<String,String>)session.getAttribute("carritoCompra"));
if (id > 0L) {
%>
<p class="info">Gracias por realizar su pedido</p>
<p class="info">Su id de compra es: <%=id %></p>
<%
session.invalidate();
} else {
%>
	<p class="error">Ha ocurrido un error durante la transacción</p>
}
<% 
}
%>
</div>
</body>
</html>