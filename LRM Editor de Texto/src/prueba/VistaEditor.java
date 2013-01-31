package prueba;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public interface VistaEditor {
	
	public static final String SALIR = "SALIR";
	public static final String CORTAR = "CORTAR";
	public static final String COPIAR = "COPIAR";
	public static final String PEGAR = "PEGAR";
	public static final String F_COURIER = "F_COURIER";
	public static final String F_ARIAL = "F_ARIAL";
	public static final String F_PREDETERMINADA = "F_PREDETERMINADA";
	public static final String T_16 = "16";
	public static final String T_24 = "24";
	public static final String T_PREDETERMINADA = "T_PREDETERMINADA";
	
	public void habilitarItemEdicion(boolean flag);
	public JTextArea getAreaTexto();
	public int getAlturaVentana();
	public int getAnchuraVentana();
	public void setTamañoComponentes(int ancho, int altura);
	public JCheckBoxMenuItem getJmItemTPredeterminado();
	public JCheckBoxMenuItem getJmItemCourierNew();
	public JCheckBoxMenuItem getJmItemArial();
	public JCheckBoxMenuItem getJmItemFPredeterminada();
	public JCheckBoxMenuItem getJmItem16();
	public JCheckBoxMenuItem getJmItem24();
	public JPopupMenu getMenuPop();
	public JMenuItem getJmItemCopiar2();
	public JMenuItem getJmItemPegar2();
	public JMenuItem getJmItemCortar2();

}
