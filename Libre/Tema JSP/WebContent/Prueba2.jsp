<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expresiones JPS</title>
</head>
<body>
Fecha y hora actual: <%= new java.util.Date() %><br />
Servidor: <%= application.getServerInfo() %><br />
Identificador de la sesión: <%= session.getId() %><br />
El <CODE>parámetro </CODE> del formulario:
<%= request.getParameter("testParam") %>
</body>
</html>