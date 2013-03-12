package agenciaLRM;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenciaLRM.model.DataManager;

/**
 * Servlet implementation class ServletAgencia
 */
/**
 * Servlet implementation class ShopServlet
 */
@WebServlet(
		urlPatterns = { "/agenciaLRM/*" }, 
		initParams = { 
				@WebInitParam(name = "base", value = "/Agencia_Vuelos_-_LRM/agenciaLRM"), 
				@WebInitParam(name = "imageURL", value = "/Agencia_Vuelos_-_LRM/src/img/"), 
				@WebInitParam(name = "jdbcDriver", value = "oracle.jdbc.driver.OracleDriver"), 
				@WebInitParam(name = "dbURL", value = "jdbc:oracle:thin:@localhost:1521:datoslrm"),
				@WebInitParam(name = "dbUserName", value = "scott"),
				@WebInitParam(name = "dbPassword", value = "tiger")
		})
public class ServletAgencia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAgencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("*** initializing controller servlet.");
		super.init(config);

		DataManager dataManager = new DataManager();
		dataManager.setDbURL(config.getInitParameter("dbURL"));
		dataManager.setDbUsuario(config.getInitParameter("dbUserName"));
		dataManager.setDbPassword(config.getInitParameter("dbPassword"));


		ServletContext context = config.getServletContext();
		context.setAttribute("base", config.getInitParameter("base"));
		context.setAttribute("imageURL", config.getInitParameter("imageURL"));
		context.setAttribute("dataManager", dataManager);

		try {  // load the database JDBC driver

			Class.forName(config.getInitParameter("jdbcDriver"));
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "index.jsp";
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("buscar"))
				url = base + "ResultadoBusqueda.jsp";
		}
		RequestDispatcher requestDispatcher =
				getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
}
