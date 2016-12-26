package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.ImageIcon;

public class frmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistroDeReserva;
	private JMenu mnControlDePago;
	private JMenu mnReportes;
	private JMenuItem mntmClientes;
	private JMenuItem mntmSalas;
	private JMenuItem mntmPelculas;
	private JMenuItem mntmFunciones;
	private JMenuItem mntmCine;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmReserva;
	private JLabel label;
	private JMenuItem mntmBoleta;
	private JMenuItem mntmReporte;
	private JMenu mnAcercaDe;
	private JMenuItem mntmDesarrolladores;
	private JMenuItem mntmReserva_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setTitle("Sistema de Atenci\u00F3n de Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1292, 780);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Cliente.png")));
		mntmClientes.addActionListener(this);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Empleado.png")));
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		mnMantenimiento.add(mntmClientes);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Salas.png")));
		mntmSalas.addActionListener(this);
		
		mntmCine = new JMenuItem("Cine");
		mntmCine.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Cine.png")));
		mntmCine.addActionListener(this);
		mnMantenimiento.add(mntmCine);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Pelicula");
		mntmPelculas.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Pelicula.png")));
		mntmPelculas.addActionListener(this);
		mnMantenimiento.add(mntmPelculas);
		
		mntmFunciones = new JMenuItem("Funciones");
		mntmFunciones.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Funciones.png")));
		mntmFunciones.addActionListener(this);
		mnMantenimiento.add(mntmFunciones);
		
		mnRegistroDeReserva = new JMenu("Registro de Reserva");
		mnRegistroDeReserva.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Registrar.png")));
		mnRegistroDeReserva.addActionListener(this);
		menuBar.add(mnRegistroDeReserva);
		
		mntmReserva = new JMenuItem("Registro");
		mntmReserva.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/RegistroReserva.png")));
		mntmReserva.addActionListener(this);
		
		mntmReserva_1 = new JMenuItem("Reserva");
		mntmReserva_1.addActionListener(this);
		mntmReserva_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/save.png")));
		mnRegistroDeReserva.add(mntmReserva_1);
		mnRegistroDeReserva.add(mntmReserva);
		
		mnControlDePago = new JMenu("Control de Pago");
		mnControlDePago.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/ControlPago.png")));
		menuBar.add(mnControlDePago);
		
		mntmBoleta = new JMenuItem("Boleta");
		mntmBoleta.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Boleta.png")));
		mntmBoleta.addActionListener(this);
		mnControlDePago.add(mntmBoleta);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Reportes1.png")));
		menuBar.add(mnReportes);
		
		mntmReporte = new JMenuItem("Reporte");
		mntmReporte.addActionListener(this);
		mntmReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Reportes.png")));
		mnReportes.add(mntmReporte);
		
		mnAcercaDe = new JMenu("Acerca de");
		mnAcercaDe.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Acerca.png")));
		menuBar.add(mnAcercaDe);
		
		mntmDesarrolladores = new JMenuItem("Desarrolladores");
		mntmDesarrolladores.addActionListener(this);
		mntmDesarrolladores.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/Desarrolladores.png")));
		mnAcercaDe.add(mntmDesarrolladores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(frmPrincipal.class.getResource("/img/fondo.jpg")));
		label.setBounds(0, 0, 1362, 643);
		contentPane.add(label);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReporte) {
			actionPerformedMntmReporte(e);
		}
		if (e.getSource() == mntmReserva_1) {
			actionPerformedMntmReserva_1(e);
		}
		if (e.getSource() == mntmDesarrolladores) {
			actionPerformedMntmDesarrolladores(e);
		}
		if (e.getSource() == mntmFunciones) {
			actionPerformedMntmFunciones(e);
		}
		if (e.getSource() == mntmBoleta) {
			actionPerformedMntmBoleta(e);
		}
		if (e.getSource() == mntmReserva) {
			actionPerformedMntmReserva(e);
		}
		if (e.getSource() == mnRegistroDeReserva) {
			actionPerformedMnRegistroDeReserva(e);
		}
		if (e.getSource() == mntmPelculas) {
			actionPerformedMntmPelculas(e);
		}
		if (e.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleado(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmCine) {
			actionPerformedMntmCine(e);
		}
		if (e.getSource() == mntmSalas) {
			mntmSalasActionPerformed(e);
		}
	}
	protected void mntmSalasActionPerformed(ActionEvent e) {
		frmSala mostrarSala = new frmSala();
		mostrarSala.setLocationRelativeTo(this);
		mostrarSala.setVisible(true);
	}
	protected void actionPerformedMntmCine(ActionEvent e) {
		frmCine fc;
		fc = new frmCine ();
		fc.setLocationRelativeTo(this);
		fc.setVisible(true);
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {
		frmCliente f;
		f = new frmCliente ();
		f.setLocationRelativeTo(this);
		f.setVisible(true);
	}
	protected void actionPerformedMntmEmpleado(ActionEvent e) {
		frmEmpleado m;
		m = new frmEmpleado  ();
		m.setLocationRelativeTo(this);
		m.setVisible(true);
	}
	protected void actionPerformedMntmPelculas(ActionEvent e) {
		frmPelicula p;
		p = new frmPelicula ();
		p.setLocationRelativeTo(this);
		p.setVisible(true);
	}
	protected void actionPerformedMnRegistroDeReserva(ActionEvent e) {	
	}
	protected void actionPerformedMntmReserva(ActionEvent e) {
		
		frmResgistroReserva2 ventana;
		ventana=new frmResgistroReserva2();
		ventana.setLocationRelativeTo(this);
		ventana.setVisible(true);
		
	}
	protected void actionPerformedMntmBoleta(ActionEvent e) {
		frmControlPago cp;
		cp=new frmControlPago();
		cp.setLocationRelativeTo(this);
		cp.setVisible(true);
	}
	protected void actionPerformedMntmFunciones(ActionEvent e) {
		frmFuncion ventana;
		ventana=new frmFuncion();
		ventana.setLocationRelativeTo(this);
		ventana.setVisible(true);
	}
	protected void actionPerformedMntmDesarrolladores(ActionEvent e) {
		Acerca a;
		a=new Acerca();
		a.setLocationRelativeTo(this);
		a.setVisible(true);
	}
	protected void actionPerformedMntmReserva_1(ActionEvent e) {
		frmReserva fr;
		fr=new frmReserva();
		fr.setLocationRelativeTo(this);
		fr.setVisible(true);
	}
	protected void actionPerformedMntmReporte(ActionEvent e) {
		Reporte r;
		r=new Reporte();
		r.setLocationRelativeTo(this);
		r.setVisible(true);
	}
}
