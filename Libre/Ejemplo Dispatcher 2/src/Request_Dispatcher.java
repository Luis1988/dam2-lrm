import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcherApp")

public class Request_Dispatcher extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ServletContext sc;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		
		response.setContentType("text/html");
		sc = getServletContext();
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Ejemplo de RequestDispatcher</title></head>");
		out.println("<body><p><b>Ejemplo de RequestDispatcher</b></p><hr>");
		out.println("<p>Este servlet (el primero) usara un RequestDispatcher (otro servlet)</p>");
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/request_image");
		if(dispatcher != null){
			if(request.getParameter("metodo").equals("include"))
				dispatcher.include(request, response);
			else
				dispatcher.forward(request, response);
		}
		else
			out.println("<p>No se ha encontrado RequestDispatcher.</p>");
		out.println("<p>Final del primer servlet.</p>");
		out.print("</body></html>");

	}
	
	public void init(ServletConfig config) throws ServletException {
		sc=config.getServletContext(); //Obtengo el contexto del servlet.
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		doGet(request,response);
	}

}
