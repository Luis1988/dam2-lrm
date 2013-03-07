<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dataManager" scope="application"
  class="eShop.model.DataManager"/>
  <%
  String base = (String)application.getAttribute("base");
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comprar</title>
<link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css"
	type="text/css" />
</head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"/>
<jsp:include page="LeftMenu.jsp" flush="true"/>
<div class="content">
<h2>Comprar</h2>
<form><input type="hidden" name="action" value="confirmarPedido"/>
<table>
<tr><th>Detalles de Pedido</th><th><th></th></tr>
<tr><td>Nombre de Entrega:</td><td><input type="text" name="nContacto" /></tr>
<tr><td>Dirección de Entrega:</td><td><input type="text" name="address" /></tr>
<tr><th>Detalles de la Tarjeta de Crédito</th><th><th></th></tr>
<tr><td>Nombre en la Tarjeta de Crédito:</td><td><input type="text" name="nTarjeta" /></tr>
<tr><td>Número Tarjeta de Crédito:</td><td><input type="text" name="numTarjeta" /></tr>
<tr><td>Fecha Expiración Tarjeta de Crédito:</td><td><input type="text" name="fExp" /></tr>
<tr><td></td><td><input id="submit" type="submit" value="Comprar"></tr>
</table>
</form>
</div>
</body>
</html>