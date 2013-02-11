package ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorTabla implements ActionListener {

	private VistaTablaRS vtrs;
	private Statement stmt;

	public ControladorTabla(VistaTablaRS vtrs, Statement stmt) {
		this.stmt = stmt;
		this.vtrs = vtrs;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaTablaRS.SELECT)){
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM "+vtrs.getTabla());
				ResultSetMetaData rsmd = rs.getMetaData();
				int nCol = rsmd.getColumnCount();
				String res = "";
				for(int i = 1; i <= nCol; i++){
					String nomCol = rsmd.getColumnName(i);
					int espacios = calculaEspacios(nomCol);
					for(int j = 0; j < espacios; j++){
						nomCol+=" ";
					}
					res+=nomCol;
				}
				int nGuiones = res.length();
				res+="\n";
				for(int i = 0; i < nGuiones; i++){
					res+="_";
				}
				res+="\n";
				rs.beforeFirst();
				while(rs.next()){
					for(int i = 1; i <= nCol; i++){
						String fila = "";
						try{
							fila = rs.getObject(i).toString();
						} catch (NullPointerException npe) {}
						int espacios = calculaEspacios(fila);
						for(int j = 0; j < espacios; j++){
							fila+=" ";
						}
						res+=fila;
					}
					res+="\n";
				}
				vtrs.escribeTabla(res);
				Metadatos m = new Metadatos();
				m.setBounds(300, 300, 300, 224);
				m.metadatos(getMetadatos(rsmd));
				m.setVisible(true);
			} catch (SQLException e) {
				vtrs.muestraError(e);
			}
		}
	}
	
	private String getMetadatos(ResultSetMetaData rsmd) {
		String res = "";
		try {
			res = "Table:\n\nColumns:\n";
			int numCol = rsmd.getColumnCount();
			for(int i = 1; i <= numCol; i++){
				res+=rsmd.getColumnName(i)+" is a Type "+rsmd.getColumnType(i)+"\n";
			}
		} catch (SQLException e) {
			vtrs.muestraError(e);
		}
		return res;
	}

	public int calculaEspacios(String s) {
		int res = 30 - s.length();
		return res;
	}

}
