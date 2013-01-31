<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Declaraciones JSP</title>
</head>
<body>
<H1>Declaraciones JSP</H1>
<%! private int contadorAccesos = 0; %>
<H2>Accesos a la página desde que se inició el servidor:
<%= ++contadorAccesos %></H2>
</body>
</html>