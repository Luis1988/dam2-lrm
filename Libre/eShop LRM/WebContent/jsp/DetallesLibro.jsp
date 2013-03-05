<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="eShop.beans.Libro"/>
<jsp:scriptlet>
String base = (String)application.getAttribute("base");
String imagen = (String)application.getAttribute("imageURL");
String idLibro = request.getParameter("idLibro");
</jsp:scriptlet>
<jsp:useBean id="dataManager" scope="application" class="eShop.model.DataManager"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detalles del Libro</title>
<link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css"
	type="text/css" />
</head>
<body>
	<jsp:include page="TopMenu.jsp" flush="true"/>
	<jsp:include page="LeftMenu.jsp" flush="true"/>
	<div class="content">
	<h2>Detalles del Libro</h2>
	<%
	Libro l = dataManager.getDetallesLibro(idLibro);
	%>
	<table>
	<tr>
	<td><img src="<%=imagen %><%=idLibro %>.gif"></td>
	<td>
	<table>
	<tr><td><b><%=l.getTitulo() %></b></td></tr>
	<tr><td><%=l.getAutor() %></td></tr>
	<tr><td>Precio: $<%=l.getPrecio() %></td></tr>
	</table>
	</td>
	</tr>
	<tr><td></td><td align="right"><a class="link1" href="<%=base %>?action=addProducto&idLibro=<%=idLibro %>">Añadir al carrito</a></td></tr>
	</table>
	</div>
</body>
</html>