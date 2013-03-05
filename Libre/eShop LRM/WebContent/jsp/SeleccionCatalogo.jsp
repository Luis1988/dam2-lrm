<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="java.util.Iterator"/>
<jsp:directive.page import="eShop.beans.Libro"/>
<jsp:scriptlet>
String base = (String)application.getAttribute("base");
String id = request.getParameter("id");
</jsp:scriptlet>
<jsp:useBean id="dataManager" scope="application"
	class="eShop.model.DataManager" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selección Catálogo</title>
<link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css"
	type="text/css" />
</head>
<body>
<body>
	<jsp:include page="TopMenu.jsp" flush="true" />
	<jsp:include page="LeftMenu.jsp" flush="true" />
	<div class="content">
	<h2>Catálogo seleccionado</h2>
	<%
   		out.println("<p>Categoría: <b>"+dataManager.getNombreCategoria(id)+"</b></p>");
 	%>
 	<table>
 	<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Detalles</th></tr>
 	<%
 	ArrayList<Libro> libros = dataManager.getLibrosEnCategoria(id);
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