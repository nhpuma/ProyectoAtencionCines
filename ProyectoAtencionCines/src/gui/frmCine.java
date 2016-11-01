package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cine;
import controlador.ArregloCine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class frmCine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDepartamento;
	private JTextField txtDep;
	private JTextField txtNom;
	private JTextField txtCod;
	private JLabel lblProvincia;
	private JLabel lblDistrito;
	private JLabel lblFechaInicio;
	private JTextField txtFecha;
	private JTextField txtDist;
	private JTextField txtProv;
	private JLabel lblTipo;
	private JComboBox cmbTipo;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JTable table;
	//Agregando un modelo
	private DefaultTableModel modelo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCine frame = new frmCine();
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
	public frmCine() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 91, 14);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 91, 14);
		contentPane.add(lblNombre);
		
		lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(10, 61, 91, 14);
		contentPane.add(lblDepartamento);
		
		txtDep = new JTextField();
		txtDep.setBounds(111, 61, 86, 20);
		contentPane.add(txtDep);
		txtDep.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(111, 36, 86, 20);
		contentPane.add(txtNom);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(111, 11, 86, 20);
		contentPane.add(txtCod);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(10, 89, 91, 14);
		contentPane.add(lblProvincia);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(10, 114, 91, 14);
		contentPane.add(lblDistrito);
		
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(10, 139, 91, 14);
		contentPane.add(lblFechaInicio);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(111, 139, 86, 20);
		contentPane.add(txtFecha);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(111, 114, 86, 20);
		contentPane.add(txtDist);
		
		txtProv = new JTextField();
		txtProv.setColumns(10);
		txtProv.setBounds(111, 89, 86, 20);
		contentPane.add(txtProv);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(225, 14, 40, 14);
		contentPane.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Prime"}));
		cmbTipo.setBounds(269, 11, 86, 20);
		contentPane.add(cmbTipo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(frmCine.class.getResource("/img/add2.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(375, 7, 118, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(frmCine.class.getResource("/img/cancel2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(503, 57, 107, 23);
		contentPane.add(btnSalir);
		
		JScrollPane tblTabla = new JScrollPane();
		tblTabla.setBounds(0, 170, 610, 207);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		//Creando el modelo en la tabla
		modelo = new DefaultTableModel();
		//Aquí agregas las columnas para tu tabla
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Departamento");
		modelo.addColumn("Provincia");
		modelo.addColumn("Distrito");
		modelo.addColumn("Fecha Inicio");
		modelo.addColumn("Tipo");
		table.setModel(modelo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(frmCine.class.getResource("/img/edit2.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(375, 36, 118, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmCine.class.getResource("/img/remove2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(375, 61, 118, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(frmCine.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(237, 85, 118, 23);
		contentPane.add(btnBuscar);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	ArregloCine ac=new ArregloCine("cine.txt");
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarCine();
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		adicionarPersona();
		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarCine();
		limpieza();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		
		int rpta = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
		if(rpta==JOptionPane.YES_OPTION){
			eliminarCine();
		}else{
			
		}
	
		limpieza();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//  Métodos tipo void (sin parámetros)
   	void limpieza() {
   	
   		txtNom.setText("");
   		txtDep.setText("");
   		txtProv.setText("");
   		txtDist.setText("");
   		txtFecha.setText("");
   	}
	//  Métodos tipo void (con parámetros)
	public void listar(){
		txtCod.setText(""+ac.codigoCorrelativo());
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Object fila[] = {
					ac.obtener(i).getCodCine(),
					ac.obtener(i).getNombre(),
					ac.obtener(i).getDepartamento(),
					ac.obtener(i).getProvincia(),
					ac.obtener(i).getDistrito(),
					ac.obtener(i).getFechaInicio(),
					ac.obtener(i).tipoCine()
			};
			modelo.addRow(fila);
		}
	}
	public  void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		

	//ingresar
	void adicionarPersona() {
		int codigo = leerCodigo();
		if(ac.buscar(codigo)==null){
		String nombre = leerNombre();
		if (nombre.length() > 0)
			try {
				String departamento = leerDepartamento();
				try {
					try{
						String provincia = leerProvincia();
						try{
							String distrito = leerDistrito();
							try{
								String fechaInicio = leerFechaInicio();
								try{
									int tipo = leerTipo();
									Cine nueva = new Cine(codigo, nombre, departamento, provincia,distrito,fechaInicio,tipo);
							  		ac.adicionar(nueva);
							  		ac.grabarCine();
									listar();
									txtCod.setText("" + ac.codigoCorrelativo());
									txtNom.setText("");
									txtDep.setText("");
									txtProv.setText("");
									txtDist.setText("");
									txtFecha.setText("");
									txtNom.requestFocus();
								}
								catch(Exception e){
									
								}
							}
								catch(Exception e){
									
								}
						}
								catch(Exception e){
									
								}
					}
								catch(Exception e){
									
								}
				
				}
				catch (Exception e) {
				
						
				}
			}
			catch (Exception e) {
				
			
			}
		else {
			mensaje("ingrese NOMBRE ");
		}
		}
		else {
			mensaje("El codigo ya existe");
			limpieza();
		}
	}
	
	//METODO MODIFICAR
		void modificarCine() {
			try {
				Cine x = ac.buscar(leerCodigo());
				String nombre = leerNombre();
				if (nombre.length() > 0)
					try {
						String departamento = leerDepartamento();
						try {
							String provincia = leerProvincia();
							try{
								String distrito = leerDistrito();
								try{
									String fechaInicio = leerFechaInicio();
									try{
										int tipo = leerTipo();
										x.setNombre(nombre);
										x.setDepartamento(departamento);
										x.setProvincia(provincia);
										x.setDistrito(distrito);
										x.setFechaInicio(fechaInicio);
										x.setTipo(tipo);
										ac.grabarCine();
										listar();
										txtCod.requestFocus();
									}
									catch (Exception e){
									 mensaje("ingrese tipo correcta");
										cmbTipo.requestFocus();
									}
								}
									catch (Exception e){
										mensaje("ingrese FECHA correcta");
										txtFecha.setText("");
										txtFecha.requestFocus();
									}
								}
									catch (Exception e){
										mensaje("ingrese DISTRITO correcta");
										txtDist.setText("");
										txtDist.requestFocus();
									}
								}
						catch (Exception e) {
							mensaje("ingrese PROVINCIA correcta");
							txtProv.setText("");
							txtProv.requestFocus();
						}	
					}
					catch (Exception e) {
						mensaje("ingrese DEPARTAMENTO correcto");
						txtDep.setText("");
						txtDep.requestFocus();
					}
				else {
					mensaje("ingrese NOMBRE correcto");
					txtNom.setText("");
					txtNom.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese CÓDIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}
		//METODO ELIMINAR
		void eliminarCine() {
			try {
				Cine x = ac.buscar(leerCodigo());
				if (x != null) {
					ac.eliminar(x);
					ac.grabarCine();
					txtCod.setText("");
					txtNom.setText("");
					txtDep.setText("");
					txtProv.setText("");
					txtDist.setText("");
					txtFecha.setText("");
					cmbTipo.setToolTipText("");
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
	//CONSULTAR CINE
		void consultarCine() {
			try {
				Cine x= ac.buscar(leerCodigo());
				if (x != null) {
					txtNom.setText(x.getNombre());
					txtDep.setText(x.getDepartamento());
					txtProv.setText(x.getProvincia());
					txtDist.setText(x.getDistrito());
					txtFecha.setText(x.getFechaInicio());
					cmbTipo.setSelectedIndex(x.getTipo());
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
	//  Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Integer.parseInt(txtCod.getText().trim());
	}
	String leerNombre() {
		return txtNom.getText().trim();
	}
	String leerDepartamento() {
		return txtDep.getText().trim();
	}
	String leerProvincia() {
		return txtProv.getText().trim();
	}
	String leerDistrito() {
		return txtDist.getText().trim();
	}
	String leerFechaInicio() {
		return txtFecha.getText().trim();
	}
	int leerTipo(){
		return cmbTipo.getSelectedIndex();
	}

	
}
