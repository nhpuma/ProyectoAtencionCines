package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmReserva extends JFrame {

	private JPanel contentPane;
	private JTextField txtReserva;
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	private JTextField txtFuncion;
	private JTextField txtFechaReserv;
	private JTextField txtHoraReserv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReserva frame = new frmReserva();
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
	public frmReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoReserva = new JLabel("C\u00F3digo Reserva:");
		lblCdigoReserva.setBounds(41, 27, 103, 23);
		contentPane.add(lblCdigoReserva);
		
		JLabel lblCdigoCliente = new JLabel("C\u00F3digo Cliente:");
		lblCdigoCliente.setBounds(41, 51, 103, 23);
		contentPane.add(lblCdigoCliente);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo Empleado:");
		lblCdigoEmpleado.setBounds(41, 76, 103, 23);
		contentPane.add(lblCdigoEmpleado);
		
		JLabel lblCdigoFuncion = new JLabel("C\u00F3digo Funci\u00F3n:");
		lblCdigoFuncion.setBounds(41, 100, 103, 23);
		contentPane.add(lblCdigoFuncion);
		
		JLabel lblFechaReserva = new JLabel("Fecha de la Reserva:");
		lblFechaReserva.setBounds(297, 27, 103, 23);
		contentPane.add(lblFechaReserva);
		
		JLabel lblHoraDeReserva = new JLabel("Hora de la Reserva:");
		lblHoraDeReserva.setBounds(297, 51, 103, 23);
		contentPane.add(lblHoraDeReserva);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(297, 78, 100, 18);
		contentPane.add(lblEstado);
		
		txtReserva = new JTextField();
		txtReserva.setBounds(155, 28, 103, 20);
		contentPane.add(txtReserva);
		txtReserva.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(155, 52, 103, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(155, 77, 103, 20);
		contentPane.add(txtEmpleado);
		
		txtFuncion = new JTextField();
		txtFuncion.setColumns(10);
		txtFuncion.setBounds(155, 101, 103, 20);
		contentPane.add(txtFuncion);
		
		txtFechaReserv = new JTextField();
		txtFechaReserv.setColumns(10);
		txtFechaReserv.setBounds(407, 28, 103, 20);
		contentPane.add(txtFechaReserv);
		
		txtHoraReserv = new JTextField();
		txtHoraReserv.setColumns(10);
		txtHoraReserv.setBounds(407, 52, 103, 20);
		contentPane.add(txtHoraReserv);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cbxEstado.setBounds(407, 76, 103, 23);
		contentPane.add(cbxEstado);
	}
}
