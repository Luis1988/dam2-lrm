<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usando jsp:setProperty</title>
</head>
<body bgcolor="FFCC99">
<center>
	<p align="center" style="border-style:double; background-color: orange; width: 269px"><b><font size="5">Usando jsp:setProperty</font></b></p>
	<jsp:useBean id="producto" class="pruebaBeans.Producto" />
	<jsp:setProperty name="producto" property="*" />
	<table border="1">
		<tr bgcolor="#FF8000">
			<th>Id producto</th>
			<th>Precio Unitario</th>
			<th>Cantidad Pedida</th>
			<th>Precio Total</th>
		</tr>
		<tr>
			<td><jsp:getProperty name="producto" property="idProducto" /></td>
			<td>$<jsp:getProperty name="producto" property="costeProducto" /></td>
			<td><jsp:getProperty name="producto" property="numProductos" /></td>
			<td>$<jsp:getProperty name="producto" property="costeTotal"/></td>
		</tr>
	</table>
</center>
</body>
</html>