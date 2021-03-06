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
import java.text.DateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class frmCine extends JFrame implements ActionListener {
	DateFormat df = DateFormat.getDateInstance();

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDepartamento;
	private JTextField txtNom;
	private JTextField txtCod;
	private JLabel lblProvincia;
	private JLabel lblDistrito;
	private JLabel lblFechaInicio;
	private JTextField txtDist;
	private JTextField txtProv;
	private JLabel lblTipo;
	private JComboBox cmbTipo;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JDateChooser txtFecha;
	private JComboBox cmbDepartamento;
	//Agregando un modelo
	private DefaultTableModel modelo;
	
	private String depart[] = {"Amazonas", "Ancash", "Apur�mac", "Arequipa", 
	        "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Hu�nuco", 
	        "Ica", "Jun�n", "La Libertad", "Lambayeque", "Lima", "Loreto", 
	        "Madre De Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", 
	        "Tacna", "Tumbes", "Ucayali"};

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
		setTitle("Cine");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 421);
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
		lblDepartamento.setBounds(10, 64, 91, 14);
		contentPane.add(lblDepartamento);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(111, 36, 130, 20);
		contentPane.add(txtNom);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(111, 11, 130, 20);
		contentPane.add(txtCod);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(10, 89, 91, 14);
		contentPane.add(lblProvincia);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(264, 32, 91, 14);
		contentPane.add(lblDistrito);
		
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(264, 57, 91, 14);
		contentPane.add(lblFechaInicio);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(365, 32, 107, 20);
		contentPane.add(txtDist);
		
		txtProv = new JTextField();
		txtProv.setColumns(10);
		txtProv.setBounds(111, 89, 130, 20);
		contentPane.add(txtProv);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(264, 10, 91, 14);
		contentPane.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Prime"}));
		cmbTipo.setBounds(365, 4, 107, 20);
		contentPane.add(cmbTipo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(frmCine.class.getResource("/img/add2.png")));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(492, 4, 118, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(frmCine.class.getResource("/img/cancel2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(492, 352, 118, 23);
		contentPane.add(btnSalir);
		
		JScrollPane tblTabla = new JScrollPane();
		tblTabla.setBounds(0, 120, 620, 220);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		//Creando el modelo en la tabla
		modelo = new DefaultTableModel();
		//Aqu� agregas las columnas para tu tabla
		modelo.addColumn("C�digo");
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
		btnModificar.setBounds(492, 33, 118, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmCine.class.getResource("/img/remove2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(492, 58, 118, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(frmCine.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(10, 352, 107, 23);
		contentPane.add(btnBuscar);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(365, 57, 107, 20);
		contentPane.add(txtFecha);
		
		cmbDepartamento = new JComboBox();
		cmbDepartamento.setBounds(111, 61, 130, 20);
		contentPane.add(cmbDepartamento);
		listar();
		
		listarDepar();
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

	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarCine();
	}
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		adicionarCine();
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
	//  M�todos tipo void (sin par�metros)
   	void limpieza() {
   	
   		txtNom.setText("");
   		//txtDep.setText("");
   		txtProv.setText("");
   		txtDist.setText("");
   		txtFecha.setDateFormatString("");
   	}
	//  M�todos tipo void (con par�metros)
   	void listar(){
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
   	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		

	//ingresar
	void adicionarCine() {
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
									//txtDep.setText("");
									txtProv.setText("");
									txtDist.setText("");
									txtFecha.setDate(null);
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
										txtCod.requestFocus();
										ac.grabarCine();
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
						catch (Exception e) {
						}	
					}
					catch (Exception e) {
					}
				else {
				}
			}
			catch (Exception e) {
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
					//txtDep.setText("");
					txtProv.setText("");
					txtDist.setText("");
					txtFecha.setDateFormatString("");
					cmbTipo.setToolTipText("");
					txtCod.requestFocus();
					listar();
				}
				else {
				}
			}
			catch (Exception e) {
			}	
		}
	//CONSULTAR CINE
		void consultarCine() {
			try {
				Cine x= ac.buscar(leerCodigo());
				if (x != null) {
					txtNom.setText(x.getNombre());
					cmbDepartamento.setSelectedItem(x.getDepartamento());
					//txtDep.setText(x.getDepartamento());
					txtProv.setText(x.getProvincia());
					txtDist.setText(x.getDistrito());
					txtFecha.getDateEditor();
					cmbTipo.setSelectedIndex(x.getTipo());
				}
				else {
					mensaje("El c�digo " + leerCodigo() + " no existe");
					txtCod.setText("");
					txtCod.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese C�DIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}
	//  M�todos que retornan valor sin par�metros
	int leerCodigo() {
		return Integer.parseInt(txtCod.getText().trim());
	}
	String leerNombre() {
		return txtNom.getText().trim();
	}
	String leerDepartamento() {
		//return txtDep.getText().trim();
		return cmbDepartamento.getSelectedItem()+"";
	}
	String leerProvincia() {
		return txtProv.getText().trim();
	}
	String leerDistrito() {
		return txtDist.getText().trim();
	}
	String leerFechaInicio() {
		return df.format(txtFecha.getDate());
	}
	int leerTipo(){
		return cmbTipo.getSelectedIndex();
	}
	
	void listarDepar(){
		cmbDepartamento.removeAllItems();
		for (int i = 0; i < depart.length; i++) {
			cmbDepartamento.addItem(depart[i]);
		}
	}
}
