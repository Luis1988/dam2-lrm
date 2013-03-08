<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="java.util.Iterator"/>
<jsp:directive.page import="eShop.beans.Libro"/>
<jsp:useBean id="dataManager" scope="application"
	class="eShop.model.DataManager" />
<%
String base = (String)application.getAttribute("base");
String clave = request.getParameter("cadena");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado Búsqueda</title>
<link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css"
	type="text/css" />
</head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"></jsp:include>
<jsp:include page="LeftMenu.jsp" flush="true"></jsp:include>
<div class="content">
<h2>Resultado Búsqueda</h2>
<table>
 	<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Detalles</th></tr>
 	<%
 	ArrayList<Libro> libros = dataManager.getResultadosBusqueda(clave);
 	Iterator<Libro> itLibros = libros.iterator();
 	while(itLibros.hasNext()) {
 	Libro l = itLibros.next();
 	String idLibro = l.getIdLibro();
 	 %>
 	 <tr>
 	 <td><%=l.getTitulo() %></td>
 	 <td><%=l.getAutor() %></td>
 	 <td><%=l.getPrecio() %></td>
 	 <td><a class="link1" href="<%=base %>?action=detallesLibro&idLibro=<%=idLibro %>">Detalles</a></td>
 	 </tr>
 	 <%
 	 }
 	  %>
 </table>
</div>
</body>
</html>