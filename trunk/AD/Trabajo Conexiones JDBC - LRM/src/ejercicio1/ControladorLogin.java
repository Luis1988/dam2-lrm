package ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorLogin implements ActionListener{
	
	private VistaLogin vl;
	
	public ControladorLogin(VistaLogin vl) {
		this.vl = vl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(VistaLogin.ACEPTAR))	{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				vl.muestraError(e1);
			}
			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:datoslrm", vl.getUsuario(), vl.getPass());
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				vl.mostrarLogin(false);
				TablaRS t = new TablaRS(stmt);
				t.setBounds(100, 100, 410, 288);
				t.setVisible(true);
			} catch (SQLException e1) {
				vl.muestraError(e1);
			}
		}
		if(e.getActionCommand().equals(VistaLogin.CANCELAR)){
			System.exit(0);
		}
	}	

}
