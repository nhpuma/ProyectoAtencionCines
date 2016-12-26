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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frmEmpleado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtCodempleado;
	private JTextField txtNombre;
	private JTextField txtApepater;
	private JTextField txtApemater;
	private JLabel lblTipoEmpleado;
	private JComboBox cmbTipo;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNewButton_2;
	private JScrollPane tblTabla;
	private JTable table;
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
		setTitle("Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCdigo.setBounds(10, 11, 100, 14);
		contentPane.add(lblCdigo);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombres.setBounds(10, 36, 100, 14);
		contentPane.add(lblNombres);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoPaterno.setBounds(10, 61, 100, 14);
		contentPane.add(lblApellidoPaterno);
		
		lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidoMaterno.setBounds(10, 86, 100, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtCodempleado = new JTextField();
		txtCodempleado.setBounds(120, 8, 123, 20);
		contentPane.add(txtCodempleado);
		txtCodempleado.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(120, 33, 123, 20);
		contentPane.add(txtNombre);
		
		txtApepater = new JTextField();
		txtApepater.setColumns(10);
		txtApepater.setBounds(120, 58, 123, 20);
		contentPane.add(txtApepater);
		
		txtApemater = new JTextField();
		txtApemater.setColumns(10);
		txtApemater.setBounds(120, 83, 123, 20);
		contentPane.add(txtApemater);
		
		lblTipoEmpleado = new JLabel("Tipo Empleado:");
		lblTipoEmpleado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoEmpleado.setBounds(9, 114, 100, 14);
		contentPane.add(lblTipoEmpleado);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {" Administrador", " Supervisor", " Cajero"}));
		cmbTipo.setBounds(120, 111, 123, 20);
		contentPane.add(cmbTipo);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(285, 14, 100, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(285, 39, 100, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(396, 11, 107, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(396, 36, 107, 20);
		contentPane.add(txtContrasena);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Century751 No2 BT", Font.BOLD, 11));
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/buscar.png")));
		btnNewButton.setBounds(10, 362, 107, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.setFont(new Font("Century751 No2 BT", Font.BOLD, 11));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/add2.png")));
		btnNewButton_1.setBounds(551, 32, 107, 23);
		contentPane.add(btnNewButton_1);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Century751 No2 BT", Font.BOLD, 11));
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(551, 63, 107, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Century751 No2 BT", Font.BOLD, 11));
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(551, 92, 107, 23);
		contentPane.add(btnEliminar);
		
		btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFont(new Font("Century751 No2 BT", Font.BOLD, 11));
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setIcon(new ImageIcon(frmEmpleado.class.getResource("/img/cancel2.png")));
		btnNewButton_2.setBounds(551, 362, 107, 23);
		contentPane.add(btnNewButton_2);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 152, 648, 203);
		contentPane.add(tblTabla);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		tblTabla.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellido Paterno");
		modelo.addColumn("Apellido Materno");
		modelo.addColumn("Tipo Empleado");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		table.setModel(modelo);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	ArregloEmpleado ae = new ArregloEmpleado("Empleado.txt");
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {

		buscarEmpleado();
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
		ingresarEmpleado();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
			modificarEmpleado();
			limpieza();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarEmpleado();
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent arg0) {
		dispose();
	}
	//Limpieza
	void limpieza(){
		txtNombre.setText("");
		txtApepater.setText("");
		txtApemater.setText("");
		txtUsuario.setText("");
		txtContrasena.setText("");
	}
	
  	//METODO LISTAR
   	void listar() {
   		txtCodempleado.setText(""+ae.codigoCorrelativo());
		modelo.setRowCount(0);
		for (int i=0; i<ae.tamanio(); i++) {
			Object[] fila = { ae.obtener(i).getCodEmpleado(),
					          ae.obtener(i).getNombre(),
					          ae.obtener(i).getApePater(),
					          ae.obtener(i).getApeMater(),
					          ae.obtener(i).tipo_Empleado(),
					          ae.obtener(i).getUsuario(),
					          ae.obtener(i).getContraseña()};
			modelo.addRow(fila);
		}
   		Empleado e;
   		int codemp;
   		for(int j=0; j<ae.tamanio(); j++){
   			e=ae.obtener(j);
   			codemp=e.getCodEmpleado();
   			if(ae.buscar(codemp)!=null){
   				e=ae.buscar(codemp);
   				txtUsuario.setText(e.Usuario()+leerCodigo()+"");
   			}
   		}
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
  	//METODOS LEER
  	int leerCodigo(){
  		return Integer.parseInt(txtCodempleado.getText().trim());
  	}
  	String leerNombre(){
  		return txtNombre.getText().trim();
  	}
  	String leerPaterno(){
  		return txtApepater.getText().trim();
  	}
  	String leerMaterno(){
  		return txtApemater.getText().trim();
  	}
  	int  leerTipo(){
  		return cmbTipo.getSelectedIndex();
  	}
  	String leerUsuario(){
  		return txtUsuario.getText().trim();
  	}
  	String leerContrasena(){
  		return txtContrasena.getText().trim();
  	}
  	
  //BUSCAR
  	void buscarEmpleado() {
  		try {
  			Empleado x= ae.buscar(leerCodigo());
  			if (x != null) {
  			  	txtNombre.setText(x.getNombre());
  			   	txtApepater.setText(x.getApePater());
  			   	txtApemater.setText(x.getApeMater());
  			   	cmbTipo.setSelectedIndex(x.getTipoEmpleado());
  			   	txtUsuario.setText(x.getUsuario());
  			   	txtContrasena.setText(x.getContraseña());
  			}
  			else {
  				mensaje("El código " + leerCodigo() + " no existe");
  				txtCodempleado.setText("");
  				txtCodempleado.requestFocus();
  			}
  		}
  		catch (Exception e) {
  			mensaje("ingrese CÓDIGO correcto");
  			txtCodempleado.setText("");
  			txtCodempleado.requestFocus();
  		}
  	}
  	
	//INGRESAR
	void ingresarEmpleado() {
		int codEmpleado = leerCodigo();
		if(ae.buscar(codEmpleado)==null){
		String nombre = leerNombre();
		if (nombre.length() > 0)
			try {
				String apePater = leerPaterno();
					try{
						String apeMater = leerMaterno();
						try{
							int tipoEmpleado = leerTipo();
							try{
								String usuario = leerUsuario();
								try{
									 String contraseña = leerContrasena();
										Empleado nueva = new Empleado(codEmpleado,nombre, apePater, apeMater, tipoEmpleado, usuario,
										contraseña);
											 ae.adicionar(nueva);
											  ae.grabarEmpleado();
													listar();
												  	limpieza();
													}
													catch (Exception e){
													}
												}
												catch (Exception e){
												}
											}
											catch (Exception e){
											}
										 }
										 catch (Exception e){ 
										 }
								}	
								catch(Exception e){
								}
		else {
		mensaje("ingrese NOMBRE ");
		}
		}
	else {
	mensaje("El codigo ya existe");			
	}
	}
	//MODIFICAR
	
	void modificarEmpleado() {
		try{
			Empleado x = ae.buscar(leerCodigo());
		String nombre = leerNombre();
		if (nombre.length() > 0)
			try {
				String apePater = leerPaterno();
					try{
						String apeMater = leerMaterno();
						try{
							int tipoEmpleado = leerTipo();
							try{
								String usuario = leerUsuario();
								try{
									 String contraseña = leerContrasena();
									 		x.setNombre(nombre);
									 		x.setApePater(apePater);
									 		x.setApeMater(apeMater);
									 		x.setTipoEmpleado(tipoEmpleado);
									 		x.setUsuario(usuario);
									 		x.setContraseña(contraseña);
											  ae.grabarEmpleado();
													listar();
													}
													catch (Exception e){
													}
												}
												catch (Exception e){
												}
											}
										catch (Exception e){
										}
									 }
								  catch (Exception e){ 
								 }
							}	
						catch(Exception e){
					}
		else {
		mensaje("ingrese NOMBRE ");
		}
		}
	catch (Exception e) {	
	}
}
	
	//ELIMINAR
		void eliminarEmpleado() {
			try {
				Empleado x = ae.buscar(leerCodigo());
				if (x != null) {
					ae.eliminar(x);
					ae.grabarEmpleado();
					txtCodempleado.setText("");
					txtNombre.setText("");
					txtApepater.setText("");
					txtApemater.setText("");
					cmbTipo.setToolTipText("");
					txtUsuario.setText("");
					txtContrasena.setText("");
					txtCodempleado.requestFocus();
					listar();
				}
				else {
				}
			}
			catch (Exception e) {
			}	
		}
	
}












