package prueba;

import java.awt.Insets;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;

import java.awt.Toolkit;

/**
 * Clase que inicia el programa del editor de texto y que nos permitir�
 * realizar acciones varias dentro de este. Como es el de: leer, guardar,
 * editar texto, etc
 * @author Luis Romero Moreno
 * @version v1.9
 *
 */
public class PanelEditor extends JFrame implements VistaEditor {

	/**
	 * Atributo privado con el identificador del JFrame
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo privado con los elementos de la barra de men�
	 */
	private JMenuBar menuBar;
	/**
	 * Atributo privado con los elementos de la barra de herramientas
	 */
	private JToolBar toolBar;
	/**
	 * �rea de texto donde podremos editar los ficheros
	 */
	private JTextArea areaTexto;
	/**
	 * Barra de desplazamiento que contendr� al �rea de texto
	 */
	private JScrollPane panelDesplazamiento;
	/**
	 * Elementos principales de la barra de men�
	 */
	private JMenu jmArchivo, jmEdicion, jmOpciones, jmFuente, jmTama�o, jmAyuda;
	/**
	 * Elementos de los men�s de edici�n y archivo
	 */
	private JMenuItem jmItemSalir, jmItemCortar, jmItemCopiar, jmItemPegar;
	/**
	 * Elementos de los men�s de edici�n y archivo
	 */
	private JMenuItem jmItemAbrir, jmItemGuardar, jmItemCopiar2, jmItemPegar2;
	/**
	 * Elementos de los men�s de edici�n
	 */
	private JMenuItem jmItemCortar2, jmItemAcercaDe, jmItemUndo, jmItemRedo;
	/**
	 * Elementos de los men�s edici�n
	 */
	private JMenuItem jmItemUndo2, jmItemRedo2;
	/**
	 * Elementos de los men�s de opciones
	 */
	private JCheckBoxMenuItem jmItemCourierNew, jmItemArial, jmItemFPredeterminada;
	/**
	 * Elementos de los men�s de opciones
	 */
	private JCheckBoxMenuItem jmItem16, jmItem24, jmItemTPredeterminado;
	/**
	 * Botones principales de la aplicaci�n para cortar, copiar y pegar
	 */
	private JButton jbtCortar, jbtCopiar, jbtPegar, jbtUndo, jbtRedo;
	/**
	 * Men� contextual de la aplicaci�n
	 */
	private JPopupMenu menuPop;
	/**
	 * Controlador del deshacer y el rehacer
	 */
	private UndoManager manager; 

