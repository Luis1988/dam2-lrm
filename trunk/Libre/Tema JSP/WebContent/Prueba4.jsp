<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba de color de fondo</title>
</head>
<%
String bgColor = request.getParameter("bgColor");
if ((bgColor == null) || (bgColor.trim().equals(""))) {
bgColor = "WHITE";
}
%>
<body BGCOLOR="<%= bgColor %>">
<H2 ALIGN="CENTER">Probando un fondo de color "<%= bgColor %>".</H2>
</body>
</html>