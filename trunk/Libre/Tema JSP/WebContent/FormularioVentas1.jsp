<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Llamando a VentaEntradas1.jsp</title>
</head>
<body>
	<center><p align="center" style="border-style:double; background-color: orange; width: 351px"><b><font size="5">Llamando a VentaEntradas1.jsp</font></b></p>
	<form action="VentaEntradas1.jsp" method="get">
		ID Producto: <input type="text" name="idProducto" /><br />
		Unidades: <input type="text" name="numProductos" /><br />
		Código de descuento: <input type="text" name="codDescuento" /><br /><br />
		<input type="submit" value="Mostrar Precio"/>
	</form>
	</center>
</body>
</html>