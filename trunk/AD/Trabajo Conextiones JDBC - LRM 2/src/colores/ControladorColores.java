package colores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

public class ControladorColores implements ActionListener {
	
	private VistaColores vc;
	private static String usuario = "";
	private static String password = "";
	private static DataManager dataManager = new DataManager();
	private static final String url = "jdbc:oracle:thin:@localhost:1521:datoslrm";
	
	public ControladorColores(VistaColores vc) {
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaColores.CONEXION)) {
			usuario = vc.getUsuario();
			password = vc.getPassword();
			dataManager.setDbUsuario(usuario);
			dataManager.setDbPassword(password);
			dataManager.setDbURL(url);
			Connection conn = dataManager.getConnection();
			String[] listaColores = new String[5];
			try {
				Statement stmt = conn.createStatement();
				try {
					ResultSet rs = stmt.executeQuery("SELECT * FROM COLORES");
					int i = 0;
					while(rs.next()) {
						listaColores[i] = rs.getString(1);
						i++;
					}
					vc.setListaColores(listaColores);
					vc.setConexion("Conexión realizada con éxito");
					vc.deshabilitarComponentes(true);
					rs.close();
				} catch (SQLException e) {
					vc.setConexion("Fallo en la conexión");
				} finally {
					stmt.close();
				}
			} catch (SQLException e) {
				vc.setConexion("Fallo en la conexión");
			} catch (NullPointerException e) {
				vc.setConexion("El usuario/contraseña introducidos son incorrectos");
			} finally {
				dataManager.putConnection(conn, vc);
			}
		}
		if(ae.getActionCommand().equals(VistaColores.MOSTRAR)) {
			Connection conn = dataManager.getConnection();
			try {
				ImageIcon imagen = new ImageIcon(getBLOB(vc.getComboBox(), conn));
				vc.setColor(imagen);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dataManager.putConnection(conn, vc);
			}
		}
	}
	
	public static byte[] getBLOB(String color, Connection conn)
			throws Exception {
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM COLORES WHERE COLOR LIKE '"+color+"'");
				rs.next();
				Blob blob = rs.getBlob(2);
				return blob.getBytes(1, (int)blob.length());
			} finally {
				stmt.close();
			}
		} finally {
			conn.close();
		}
	}

}
