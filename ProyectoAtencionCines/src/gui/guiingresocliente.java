package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class guiingresocliente extends JFrame implements ActionListener {

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
	private JTextField txtcontra;
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
					guiingresocliente frame = new guiingresocliente();
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
	public guiingresocliente() {
		setTitle("ingreso de cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane tblTabla = new JScrollPane();
		tblTabla.setBounds(20, 154, 661, 190);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		lblIngreseCodigoi = new JLabel("ingrese codigoi");
		lblIngreseCodigoi.setBounds(22, 11, 71, 14);
		contentPane.add(lblIngreseCodigoi);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(115, 8, 86, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		lblNombre = new JLabel("nombre");
		lblNombre.setBounds(22, 38, 46, 14);
		contentPane.add(lblNombre);
		
		txtnom = new JTextField();
		txtnom.setBounds(115, 35, 86, 20);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		lblApellidoPaterno = new JLabel("apellido paterno");
		lblApellidoPaterno.setBounds(22, 63, 86, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("apellido materno");
		lblApellidoMaterno.setBounds(22, 85, 86, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtapepat = new JTextField();
		txtapepat.setBounds(115, 60, 86, 20);
		contentPane.add(txtapepat);
		txtapepat.setColumns(10);
		
		txtapemat = new JTextField();
		txtapemat.setBounds(115, 85, 86, 20);
		contentPane.add(txtapemat);
		txtapemat.setColumns(10);
		
		lblDireccion = new JLabel("direccion");
		lblDireccion.setBounds(22, 110, 46, 14);
		contentPane.add(lblDireccion);
		
		txtdirec = new JTextField();
		txtdirec.setBounds(115, 114, 86, 20);
		contentPane.add(txtdirec);
		txtdirec.setColumns(10);
		
		lblFechaDeNacimiento = new JLabel("fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(227, 11, 96, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		txtfechanaci = new JTextField();
		txtfechanaci.setBounds(335, 8, 86, 20);
		contentPane.add(txtfechanaci);
		txtfechanaci.setColumns(10);
		
		lblFechaDeAfiliacion = new JLabel("fecha de afiliacion");
		lblFechaDeAfiliacion.setBounds(227, 38, 96, 14);
		contentPane.add(lblFechaDeAfiliacion);
		
		txtfechaafi = new JTextField();
		txtfechaafi.setBounds(335, 35, 86, 20);
		contentPane.add(txtfechaafi);
		txtfechaafi.setColumns(10);
		
		lblEstadoCivil = new JLabel("estado civil");
		lblEstadoCivil.setBounds(227, 63, 71, 14);
		contentPane.add(lblEstadoCivil);
		
		cmbestado = new JComboBox();
		cmbestado.setModel(new DefaultComboBoxModel(new String[] {" Soltero", "Casado", "Viudo", "Divorciado "}));
		cmbestado.setBounds(334, 60, 87, 20);
		contentPane.add(cmbestado);
		
		lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(227, 85, 46, 14);
		contentPane.add(lblTelefono);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(335, 85, 86, 20);
		contentPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(227, 117, 46, 14);
		contentPane.add(lblDni);
		
		txtdni = new JTextField();
		txtdni.setBounds(335, 114, 86, 20);
		contentPane.add(txtdni);
		txtdni.setColumns(10);
		
		lblUsuario = new JLabel("usuario");
		lblUsuario.setBounds(446, 63, 46, 14);
		contentPane.add(lblUsuario);
		
		txtusu = new JTextField();
		txtusu.setBounds(508, 60, 86, 20);
		contentPane.add(txtusu);
		txtusu.setColumns(10);
		
		lblContrasea = new JLabel("contrase\u00F1a");
		lblContrasea.setBounds(445, 85, 61, 14);
		contentPane.add(lblContrasea);
		
		txtcontra = new JTextField();
		txtcontra.setBounds(508, 82, 86, 20);
		contentPane.add(txtcontra);
		txtcontra.setColumns(10);
		
		btnIngresar = new JButton("ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(613, 38, 89, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(613, 81, 89, 23);
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
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	ArregloCliente ac = new ArregloCliente();
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		try {
			int codCliente = leerCodigo();
			if (ac.buscar(codCliente) == null) {
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
													
Cliente nuevo = new Cliente(codCliente, nombre,apepat , apermat, direccion,fechanacimiento,fechaafiliacion,estadocivil,
			telefono ,dni,usuario,contraseña);
		ac.adicionar(nuevo);
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
				else  {
				mensaje("ingrese nombre");
				txtnom.setText("");
				txtnom.requestFocus();
				}
		}
			catch(Exception e){
				mensaje("ingrese codigo");
			}
			}
	
	//  Métodos tipo void (sin parámetros)
   	void limpieza() {
   		txtcodigo.setText("");
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
	
	public void listar(){
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Object fila[] = {
					ac.obtener(i).getCodCliente(),
					ac.obtener(i).getNombre(),
					ac.obtener(i).getApepat(),
					ac.obtener(i).getApermat(),
					ac.obtener(i).getDireccion(),
					ac.obtener(i).getFechanacimiento(),
					ac.obtener(i).getFechaafiliacion(),
					ac.obtener(i).getEstadocivil(),
					ac.obtener(i).getTelefono(),
					ac.obtener(i).getDni(),
					ac.obtener(i).getUsuario(),
					ac.obtener(i).getContraseña(),
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
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
}

