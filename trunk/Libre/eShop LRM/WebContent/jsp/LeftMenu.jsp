<%@page language="java" contentType="text/html"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<% String base = (String)application.getAttribute("base"); %>
<jsp:useBean id="dataManager" scope="application"
  class="eShop.model.DataManager"/>
<div class="menu">
  <div class="box">
    <div class="title">Búsqueda rápida</div>
    <p>Libro Título/Autor:</p>
    <form style="border: 0px solid; padding: 0; margin: 0;">
      <input type="hidden" name="action" value="buscar"/>
      <input id="text" type="text" name="cadena" size="15"/>
      <input id="submit" type="submit" value="Buscar"/>
      </form>
    </div>
  <div class="box">
    <div class="title">Categorías</div>
<%
	Hashtable categorias = dataManager.getCategorias();
    Enumeration idsCategorias = categorias.keys();
    while (idsCategorias.hasMoreElements()) {
      Object idCategoria = idsCategorias.nextElement();
      out.println("<p><a href=" + base + "?action=seleccionarCatalogo&id="
        + idCategoria.toString() + ">" + categorias.get(idCategoria) + "</a></p>"
        );
      }
%>
    </div>
  </div>
