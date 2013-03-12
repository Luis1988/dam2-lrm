<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscar Vuelos</title>
</head>
<body>
<h1>Buscar Vuelos</h1>
<form>
<table border="1">
<input type="hidden" name="action" value="buscar"/>
<tr><td><b>Origen:</b></td><td><input type="text" name="origen" /></td>
<tr><td><b>Destino:</b></td><td><input type="text" name="destino" /></td>
<tr><td><b>Fecha de salida:</b></td><td><input type="text" name="fechaSalida" /></td></tr>
<tr><td><b>Fecha de llegada:</b></td><td><input type="text" name="fechaLlegada" /></td></tr>
<tr><td><b>Nº de personas:</b></td><td><input type="text" name="numPersonas" /></td></tr>
<input type="hidden" name="orden" value="PRECIO" />
</table>
<p><input type="submit" value="Buscar" /></p>
</form>
</body>
</html>