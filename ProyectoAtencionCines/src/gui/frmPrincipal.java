package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistroDeReserva;
	private JMenu mnControlDePago;
	private JMenu mnReportes;
	private JMenuItem mntmEmpleados;
	private JMenuItem mntmClientes;
	private JMenuItem mntmCines;
	private JMenuItem mntmSalas;
	private JMenuItem mntmPelculas;
	private JMenuItem mntmFunciones;

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
		setTitle("Sistema de Atención de Cines");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 370);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmEmpleados = new JMenuItem("Empleados");
		mnMantenimiento.add(mntmEmpleados);
		
		mntmClientes = new JMenuItem("Clientes");
		mnMantenimiento.add(mntmClientes);
		
		mntmCines = new JMenuItem("Cines");
		mnMantenimiento.add(mntmCines);
		
		mntmSalas = new JMenuItem("Salas");
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Películas");
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
