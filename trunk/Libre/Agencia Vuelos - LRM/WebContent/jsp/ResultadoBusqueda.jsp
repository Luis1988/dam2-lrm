<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.sql.Date" %>
<%@ page import="agenciaLRM.beans.Vuelos" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dataManager" scope="application"
	class="agenciaLRM.model.DataManager" />
<%
String base = (String) application.getAttribute("base");
String origen = (String) request.getParameter("origen");
String destino = request.getParameter("destino");
String fechaSalida = (String) request.getParameter("fechaSalida");
String num = (String) request.getParameter("numPersonas");
String orden = (String) request.getParameter("orden");
if(!origen.equals("") && !destino.equals("") && !fechaSalida.equals("") && !num.equals("")) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultado de consulta de vuelos</title>
</head>
<body>
<h1>Resultado de consulta de vuelos</h1>
<h2>Ida</h2>
<table border="1">
<tr><th>Precio del vuelo</th><th>Compañía aérea</th><th>Hora salida</th><th>Hora llegada</th></tr>
<%
ArrayList<Vuelos> vuelosIda = dataManager.busquedaVuelos(dataManager, origen, destino, fechaSalida, num, orden);
Iterator<Vuelos> itIda = vuelosIda.iterator();
while(itIda.hasNext()) {
Vuelos v = itIda.next();
%>
 <tr>
 <td><%=v.getPrecio()%></td>
 <td><%=v.getCodAero()%></td>
 <td><%=v.getHoraSalida()%></td>
 <td><%=v.getHoraLlegada()%></td>
 </tr>
 <%
 	}
 %>
</table>
<h2>Vuelta</h2>
<table border="1">
<tr><th>Precio del vuelo</th><th>Compañía aérea</th><th>Hora salida</th><th>Hora llegada</th></tr>
<%
	String fechaLlegada = (String) request.getParameter("fechaLlegada");
ArrayList<Vuelos> vuelosVuelta = dataManager.busquedaVuelos(dataManager, destino, origen, fechaLlegada, num, orden);
Iterator<Vuelos> itVuelta = vuelosVuelta.iterator();
while(itVuelta.hasNext()) {
Vuelos v = itVuelta.next();
%>
 <tr>
 <td><%=v.getPrecio() %></td>
 <td><%=v.getCodAero() %></td>
 <td><%=v.getHoraSalida() %></td>
 <td><%=v.getHoraLlegada() %></td>
 </tr>
 <%
 }
  %>
</table>
<p><a href="<%=base %>?action=buscar&origen=<%=origen %>&destino=<%=destino %>&fechaSalida=<%=fechaSalida %>&fechaLlegada=<%=fechaLlegada %>&numPersonas=<%=num %>&orden=HORA_LLEGADA-HORA_SALIDA ASC">Ordenar por duración</a></p>
<p><a href="<%=base %>?action=buscar&origen=<%=origen %>&destino=<%=destino %>&fechaSalida=<%=fechaSalida %>&fechaLlegada=<%=fechaLlegada %>&numPersonas=<%=num %>&orden=HORA_SALIDA">Ordenar por hora salida</a></p>
</body>
</html>
<%
 } else {
%>
<html>
<title>Error al introducir datos</title>
<body><h1>Error al introducir datos</h1></body>
<p>Se le ha olvidado introducir algún dato</p>
</html>
<%
}
 %>
