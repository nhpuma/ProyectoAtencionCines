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
		setBounds(100, 100, 877, 744);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		mnMantenimiento.add(mntmClientes);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.addActionListener(this);
		
		mntmCine = new JMenuItem("Cine");
		mntmCine.addActionListener(this);
		mnMantenimiento.add(mntmCine);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Pelicula");
		mntmPelculas.addActionListener(this);
		mnMantenimiento.add(mntmPelculas);
		
		mntmFunciones = new JMenuItem("Funciones");
		mnMantenimiento.add(mntmFunciones);
		
		mnRegistroDeReserva = new JMenu("Registro de Reserva");
		menuBar.add(mnRegistroDeReserva);
		
		mnControlDePago = new JMenu("Control de Pago");
		menuBar.add(mnControlDePago);
		
		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
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
		frmSalas mostrarSala = new frmSalas();
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
}
