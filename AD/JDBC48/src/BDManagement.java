import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BDManagement {
	private final static String drv = "oracle.jdbc.driver.OracleDriver";
	private final static String db = "jdbc:oracle:thin:@localhost:1521:datoslrm";
	private final static String userAndPass = "personas";
	private Connection ct;
	private Statement st;

	public BDManagement () {
		try {
			Class.forName(drv);
			ct=DriverManager.getConnection(db,userAndPass,userAndPass);
			st=ct.createStatement();
			
			System.out.print("Conexión exitosa\n");
		} catch(Exception e) {
			System.out.print("No se pudo conectar a la BD\n");
		}
	}
	
/*	public void showAll() {
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM PERSONAS");
			while (rs.next()){
				System.out.println(rs.getString(1)+"|"+ rs.getString(2)+"|"+rs.getString(3));
			}
		} catch(Exception e) {
			System.out.println("Error al realizar la consulta");
		}
	}
	*/
	public Statement getSt() {
		return st;
	}
}