	/**
	 * Constructor principal de la clase que inciar� la aplicaci�n
	 */
	public PanelEditor(){
		getContentPane().setLayout(null);
		menuBar = new JMenuBar();
		toolBar = new JToolBar();
		areaTexto = new JTextArea("");
		menuPop = new JPopupMenu();
		JSeparator separador = new JSeparator();
		JSeparator separador2 = new JSeparator();
		JSeparator separador3 = new JSeparator();
		panelDesplazamiento = 
				new JScrollPane(areaTexto, 
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		jmArchivo = new JMenu("Archivo");
		jmArchivo.setMnemonic('A');
		jmItemAbrir = new JMenuItem("Abrir", new Integer('A'));
		jmItemAbrir.setIcon(new ImageIcon(getClass().getResource("/img/abrir.png")));
		jmArchivo.add(jmItemAbrir);
		jmItemGuardar = new JMenuItem("Guardar", new Integer('G'));
		jmItemGuardar.setIcon(new ImageIcon(getClass().getResource("/img/guardar.gif")));
		jmArchivo.add(jmItemGuardar);
		jmArchivo.add(separador3);
		jmItemSalir = new JMenuItem("Salir", new Integer('S'));
		jmArchivo.add(jmItemSalir);
		jmEdicion = new JMenu("Edici�n");
		jmEdicion.setMnemonic('E');
		jmItemUndo = new JMenuItem("Deshacer", new Integer('D'));
		jmItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		jmItemUndo.setIcon(new ImageIcon(getClass().getResource("/img/deshacer.png")));
		jmEdicion.add(jmItemUndo);
		jmItemRedo = new JMenuItem("Rehacer", new Integer('R'));
		jmItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		jmItemRedo.setIcon(new ImageIcon(getClass().getResource("/img/rehacer.png")));
		jmEdicion.add(jmItemRedo);
		jmEdicion.add(separador);
		jmItemCortar = new JMenuItem("Cortar", new Integer('T'));
		jmItemCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		jmItemCortar.setIcon(new ImageIcon(getClass().getResource("/img/cortar.gif")));
		jmEdicion.add(jmItemCortar);
		jmItemCopiar = new JMenuItem("Copiar", new Integer('C'));
		jmItemCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		jmItemCopiar.setIcon(new ImageIcon(getClass().getResource("/img/copiar.gif")));
		jmEdicion.add(jmItemCopiar);
		jmItemPegar = new JMenuItem("Pegar", new Integer('P'));
		jmItemPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		jmItemPegar.setIcon(new ImageIcon(getClass().getResource("/img/pegar.gif")));
		jmEdicion.add(jmItemPegar);
		jmItemUndo2 = new JMenuItem("Deshacer", new Integer('D'));
		jmItemUndo2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		menuPop.add(jmItemUndo2);
		jmItemRedo2 = new JMenuItem("Reshacer", new Integer('R'));
		jmItemRedo2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		menuPop.add(jmItemRedo2);
		menuPop.add(separador2);
		jmItemCortar2 = new JMenuItem("Cortar", new Integer('T'));
		jmItemCortar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		menuPop.add(jmItemCortar2);
		jmItemCopiar2 = new JMenuItem("Copiar", new Integer('C'));
		jmItemCopiar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuPop.add(jmItemCopiar2);
		jmItemPegar2 = new JMenuItem("Pegar", new Integer('P'));
		jmItemPegar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		menuPop.add(jmItemPegar2);
		jmOpciones = new JMenu("Opciones");
		jmOpciones.setMnemonic('O');
		jmFuente = new JMenu("Fuente");
		jmFuente.setMnemonic('F');
		jmItemCourierNew = new JCheckBoxMenuItem("Courier New");
		jmFuente.add(jmItemCourierNew);
		jmItemArial = new JCheckBoxMenuItem("Arial");
		jmFuente.add(jmItemArial);
		jmItemFPredeterminada = new JCheckBoxMenuItem("Predeterminada");
		jmItemFPredeterminada.setSelected(true);
		jmFuente.add(jmItemFPredeterminada);
		jmOpciones.add(jmFuente);
		jmTama�o = new JMenu("Tama�o");
		jmTama�o.setMnemonic('T');
		jmItem16 = new JCheckBoxMenuItem("16");
		jmTama�o.add(jmItem16);
		jmItem24 = new JCheckBoxMenuItem("24");
		jmTama�o.add(jmItem24);
		jmItemTPredeterminado = new JCheckBoxMenuItem("Predeterminado");
		jmItemTPredeterminado.setSelected(true);
		jmTama�o.add(jmItemTPredeterminado);
		jmOpciones.add(jmTama�o);
		jmAyuda = new JMenu("Ayuda");
		jmAyuda.setMnemonic('u');
		jmItemAcercaDe = new JMenuItem("Acerca del Editor de Texto", new Integer('d'));
		jmAyuda.add(jmItemAcercaDe);
		menuBar.add(jmArchivo);
		menuBar.add(jmEdicion);
		menuBar.add(jmOpciones);
		menuBar.add(jmAyuda);

		jbtUndo = new JButton();
		jbtUndo.setIcon(new ImageIcon(getClass().getResource("/img/deshacer.png")));
		jbtUndo.setToolTipText("Deshacer");
		jbtUndo.setFocusPainted(false);
		jbtUndo.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(jbtUndo);
		jbtRedo = new JButton();
		jbtRedo.setIcon(new ImageIcon(getClass().getResource("/img/rehacer.png")));
		jbtRedo.setToolTipText("Rehacer");
		jbtRedo.setFocusPainted(false);
		jbtRedo.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(jbtRedo);
		toolBar.addSeparator();
		jbtCortar = new JButton();
		jbtCortar.setIcon(new ImageIcon(getClass().getResource("/img/cortar.gif")));
		jbtCortar.setToolTipText("Cortar");
		jbtCortar.setFocusPainted(false);
		jbtCortar.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(jbtCortar);
		jbtCopiar = new JButton();
		jbtCopiar.setIcon(new ImageIcon(getClass().getResource("/img/copiar.gif")));
		jbtCopiar.setToolTipText("Copiar");
		jbtCopiar.setFocusPainted(false);
		jbtCopiar.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(jbtCopiar);
		jbtPegar = new JButton();
		jbtPegar.setIcon(new ImageIcon(getClass().getResource("/img/pegar.gif")));
		jbtPegar.setToolTipText("Pegar");
		jbtPegar.setFocusPainted(false);
		jbtPegar.setMargin(new Insets(0, 0, 0, 0));
		toolBar.add(jbtPegar);
		toolBar.setFloatable(false);

		toolBar.setBounds(0, 0, 494, 36);
		panelDesplazamiento.setBounds(0, 37, 495, 313);

		jmItemAbrir.setActionCommand(VistaEditor.ABRIR);
		jmItemGuardar.setActionCommand(VistaEditor.GUARDAR);
		jmItemSalir.setActionCommand(VistaEditor.SALIR);
		jmItemCortar.setActionCommand(VistaEditor.CORTAR);
		jmItemCopiar.setActionCommand(VistaEditor.COPIAR);
		jmItemPegar.setActionCommand(VistaEditor.PEGAR);
		jmItemCortar2.setActionCommand(VistaEditor.CORTAR);
		jmItemCopiar2.setActionCommand(VistaEditor.COPIAR);
		jmItemPegar2.setActionCommand(VistaEditor.PEGAR);
		jmItemCourierNew.setActionCommand(VistaEditor.F_COURIER);
		jmItemArial.setActionCommand(VistaEditor.F_ARIAL);
		jmItemFPredeterminada.setActionCommand(VistaEditor.F_PREDETERMINADA);
		jmItem16.setActionCommand(VistaEditor.T_16);
		jmItem24.setActionCommand(VistaEditor.T_24);
		jmItemTPredeterminado.setActionCommand(T_PREDETERMINADA);
		jbtCopiar.setActionCommand(VistaEditor.COPIAR);
		jbtCortar.setActionCommand(VistaEditor.CORTAR);
		jbtPegar.setActionCommand(VistaEditor.PEGAR);
		jmItemAcercaDe.setActionCommand(VistaEditor.ACERCA_DE);
		jmItemUndo.setActionCommand(VistaEditor.UNDO);
		jmItemRedo.setActionCommand(VistaEditor.REDO);
		jmItemUndo2.setActionCommand(VistaEditor.UNDO);
		jmItemRedo2.setActionCommand(VistaEditor.REDO);
		jbtUndo.setActionCommand(VistaEditor.UNDO);
		jbtRedo.setActionCommand(VistaEditor.REDO);
		habilitarItemEdicion(false);

		controladorEdicion(this);
		controladorOpciones(this);
		
		manager = new UndoManager();
		areaTexto.getDocument().addUndoableEditListener(manager);
		
		this.addComponentListener(new ControladorVentana(this));
		this.addWindowStateListener(new ControladorVentana(this));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(PanelEditor.class.getResource("/img/ic_bloc.png")));
		this.setTitle("Editor de Texto - Untitled");
		getContentPane().add(toolBar);
		this.setJMenuBar(menuBar);
		getContentPane().add(panelDesplazamiento);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 500, 400);
		this.setVisible(true);
	}

	public JMenuItem getJmItemCopiar2() {
		return jmItemCopiar2;
	}

	public JMenuItem getJmItemPegar2() {
		return jmItemPegar2;
	}

	public JMenuItem getJmItemCortar2() {
		return jmItemCortar2;
	}

	public JMenuItem getJmItemCortar() {
		return jmItemCortar;
	}

	public JMenuItem getJmItemCopiar() {
		return jmItemCopiar;
	}

	public JMenuItem getJmItemPegar() {
		return jmItemPegar;
	}

	public JButton getJbtCortar() {
		return jbtCortar;
	}

	public JButton getJbtCopiar() {
		return jbtCopiar;
	}

	public JButton getJbtPegar() {
		return jbtPegar;
	}

	/**
	 * M�todo que a�ade todos los botones de edici�n al 
	 * ControladorEdicion
	 * @param ve VistaEditor que recibe para envi�rselo al controlador
	 */
	public void controladorEdicion(VistaEditor ve){
		jmItemSalir.addActionListener(new ControladorEdicion(ve));
		jmItemCortar.addActionListener(new ControladorEdicion(ve));
		jmItemCopiar.addActionListener(new ControladorEdicion(ve));
		jmItemPegar.addActionListener(new ControladorEdicion(ve));
		jmItemCortar2.addActionListener(new ControladorEdicion(ve));
		jmItemCopiar2.addActionListener(new ControladorEdicion(ve));
		jmItemPegar2.addActionListener(new ControladorEdicion(ve));
		jbtCopiar.addActionListener(new ControladorEdicion(ve));
		jbtCortar.addActionListener(new ControladorEdicion(ve));
		jbtPegar.addActionListener(new ControladorEdicion(ve));
		areaTexto.addMouseListener(new ControladorEdicion(ve));
		jmItemSalir.addActionListener(new ControladorEdicion(ve));
		jmItemGuardar.addActionListener(new ControladorEdicion(ve));
		jmItemAbrir.addActionListener(new ControladorEdicion(ve));
		jmItemAcercaDe.addActionListener(new ControladorEdicion(ve));
		jmItemUndo.addActionListener(new ControladorEdicion(ve));
		jmItemRedo.addActionListener(new ControladorEdicion(ve));
		jmItemUndo2.addActionListener(new ControladorEdicion(ve));
		jmItemRedo2.addActionListener(new ControladorEdicion(ve));
		jbtUndo.addActionListener(new ControladorEdicion(ve));
		jbtRedo.addActionListener(new ControladorEdicion(ve));
	}

	/**
	 * M�todo que a�ade los botones de opciones al ControladorOpciones
	 * @param ve VistaEditor que recibe para envi�rselo al controlador
	 */
	public void controladorOpciones(VistaEditor ve){
		jmItemCourierNew.addActionListener(new ControladorOpciones(ve));
		jmItemArial.addActionListener(new ControladorOpciones(ve));
		jmItemFPredeterminada.addActionListener(new ControladorOpciones(ve));
		jmItem16.addActionListener(new ControladorOpciones(ve));
		jmItem24.addActionListener(new ControladorOpciones(ve));
		jmItemTPredeterminado.addActionListener(new ControladorOpciones(ve));
	}

	public JCheckBoxMenuItem getJmItemTPredeterminado() {
		return jmItemTPredeterminado;
	}

	public JCheckBoxMenuItem getJmItemCourierNew() {
		return jmItemCourierNew;
	}

	public JCheckBoxMenuItem getJmItemArial() {
		return jmItemArial;
	}

	public JCheckBoxMenuItem getJmItemFPredeterminada() {
		return jmItemFPredeterminada;
	}

	public JCheckBoxMenuItem getJmItem16() {
		return jmItem16;
	}

	public JCheckBoxMenuItem getJmItem24() {
		return jmItem24;
	}

	@Override
	public void habilitarItemEdicion(boolean flag) {
		jmItemCopiar.setEnabled(flag);
		jmItemCortar.setEnabled(flag);
		jmItemCopiar2.setEnabled(flag);
		jmItemCortar2.setEnabled(flag);
		jbtCortar.setEnabled(flag);
		jbtCopiar.setEnabled(flag);
	}

	@Override
	public JTextArea getAreaTexto() {
		return areaTexto;
	}

	@Override
	public int getAlturaVentana() {
		return this.getHeight();
	}

	@Override
	public int getAnchuraVentana() {
		return this.getWidth();
	}

	@Override
	public void setTama�oComponentes(int ancho, int altura) {
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.equals("windows 7") || OS.equals("windows vista")){
			toolBar.setSize(ancho-16, toolBar.getHeight());
			panelDesplazamiento.setSize(ancho-14, altura-96);
		}
		else if(OS.equals("windows xp")){
			toolBar.setSize(ancho-6, toolBar.getHeight());
			panelDesplazamiento.setSize(ancho-7, altura-93);
		}
		else {
			toolBar.setSize(ancho-6, toolBar.getHeight());
			panelDesplazamiento.setSize(ancho-7, altura-93);
		}
	}
	
	public JPopupMenu getMenuPop() {
		return menuPop;
	}

	@Override
	public JFrame getFrame() {
		return this;
	}

	@Override
	public void setTitulo(String titulo) {
		this.setTitle(VistaEditor.TITULO+titulo);
	}

	@Override
	public UndoManager getManager() {
		return manager;
	}

}
