package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ArregloEmpleado;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModificarEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textPaterno;
	private JTextField textMaterno;
	private JTextField textUsuario;
	private JTextField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmModificarEmpleado frame = new frmModificarEmpleado();
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
	
	ArregloEmpleado aa= new ArregloEmpleado();
	private JComboBox cbxTipo;
	
	
	
	public frmModificarEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(40, 51, 42, 24);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 95, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
		lblApellidoPaterno.setBounds(40, 136, 90, 14);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno:");
		lblApellidoMaterno.setBounds(42, 176, 88, 14);
		contentPane.add(lblApellidoMaterno);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(140, 52, 108, 22);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(140, 90, 108, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPaterno = new JTextField();
		textPaterno.setBounds(140, 133, 108, 20);
		contentPane.add(textPaterno);
		textPaterno.setColumns(10);
		
		textMaterno = new JTextField();
		textMaterno.setBounds(140, 173, 108, 20);
		contentPane.add(textMaterno);
		textMaterno.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(278, 57, 77, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(278, 97, 77, 14);
		contentPane.add(lblContrasea);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(358, 54, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(358, 94, 86, 20);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		JLabel lblTipoEmpleado = new JLabel("Tipo Empleado:");
		lblTipoEmpleado.setBounds(40, 223, 77, 14);
		contentPane.add(lblTipoEmpleado);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Cajero"}));
		cbxTipo.setBounds(140, 220, 108, 20);
		contentPane.add(cbxTipo);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnBuscar.setBounds(302, 132, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(302, 172, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(302, 219, 89, 23);
		contentPane.add(btnSalir);
	}
	
//  Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Integer.parseInt(textCodigo.getText().trim());
	}
	String leerNombre() {
		return textNombre.getText().trim();
	}
	String leerApellidop() {
		return textPaterno.getText().trim();
	}
	String leerApellidom() {
		return textMaterno.getText().trim();
	}
	String leerUsuario() {
		return textUsuario.getText().trim();
	}
	String leerContrasena() {
		return textContraseña.getText().trim();
	}

	int leerTipoEmp(){
		return cbxTipo.getSelectedIndex();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

