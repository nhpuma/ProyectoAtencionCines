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

public class frmIngresoCine extends JFrame implements ActionListener {

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
					frmIngresoCine frame = new frmIngresoCine();
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
	public frmIngresoCine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 36, 46, 14);
		contentPane.add(lblNombre);
		
		lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(10, 61, 79, 14);
		contentPane.add(lblDepartamento);
		
		txtDep = new JTextField();
		txtDep.setBounds(93, 58, 86, 20);
		contentPane.add(txtDep);
		txtDep.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(93, 33, 86, 20);
		contentPane.add(txtNom);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setColumns(10);
		txtCod.setBounds(93, 8, 86, 20);
		contentPane.add(txtCod);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(202, 11, 58, 14);
		contentPane.add(lblProvincia);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(202, 36, 46, 14);
		contentPane.add(lblDistrito);
		
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(202, 61, 68, 14);
		contentPane.add(lblFechaInicio);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(267, 58, 86, 20);
		contentPane.add(txtFecha);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(267, 33, 86, 20);
		contentPane.add(txtDist);
		
		txtProv = new JTextField();
		txtProv.setColumns(10);
		txtProv.setBounds(267, 8, 86, 20);
		contentPane.add(txtProv);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(363, 11, 46, 14);
		contentPane.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Prime"}));
		cmbTipo.setBounds(392, 8, 86, 20);
		contentPane.add(cmbTipo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(521, 7, 89, 23);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(521, 52, 89, 23);
		contentPane.add(btnSalir);
		
		JScrollPane tblTabla = new JScrollPane();
		tblTabla.setBounds(0, 81, 610, 209);
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
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	ArregloCine ac=new ArregloCine("cine.txt");
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {
		adicionarPersona();
	}
				
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//  M�todos tipo void (sin par�metros)
   	void limpieza() {
   		txtCod.setText("");
   		txtNom.setText("");
   		txtDep.setText("");
   		txtProv.setText("");
   		txtDist.setText("");
   		txtFecha.setText("");
   	}
	//  M�todos tipo void (con par�metros)
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

	
	void adicionarPersona() {
		int codigo = leerCodigo();
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
	//  M�todos que retornan valor sin par�metros
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
