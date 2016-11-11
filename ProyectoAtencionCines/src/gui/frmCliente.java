package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cine;
import clases.Cliente;
import controlador.ArregloCliente;

import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTable tbltabla;
	private JLabel lblIngreseCodigoi;
	private JTextField txtcodigo;
	private JLabel lblNombre;
	private JTextField txtnom;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtapepat;
	private JTextField txtapemat;
	private JLabel lblDireccion;
	private JTextField txtdirec;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtfechanaci;
	private JLabel lblFechaDeAfiliacion;
	private JTextField txtfechaafi;
	private JLabel lblEstadoCivil;
	private JComboBox cmbestado;
	private JLabel lblTelefono;
	private JTextField txttelefono;
	private JLabel lblDni;
	private JTextField txtdni;
	private JLabel lblUsuario;
	private JTextField txtusu;
	private JLabel lblContrasea;
	private JPasswordField txtcontra;
	private JButton btnIngresar;
	private JButton btnSalir;
	private DefaultTableModel modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCliente frame = new frmCliente();
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
	public frmCliente() {
		setTitle("ingreso de cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane tblTabla = new JScrollPane();
		tblTabla.setBounds(0, 154, 836, 190);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		lblIngreseCodigoi = new JLabel("Codigo:");
		lblIngreseCodigoi.setBounds(22, 11, 111, 14);
		contentPane.add(lblIngreseCodigoi);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(136, 11, 86, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		lblNombre = new JLabel("nombre");
		lblNombre.setBounds(22, 38, 111, 14);
		contentPane.add(lblNombre);
		
		txtnom = new JTextField();
		txtnom.setBounds(136, 38, 86, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		lblApellidoPaterno = new JLabel("apellido paterno");
		lblApellidoPaterno.setBounds(22, 63, 111, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("apellido materno");
		lblApellidoMaterno.setBounds(22, 85, 111, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtapepat = new JTextField();
		txtapepat.setBounds(136, 63, 86, 20);
		contentPane.add(txtapepat);
		txtapepat.setColumns(10);
		
		txtapemat = new JTextField();
		txtapemat.setBounds(136, 88, 86, 20);
		contentPane.add(txtapemat);
		txtapemat.setColumns(10);
		
		lblDireccion = new JLabel("direccion");
		lblDireccion.setBounds(22, 110, 111, 14);
		contentPane.add(lblDireccion);
		
		txtdirec = new JTextField();
		txtdirec.setBounds(136, 117, 86, 20);
		contentPane.add(txtdirec);
		txtdirec.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(242, 11, 155, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		txtfechanaci = new JTextField();
		txtfechanaci.setBounds(393, 11, 86, 20);
		contentPane.add(txtfechanaci);
		txtfechanaci.setColumns(10);
		
		lblFechaDeAfiliacion = new JLabel("fecha de afiliacion");
		lblFechaDeAfiliacion.setBounds(242, 38, 155, 14);
		contentPane.add(lblFechaDeAfiliacion);
		
		txtfechaafi = new JTextField();
		txtfechaafi.setBounds(393, 38, 86, 20);
		contentPane.add(txtfechaafi);
		txtfechaafi.setColumns(10);
		
		lblEstadoCivil = new JLabel("estado civil");
		lblEstadoCivil.setBounds(242, 63, 155, 14);
		contentPane.add(lblEstadoCivil);
		
		cmbestado = new JComboBox();
		cmbestado.setModel(new DefaultComboBoxModel(new String[] {" Soltero", "Casado", "Viudo", "Divorciado "}));
		cmbestado.setBounds(392, 63, 87, 20);
		contentPane.add(cmbestado);
		
		lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(242, 85, 155, 14);
		contentPane.add(lblTelefono);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(393, 88, 86, 20);
		contentPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(242, 117, 46, 14);
		contentPane.add(lblDni);
		
		txtdni = new JTextField();
		txtdni.setBounds(393, 117, 86, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		lblUsuario = new JLabel("usuario");
		lblUsuario.setBounds(510, 11, 80, 14);
		contentPane.add(lblUsuario);
		
		txtusu = new JTextField();
		txtusu.setBounds(600, 10, 86, 20);
		contentPane.add(txtusu);
		txtusu.setColumns(10);
		
		lblContrasea = new JLabel("contrase\u00F1a");
		lblContrasea.setBounds(509, 33, 81, 14);
		contentPane.add(lblContrasea);
		
		txtcontra = new JPasswordField();
		txtcontra.setBounds(600, 32, 86, 20);
		contentPane.add(txtcontra);
		txtcontra.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(frmCliente.class.getResource("/img/add2.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(696, 11, 130, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("salir");
		btnSalir.setIcon(new ImageIcon(frmCliente.class.getResource("/img/cancel2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(696, 106, 130, 23);
		contentPane.add(btnSalir);
		
		//gloval
		modelo = new DefaultTableModel();
		//Aquí agregas las columnas para tu tabla
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("apellido paterno");
		modelo.addColumn("apellido materno");
		modelo.addColumn("Direccion");
		modelo.addColumn("Fecha de nacimiento");
		modelo.addColumn("Fecha de afiliacion");
		modelo.addColumn("estado civil");
		modelo.addColumn("telefono");
		modelo.addColumn("dni");
		modelo.addColumn("usuario");
		modelo.addColumn("contraseña");
		table.setModel(modelo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(frmCliente.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(510, 81, 130, 23);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(frmCliente.class.getResource("/img/edit2.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(696, 38, 130, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmCliente.class.getResource("/img/remove2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(696, 63, 130, 23);
		contentPane.add(btnEliminar);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	ArregloCliente ab = new ArregloCliente("Cliente.txt");

	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarCliente();
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		adicionarCliente();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarCliente();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarCliente();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	
	//  Métodos tipo void (sin parámetros)
   	void limpieza() {
   	txtnom.setText("");
   	txtapepat.setText("");
   	txtapemat.setText("");
   	txtdirec.setText("");
   	txtfechanaci.setText("");
   	txtfechaafi.setText("");
   	txttelefono.setText("");
   	txtdni.setText("");
	txtfechanaci.setText("");
	txtusu.setText("");
	txtcontra.setText("");
   	}
	
	void listar(){
		txtcodigo.setText(""+ab.codcor());
		modelo.setRowCount(0);
		for (int i = 0; i < ab.tamanio(); i++) {
			Object fila[] = {
					ab.obtener(i).getCodCliente(),
					ab.obtener(i).getNombre(),
					ab.obtener(i).getApepat(),
					ab.obtener(i).getApemat(),
					ab.obtener(i).getDireccion(),
					ab.obtener(i).getFechanacimiento(),
					ab.obtener(i).getFechaafiliacion(),
					ab.obtener(i).estadoCliente(),
					ab.obtener(i).getTelefono(),
					ab.obtener(i).getDni(),
					ab.obtener(i).getUsuario(),
					ab.obtener(i).getContraseña(),
			};
			modelo.addRow(fila);
		}
	}
	public  void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		
	//  Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Integer.parseInt(txtcodigo.getText().trim());
	}
	String leerNombre() {
		return txtnom.getText().trim();
	}
	String leerApellidopaterno() {
		return txtapepat.getText().trim();
	}
	String leerApellidomaterno() {
		return txtapemat.getText().trim();
	}
	String leerDireccion() {
		return txtdirec.getText().trim();
	}
	String leerFechanaci() {
		return txtfechanaci.getText().trim();
	}
	String leerFechaAfiliacion() {
		return txtfechaafi.getText().trim();
	}
	int leerEstado(){
		return cmbestado.getSelectedIndex();
	}
	String leerTelefono() {
		return txttelefono.getText().trim();
	}
	String leerDni() {
		return txtdni.getText().trim();
	}
	String leerUsuario() {
		return txtusu.getText().trim();
	}
	String leerContraseña() {
		return txtcontra.getText().trim();
	}

	void adicionarCliente() {
		int codCliente = leerCodigo();
		if (ab.buscar(codCliente) == null) {
			String nombre = leerNombre();
			if (nombre.length() > 0)
				try {
					String apepat = leerApellidopaterno();
					try {
						String apermat= leerApellidomaterno();
						try{
							String direccion = leerDireccion();
							try{
								String fechanacimiento = leerFechanaci();
								try{
									String fechaafiliacion=	leerFechaAfiliacion();
									try{
										int estadocivil = leerEstado();
										 try{
											String telefono = leerTelefono();
											try {
												String dni=leerDni();
												if(dni.length() == 8)
												try{
													String usuario =leerUsuario();
													try{
														String contraseña = leerContraseña();
												
													Cliente nuevo = new Cliente(codCliente, nombre,apepat , apermat, direccion,
															fechanacimiento,fechaafiliacion,estadocivil,
															telefono ,dni,usuario,contraseña);
																ab.adicionar(nuevo);
																ab.grabarCliente();
																listar();
																limpieza();
																			}						
																		catch (Exception e){
																			mensaje("ingrese apellidopaterno");
																		}	
																			}
																			catch (Exception e) {
																	mensaje("ingrese apellido materno");
															}
																 }
															catch (Exception e) {
															mensaje("verificar numeros de dni");
															}
																				}
														catch (Exception e) {
											            mensaje("ingrese fecha de nacimiento");		
														}
																			
																	}
													catch (Exception e) {
												 mensaje("ingrese fecha de afiliacion");		
														}
														}
												catch (Exception e) {
											 mensaje("ingrese tipo de estado");		
														}
														}	
											catch (Exception e) {
											mensaje("ingrese telefono");		
												}
												}	
										catch (Exception e) {
											 mensaje("ingrese dni");		
													}
													}	
								catch (Exception e) {
									 mensaje("ingrese usuario");		
											}
											}
						catch (Exception e) {
							 mensaje("ingrese contraseña : ");		
									}
					else {
					mensaje("ingrese nombre");
				
			}
		}
			else  {
			mensaje("ingrese nombre");
			txtnom.setText("");
			txtnom.requestFocus();
			}
	}
	//BUSCAR CLIENTE
	void buscarCliente() {
		try {
			Cliente x= ab.buscar(leerCodigo());
			if (x != null) {
				txtnom.setText(x.getNombre());
				txtapepat.setText(x.getApepat());
				txtapemat.setText(x.getApemat());
				txtdirec.setText(x.getDireccion());
				txtfechanaci.setText(x.getFechanacimiento());
				txtfechaafi.setText(x.getFechaafiliacion());
				cmbestado.setSelectedIndex(x.getEstadocivil());
				txttelefono.setText(x.getTelefono());
				txtdni.setText(x.getDni());
				txtusu.setText(x.getUsuario());
				txtcontra.setText(x.getContraseña());
			}
			else {
				mensaje("El código " + leerCodigo() + " no existe");
				txtcodigo.setText("");
				txtcodigo.requestFocus();
			}
		}
		catch (Exception e) {
			mensaje("ingrese CÓDIGO correcto");
			txtcodigo.setText("");
			txtcodigo.requestFocus();
		}
	}
	
	//modificar
	void modificarCliente() {
		try{
		Cliente x = ab.buscar(leerCodigo());
			String nombre = leerNombre();
			if (nombre.length() > 0)
				try {
					String apepat = leerApellidopaterno();
					try {
						String apermat= leerApellidomaterno();
						try{
							String direccion = leerDireccion();
							try{
								String fechanacimiento = leerFechanaci();
								try{
									String fechaafiliacion=	leerFechaAfiliacion();
									try{
										int estadocivil = leerEstado();
										 try{
											String telefono = leerTelefono();
											try {
												String dni=leerDni();
												try{
													String usuario =leerUsuario();
													try{
														String contraseña = leerContraseña();
																x.setNombre(nombre);
																x.setApepat(apepat);
																x.setApermat(apermat);
																x.setDireccion(direccion);
																x.setFechanacimiento(fechanacimiento);
																x.setFechaafiliacion(fechaafiliacion);
																x.setEstadocivil(estadocivil);
																x.setTelefono(telefono);
																x.setDni(dni);
																x.setUsuario(usuario);
																x.setContraseña(contraseña);
																txtcodigo.requestFocus();
																ab.grabarCliente();
																listar();
																limpieza();
																			}						
																		catch (Exception e){
																			mensaje("ingrese apellidopaterno");
																		}	
																			}
																			catch (Exception e) {
																	mensaje("ingrese apellido materno");
															}
																 }
															catch (Exception e) {
															mensaje("ingrese direccion");
															}
																				}
														catch (Exception e) {
											            mensaje("ingrese fecha de nacimiento");		
														}
																			
																	}
													catch (Exception e) {
												 mensaje("ingrese fecha de afiliacion");		
														}
														}
												catch (Exception e) {
											 mensaje("ingrese tipo de estado");		
														}
														}	
											catch (Exception e) {
											mensaje("ingrese telefono");		
												}
												}	
										catch (Exception e) {
											 mensaje("ingrese dni");		
													}
													}	
								catch (Exception e) {
									 mensaje("ingrese usuario");		
											}
											}
						catch (Exception e) {
							 mensaje("ingrese contraseña : ");		
									}
					else {
					mensaje("el codigo ya existe");
					txtcodigo.setText("");
					txtcodigo.requestFocus();
			}
		}
		catch (Exception e){
			
		}
	}
	//ELIMINAR
	void eliminarCliente() {
		try {
			Cliente x = ab.buscar(leerCodigo());
			if (x != null) {
				ab.eliminar(x);
				ab.grabarCliente();
				txtcodigo.setText("");
				txtnom.setText("");
				txtapepat.setText("");
				txtapemat.setText("");
				txtdirec.setText("");
				txtfechanaci.setText("");
				txtfechaafi.setText("");
				cmbestado.setToolTipText("");
				txttelefono.setText("");
				txtdni.setText("");
				txtusu.setText("");
				txtcontra.setText("");
				txtcodigo.requestFocus();
				listar();
			}
			else {
				mensaje("El código " + leerCodigo() + " no existe");
				txtcodigo.setText("");
				txtcodigo.requestFocus();
			}
		}
		catch (Exception e) {
			mensaje("ingrese CÓDIGO correcto");
			txtcodigo.setText("");
			txtcodigo.requestFocus();
		}	
	}
	
	
}

