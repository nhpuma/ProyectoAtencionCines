package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import clases.Cine;
import clases.Empleado;
import controlador.ArregloEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmIngresoEmpleado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCod;
	private JLabel lblNombre;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblTipoEmpleado;
	private JTextField txtNom;
	private JTextField txtApepater;
	private JTextField txtApemater;
	private JComboBox cmbTipo;
	private JTextField txtUsu;
	private JPasswordField txtCont;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnIngresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIngresoEmpleado frame = new frmIngresoEmpleado();
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
	public frmIngresoEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 14, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCod = new JTextField();
		txtCod.setBounds(110, 8, 99, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 46, 46, 14);
		contentPane.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(10, 79, 86, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(10, 104, 86, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblTipoEmpleado = new JLabel("Tipo Empleado:");
		lblTipoEmpleado.setBounds(10, 138, 86, 14);
		contentPane.add(lblTipoEmpleado);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(110, 39, 99, 20);
		contentPane.add(txtNom);
		
		txtApepater = new JTextField();
		txtApepater.setColumns(10);
		txtApepater.setBounds(110, 70, 99, 20);
		contentPane.add(txtApepater);
		
		txtApemater = new JTextField();
		txtApemater.setColumns(10);
		txtApemater.setBounds(110, 101, 99, 20);
		contentPane.add(txtApemater);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Cajero"}));
		cmbTipo.setBounds(110, 135, 99, 20);
		contentPane.add(cmbTipo);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(357, 14, 86, 20);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		txtCont = new JPasswordField();
		txtCont.setColumns(10);
		txtCont.setBounds(357, 45, 86, 20);
		contentPane.add(txtCont);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(257, 20, 46, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(257, 51, 67, 14);
		contentPane.add(lblContrasea);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon("E:\\ProyectoAtencionCines\\ProyectoAtencionCines\\src\\images\\ingresar.png"));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(235, 104, 113, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon("E:\\ProyectoAtencionCines\\ProyectoAtencionCines\\src\\images\\salir.png"));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(357, 104, 89, 23);
		contentPane.add(btnSalir);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
	}
	ArregloEmpleado ac=new ArregloEmpleado("Empleado.txt");
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		adicionarEmpleado();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	void adicionarEmpleado() {
		int codigoEmp= leerCodigo();
		String nombres = leerNombre();
		if (nombres.length() > 0)
			try {
				String apellido_paterno = leerApePater();
				try {
					try{
						String apellido_materno = leerApeMater();
						try{
							int tipo = leerTipoEmpleado();
							try{
								String  usuario = leerUsuario();
								try{
									String contrasena = leerContrasena();
									Empleado nuevo = new Empleado( codigoEmp, tipo,nombres,  apellido_paterno, apellido_materno,
											 usuario, contrasena);
							  		ac.adicionar(nuevo);
							  		ac.grabarEmpleado();
									
									txtCod.setText("" + ac.cod_Correlativo());
									txtNom.setText("");
									txtApepater.setText("");
									txtApemater.setText("");
									cmbTipo.setSelectedIndex(tipo);
									txtUsu.setText("");
									txtCont.setText("");
									txtNom.requestFocus();
								}
								catch(Exception e){
									mensaje("ingrese ESTATURA correcta");
								}
							}
								catch(Exception e){
									mensaje("ingrese ESTATURA correcta");
								}
						}
								catch(Exception e){
									mensaje("ingrese ESTATURA correcta");
								}
					}
								catch(Exception e){
									mensaje("ingrese ESTATURA correcta");
								}
				
				}
				catch (Exception e) {
					mensaje("ingrese ESTATURA correcta");
						
				}
			}
			catch (Exception e) {
				mensaje("ingrese PESO correcto");
			
			}
		else {
			mensaje("ingrese NOMBRE correcto");
		
		}
	}
	//mensaje
	public  void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
//  Métodos que retornan valor sin parámetros
		int leerCodigo() {
			return Integer.parseInt(txtCod.getText().trim());
		}
		String leerNombre() {
			return txtNom.getText().trim();
		}
		String leerApePater() {
			return txtApepater.getText().trim();
		}
		String leerApeMater() {
			return txtApemater.getText().trim();
		}
		int leerTipoEmpleado() {
			return cmbTipo.getSelectedIndex();
		}
		String leerUsuario() {
			return txtUsu.getText().trim();
		}
		String leerContrasena() {
			return txtCont.getText().trim();
		}
}
