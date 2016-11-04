package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmEmpleado extends JFrame implements ActionListener {

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
	//Agregando un modelo
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEmpleado frame = new frmEmpleado();
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
	public frmEmpleado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 14, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCod = new JTextField();
		txtCod.setBounds(148, 11, 99, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 46, 128, 14);
		contentPane.add(lblNombre);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(10, 79, 128, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(10, 104, 128, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblTipoEmpleado = new JLabel("Tipo Empleado:");
		lblTipoEmpleado.setBounds(10, 138, 128, 14);
		contentPane.add(lblTipoEmpleado);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(148, 42, 99, 20);
		contentPane.add(txtNom);
		
		txtApepater = new JTextField();
		txtApepater.setColumns(10);
		txtApepater.setBounds(148, 73, 99, 20);
		contentPane.add(txtApepater);
		
		txtApemater = new JTextField();
		txtApemater.setColumns(10);
		txtApemater.setBounds(148, 104, 99, 20);
		contentPane.add(txtApemater);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Supervisor", "Cajero"}));
		cmbTipo.setBounds(148, 138, 99, 20);
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
		lblUsuario.setBounds(273, 14, 74, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(273, 45, 86, 14);
		contentPane.add(lblContrasea);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/add2.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(472, 10, 131, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/cancel2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(472, 100, 131, 23);
		contentPane.add(btnSalir);
		tblTabla.setBounds(0, 163, 629, 264);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		//Creando el modelo en la tabla
				modelo = new DefaultTableModel();
				//Aquí agregas las columnas para tu tabla
				modelo.addColumn("Código");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido Pater");
				modelo.addColumn("Apellido Mater");
				modelo.addColumn("Tipo");
				modelo.addColumn("Usuario");
				modelo.addColumn("Contraseña");
				table.setModel(modelo);
				
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(257, 100, 131, 23);
		contentPane.add(btnBuscar);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/edit2.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(472, 42, 131, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/remove2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(472, 70, 131, 23);
		contentPane.add(btnEliminar);
		listar();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
	}
	ArregloEmpleado ac=new ArregloEmpleado("Empleado.txt");
	private final JScrollPane tblTabla = new JScrollPane();
	private JTable table;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarEmpleado();
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		adicionarEmpleado();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarEmpleado();
		limpieza();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		 eliminarEmpleado();
		 limpieza();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//LIEMPIEZA
   	void limpieza() {
		txtNom.setText("");
		txtApepater.setText("");
		txtApemater.setText("");
		cmbTipo.setToolTipText("");
		txtUsu.setText("");
		txtCont.setText("");
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
		
		//METODO LISTAR
	 void listar(){
			txtCod.setText(""+ac.cod_Correlativo());
			modelo.setRowCount(0);
			for (int i = 0; i < ac.tamano(); i++) {
				Object fila[] = {
						ac.obtener(i).getCodigoEmp(),
						ac.obtener(i).getNombres(),
						ac.obtener(i).getApellido_paterno(),
						ac.obtener(i).getApellido_materno(),
						ac.obtener(i).tipoEmpleado(),
						ac.obtener(i).getUsuario(),
						ac.obtener(i).getContrasena()
				};
				modelo.addRow(fila);
			}
		}
		//INGRESAR
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
								  		listar();
										
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
		//MODIFICAR
		void modificarEmpleado() {
			try {
			Empleado x = ac.buscar(leerCodigo());
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
										x.setNombres(nombres);
										x.setApellido_paterno(apellido_paterno);
										x.setApellido_materno(apellido_materno);
										x.setTipo(tipo);
										x.setUsuario(usuario);
										x.setContrasena(contrasena);
								  		ac.grabarEmpleado();
								  		txtCod.requestFocus();
								  		listar();
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
			catch (Exception e){
				
			}
		}
		//ELIMINAR
		void eliminarEmpleado() {
			try {
				Empleado x = ac.buscar(leerCodigo());
				if (x != null) {
					ac.eliminar(x);
					ac.grabarEmpleado();
					txtCod.setText("");
					txtNom.setText("");
					txtApepater.setText("");
					txtApemater.setText("");
					cmbTipo.setToolTipText("");
					txtUsu.setText("");
					txtCont.setText("");
					txtCod.requestFocus();
					listar();
				}
				else {
					mensaje("El código " + leerCodigo() + " no existe");
					txtCod.setText("");
					txtCod.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese CÓDIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}	
		}
		//BUSCAR
		void consultarEmpleado() {
			try {
				Empleado x= ac.buscar(leerCodigo());
				if (x != null) {
					txtNom.setText(x.getNombres());
					txtApepater.setText(x.getApellido_paterno());
					txtApemater.setText(x.getApellido_materno());
					cmbTipo.setSelectedIndex(x.getTipo());
					txtUsu.setText(x.getUsuario());
					txtCont.setText(x.getContrasena());
					
				}
				else {
					mensaje("El código " + leerCodigo() + " no existe");
					txtCod.setText("");
					txtCod.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese CÓDIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}


}
