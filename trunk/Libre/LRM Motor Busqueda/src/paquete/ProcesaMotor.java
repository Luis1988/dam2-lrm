package paquete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesaMotor
 */

@WebServlet("/procesaMotor")

public class ProcesaMotor extends HttpServlet {
	
	public ProcesaMotor(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cadena = request.getParameter("cadena");
		if(request.getParameter("buscador").equals("Google")){
			response.sendRedirect("http://google.es/search?q="+cadena);
		}
		if(request.getParameter("buscador").equals("Yahoo")){
			response.sendRedirect("http://es.search.yahoo.com/search?p="+cadena);
		}
		if(request.getParameter("buscador").equals("Bing")){
			response.sendRedirect("http://www.bing.com/search?q="+cadena);
		}
		if(request.getParameter("buscador").equals("Ask")){
			response.sendRedirect("http://es.ask.com/web?q="+cadena);
		}
		if(request.getParameter("buscador").equals("AllTheWeb")){
			response.sendRedirect("http://www.alltheweb.com/search?q="+cadena);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
		
	}
	
	public static void main(String[] args){
		
	}

}
