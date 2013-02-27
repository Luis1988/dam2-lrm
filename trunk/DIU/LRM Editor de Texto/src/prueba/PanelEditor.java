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
import java.awt.Toolkit;

public class PanelEditor extends JFrame implements VistaEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JToolBar toolBar;
	private JTextArea areaTexto;
	private JScrollPane panelDesplazamiento;
	private JMenu jmArchivo, jmEdicion, jmOpciones, jmFuente, jmTamaño, jmAyuda;
	private JMenuItem jmItemSalir, jmItemCortar, jmItemCopiar, jmItemPegar;
	private JMenuItem jmItemAbrir, jmItemGuardar, jmItemCopiar2, jmItemPegar2;
	private JMenuItem jmItemCortar2, jmAcercaDe;
	private JCheckBoxMenuItem jmItemCourierNew, jmItemArial, jmItemFPredeterminada;
	private JCheckBoxMenuItem jmItem16, jmItem24, jmItemTPredeterminado;
	private JButton jbtCortar, jbtCopiar, jbtPegar;
	private JPopupMenu menuPop;

	

	public PanelEditor(){
		getContentPane().setLayout(null);
		menuBar = new JMenuBar();
		toolBar = new JToolBar();
		areaTexto = new JTextArea("");
		menuPop = new JPopupMenu();
		JSeparator separador = new JSeparator();
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
		jmArchivo.add(separador);
		jmItemSalir = new JMenuItem("Salir", new Integer('S'));
		jmArchivo.add(jmItemSalir);
		jmEdicion = new JMenu("Edición");
		jmEdicion.setMnemonic('E');
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
		jmTamaño = new JMenu("Tamaño");
		jmTamaño.setMnemonic('T');
		jmItem16 = new JCheckBoxMenuItem("16");
		jmTamaño.add(jmItem16);
		jmItem24 = new JCheckBoxMenuItem("24");
		jmTamaño.add(jmItem24);
		jmItemTPredeterminado = new JCheckBoxMenuItem("Predeterminado");
		jmItemTPredeterminado.setSelected(true);
		jmTamaño.add(jmItemTPredeterminado);
		jmOpciones.add(jmTamaño);
		jmAyuda = new JMenu("Ayuda");
		jmAyuda.setMnemonic('u');
		jmAcercaDe = new JMenuItem("Acerca del Editor de Texto", new Integer('d'));
		jmAyuda.add(jmAcercaDe);
		menuBar.add(jmArchivo);
		menuBar.add(jmEdicion);
		menuBar.add(jmOpciones);
		menuBar.add(jmAyuda);

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
		jmAcercaDe.setActionCommand(VistaEditor.ACERCA_DE);
		habilitarItemEdicion(false);

		controladorEdicion(this);
		controladorOpciones(this);

		this.addComponentListener(new ControladorVentana(this));
		this.addWindowStateListener(new ControladorVentana(this));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(PanelEditor.class.getResource("/img/ic_bloc.png")));
		this.setTitle("Editor de Texto - Luis Romero Moreno");
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
		jmAcercaDe.addActionListener(new ControladorEdicion(ve));
	}

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
	public void setTamañoComponentes(int ancho, int altura) {
		toolBar.setSize(ancho-6, toolBar.getHeight());
		panelDesplazamiento.setSize(ancho-7, altura-93);
	}
	
	public JPopupMenu getMenuPop() {
		return menuPop;
	}

	@Override
	public JFrame getFrame() {
		return this;
	}

}
