package prueba;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

/**
 * Vista del PanelEditor que contiene todos los observadores y 
 * editores de los atributos
 * @author Luis Romero Moreno
 * @version v1.9
 *
 */
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
	public static final String GUARDAR = "GUARDAR";
	public static final String ABRIR = "ABRIR";
	public static final String ACERCA_DE = "ACERCA DE";
	public static final String UNDO = "UNDO";
	public static final String REDO = "REDO";
	
	public static final String TITULO = "Editor de Texto - ";
	
	/**
	 * Método que cambia la habilitación de los botones Cortar y Copiar
	 * @param flag boolean que maneja la habilitación/deshabilitación de 
	 * Cortar y Copiar
	 */
	public void habilitarItemEdicion(boolean flag);
	/**
	 * Área de texto del editor
	 * @return {@link JTextArea} con el texto del editor
	 */
	public JTextArea getAreaTexto();
	/**
	 * Con el valor de la altura de la ventana
	 * @return int con la altura de la ventana
	 */
	public int getAlturaVentana();
	/**
	 * Con el valor de la anchura de la ventana
	 * @return int con la anchura de la ventana
	 */
	public int getAnchuraVentana();
	/**
	 * Redimensiona la ventana según los valores establecidos para 
	 * cada Sistema Operativo
	 * @param ancho int con la anchura de ventana
	 * @param altura int con la altura de la ventana
	 */
	public void setTamañoComponentes(int ancho, int altura);
	/**
	 * Fuente predeterminada
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItemTPredeterminado();
	/**
	 * Tamaño predeterminado
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItemCourierNew();
	/**
	 * Fuente Arial
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItemArial();
	/**
	 * Fuente predeterminada
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItemFPredeterminada();
	/**
	 * Tamaño 16
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItem16();
	/**
	 * Tamaño 14
	 * @return {@link JCheckBoxMenuItem} que indica si está seleccionado o no
	 */
	public JCheckBoxMenuItem getJmItem24();
	/**
	 * Menú contextual
	 * @return {@link JPopupMenu} con el menú contextual
	 */
	public JPopupMenu getMenuPop();
	/**
	 * Botón copiar
	 * @return {@link JMenuItem} con el item Copiar
	 */
	public JMenuItem getJmItemCopiar2();
	/**
	 * Botón pegar
	 * @return {@link JMenuItem} con el item Pegar
	 */
	public JMenuItem getJmItemPegar2();
	/**
	 * Botón cortar
	 * @return {@link JMenuItem} con el item Cortar
	 */
	public JMenuItem getJmItemCortar2();
	/**
	 * Ventana de la aplicación
	 * @return {@link JFrame} con la ventana de la aplicación
	 */
	public JFrame getFrame();
	
	/**
	 * Modifica el título manteniendo siempre una constante
	 * @param titulo con lo que se modificará del título
	 */
	public void setTitulo(String titulo);
	
	/**
	 * Controla los rehacer y deshacer
	 * @return UndoManager con el Undo y el Redo
	 */
	public UndoManager getManager();

}
