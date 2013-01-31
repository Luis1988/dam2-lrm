import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcherImage")

public class Request_image extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<p>Inicio del dispatcher</p>");
		out.println("<img border='2' src= 'prueba.png' height=100 width=100/>");
		out.println("<p>Fin de dispatcher. Esta imagen ha sido mostrada por el dispatcher</p>");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		doGet(request,response);
	}

}
