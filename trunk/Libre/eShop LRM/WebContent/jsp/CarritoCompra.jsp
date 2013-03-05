<%@page language="java" contentType="text/html"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="eShop.beans.Libro"%>
<%@page import="eShop.beans.Carrito"%>
<jsp:useBean id="dataManager" scope="application"
  class="eShop.model.DataManager"/>
<%
	String base = (String) application.getAttribute("base");
  Hashtable<String, Carrito> carritoCompra =
    (Hashtable)session.getAttribute("carritoCompra");
  if (carritoCompra == null) {
    carritoCompra = new Hashtable<String, Carrito>(10);
    }
  String action = request.getParameter("action");
  if (action != null && action.equals("addProducto")) {
    try {
      String idLibro = request.getParameter("idLibro");
      Libro libro = dataManager.getDetallesLibro(idLibro);
      if (libro != null) {
        Carrito item = new Carrito(libro, 1);
        carritoCompra.remove(idLibro);
        carritoCompra.put(idLibro, item);
        session.setAttribute("carritoCompra", carritoCompra);
        }
      }
    catch (Exception e) {
      out.println("Error al añadir el libro seleccionado al carrito de la compra!");
      }
    }
  if (action != null && action.equals("actualizarProducto")) {
    try {
      String idLibro = request.getParameter("idLibro");
      String cantidad = request.getParameter("cantidad");
      Carrito item = (Carrito)carritoCompra.get(idLibro);
      if (item != null) {
        item.setCantidad(cantidad);
        }
      }
    catch (Exception e) {
      out.println("Error actualizando el carrito de la compra!");
      }
    }
  if (action != null && action.equals("borrarProducto")) {
    try {
      String idLibro = request.getParameter("idLibro");
      carritoCompra.remove(idLibro);
      }
    catch (Exception e) {
      out.println("Error borrando el producto seleccionado del carrito de la compra!");
      }
    }
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Carrito de la Compra</title>
  <link rel="stylesheet" href="/eShop_LRM/src/css/graficos.css" type="text/css"/>
  </head>
<body>
<jsp:include page="TopMenu.jsp" flush="true"/>
<jsp:include page="LeftMenu.jsp" flush="true"/>
<%
	if (!carritoCompra.isEmpty()) {
%>
    <div class="content">
      <h2>Carrito de la Compra</h2>
      <table>
        <tr>
          <th>Título</th>
          <th>Autor</th>
          <th>Precio</th>
          <th>Cantidad</th>
          <th>Subtotal</th>
          <th>Borrar</th>
          </tr>
<%
	Enumeration enumList = carritoCompra.elements();
        double precioItem = 0;
        double precioTotal = 0;
        while (enumList.hasMoreElements()) {
          Carrito item = (Carrito)enumList.nextElement();
          precioItem = Math.round(
        		    Integer.parseInt(item.getCantidad())
        		    * item.getPrecio() * 100.) / 100.
                    ;
          precioTotal += precioItem;
%>
          <tr>
            <td><%=item.getTitulo()%></td>
            <td><%=item.getAutor()%></td>
            <td><%=item.getPrecio()%></td>
            <td><form>
              <input type="hidden" name="action" value="actualizarProducto"/>
              <input type="hidden" name="idLibro"
                value="<%=item.getIdLibro()%>"/>
              <input type="text" size="2" name="cantidad" 
                value="<%=item.getCantidad()%>"/>
              <input type="submit" value="Actualizar"/>
              </form></td>
            <td>
              <%=precioItem%>
                </td>
            <td><form>
              <input type="hidden" name="action" value="borrarProducto"/>
              <input type="hidden" name="idLibro" 
                value="<%=item.getIdLibro()%>"/>
              <input type="submit" value="Borrar"/>
              </form></td>
            </tr>
<%
          }
  %>
        <tr>
          <td colspan="5" id="total">Total: <%=precioTotal%></td>
          <td class="total">&nbsp;</td>
          </tr>
        <tr>
          <td colspan="6" class="center"><a class="link1"
            href="<%=base%>?action=comprar">Comprar</a></td>
          </tr>
        </table>
      </div>
<%
    }
  else {
    %><p class="info">El Carrito de la Compra está vacío.</p><%
    }
  %>
</body>
</html>
