<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cálculo de la velocidad</title>
</head>
<body>
<%@ page errorPage="/WEB-INF/VelocidadErrors.jsp" %>
<table border=5 align="center">
<tr><th class="TITLE">
Cálculo de la velocidad</th></tr>
</table>
<%!
private double toDouble(String valor){
	return (Double.parseDouble(valor));
}
%>
<%
double espacio = toDouble(request.getParameter("espacio"));
double tiempo = toDouble(request.getParameter("tiempo"));
double velocidad = espacio/tiempo;
%>
<ul>
<li>Espacio: <%= espacio %> km</li>
<li>Tiempo: <%= tiempo %> horas</li>
<li>Velocidad: <%= velocidad %> km/h
</ul>
</body>
</html>