<%@page language="java" contentType="text/html"%>
<%
  String base = (String)application.getAttribute("base");
  String imageURL = (String)application.getAttribute("imageURL");
  %>
<div class="header">
  <div class="logo">
    <p>Central de compras on-line</p>
    </div>
  <div class="cart">
    <a class="link2" href="<%=base%>?action=mostrarCarrito">Mostrar Carrito
      <img src="<%=imageURL%>cart.gif" border="0"/></a>
    </div>
  </div>