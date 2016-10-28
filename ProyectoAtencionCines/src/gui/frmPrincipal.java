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
	private JMenu mnCines;
	private JMenuItem mntmIngresar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmEliminar;
	private JMenuItem mntmListar;
	private JMenu mnEmpleado;
	private JMenuItem mntmIngresar_1;
	private JLabel lblNewLabel;

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
		setBounds(100, 100, 550, 370);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnEmpleado = new JMenu("Empleado");
		mnMantenimiento.add(mnEmpleado);
		
		mntmIngresar_1 = new JMenuItem("Ingresar");
		mntmIngresar_1.addActionListener(this);
		mnEmpleado.add(mntmIngresar_1);
		
		mntmClientes = new JMenuItem("Clientes");
		mnMantenimiento.add(mntmClientes);
		
		mntmSalas = new JMenuItem("Salas");
		mntmSalas.addActionListener(this);
		
		mnCines = new JMenu("Cines");
		mnMantenimiento.add(mnCines);
		
		mntmIngresar = new JMenuItem("Ingresar");
		mntmIngresar.addActionListener(this);
		mnCines.add(mntmIngresar);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(this);
		mnCines.add(mntmModificar);
		
		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(this);
		mnCines.add(mntmEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnCines.add(mntmListar);
		mnMantenimiento.add(mntmSalas);
		
		mntmPelculas = new JMenuItem("Peliculas");
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
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1354, 673);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmIngresar_1) {
			do_mntmIngresar_1_actionPerformed(e);
		}
		if (e.getSource() == mntmListar) {
			do_mntmListar_actionPerformed(e);
		}
		if (e.getSource() == mntmEliminar) {
			do_mntmEliminar_actionPerformed(e);
		}
		if (e.getSource() == mntmModificar) {
			do_mntmModificar_actionPerformed(e);
		}
		if (e.getSource() == mntmIngresar) {
			do_mntmIngresar_actionPerformed(e);
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
	protected void do_mntmIngresar_actionPerformed(ActionEvent e) {
		frmIngresoCine fic;
		fic = new frmIngresoCine();
		fic.setLocationRelativeTo(this);
		fic.setVisible(true);
	}
	protected void do_mntmModificar_actionPerformed(ActionEvent e) {
		frmModificarCine fmc;
		fmc = new frmModificarCine();
		fmc.setLocationRelativeTo(this);
		fmc.setVisible(true);
	}
	protected void do_mntmEliminar_actionPerformed(ActionEvent e) {
		frmEliminarCine fec;
		fec = new frmEliminarCine();
		fec.setLocationRelativeTo(this);
		fec.setVisible(true);
	}
	protected void do_mntmListar_actionPerformed(ActionEvent e) {
		frmListarCine flc;
		flc = new frmListarCine();
		flc.setLocationRelativeTo(this);
		flc.setVisible(true);
	}
	protected void do_mntmIngresar_1_actionPerformed(ActionEvent e) {
		frmIngresoEmpleado fle;
		fle = new frmIngresoEmpleado ();
		fle.setLocationRelativeTo(this);
		fle.setVisible(true);
	}
}
