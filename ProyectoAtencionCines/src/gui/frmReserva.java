package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Vistas.Dialogo;
import clases.Cliente;
import clases.Empleado;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import controlador.ArregloCliente;
import controlador.ArregloEmpleado;
import controlador.ArregloFuncion;
import controlador.ArregloReserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class frmReserva extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigoReserva;
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoEmpleado;
	private JLabel lblCodigoFuncion;
	private JTextField txtReserva;
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	private JTextField txtFuncion;
	private JLabel lblFechaReserva;
	private JLabel lblHoraReserva;
	private JLabel lblEstado;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JComboBox cmbEstado;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane tblTabla;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private DefaultTableModel m;

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
		setTitle("Reserva\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoReserva = new JLabel("Codigo Reserva:");
		lblCodigoReserva.setBounds(10, 11, 100, 14);
		contentPane.add(lblCodigoReserva);
		
		lblCodigoCliente = new JLabel("Codigo Cliente:");
		lblCodigoCliente.setBounds(10, 36, 100, 14);
		contentPane.add(lblCodigoCliente);
		
		lblCodigoEmpleado = new JLabel("Codigo Empleado:");
		lblCodigoEmpleado.setBounds(10, 61, 110, 14);
		contentPane.add(lblCodigoEmpleado);
		
		lblCodigoFuncion = new JLabel("Codigo Funcion:");
		lblCodigoFuncion.setBounds(10, 86, 100, 14);
		contentPane.add(lblCodigoFuncion);
		
		txtReserva = new JTextField();
		txtReserva.setBounds(120, 8, 110, 20);
		contentPane.add(txtReserva);
		txtReserva.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(120, 33, 86, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(120, 58, 86, 20);
		contentPane.add(txtEmpleado);
		
		txtFuncion = new JTextField();
		txtFuncion.setColumns(10);
		txtFuncion.setBounds(120, 83, 86, 20);
		contentPane.add(txtFuncion);
		
		lblFechaReserva = new JLabel("Fecha Reserva:");
		lblFechaReserva.setBounds(240, 11, 122, 14);
		contentPane.add(lblFechaReserva);
		
		lblHoraReserva = new JLabel("Hora Reserva:");
		lblHoraReserva.setBounds(240, 36, 122, 14);
		contentPane.add(lblHoraReserva);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(240, 61, 122, 14);
		contentPane.add(lblEstado);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(372, 8, 122, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(372, 33, 122, 20);
		contentPane.add(txtHora);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cmbEstado.setBounds(372, 61, 122, 20);
		contentPane.add(cmbEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/buscar.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(372, 86, 122, 23);
		contentPane.add(btnBuscar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/add2.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(504, 7, 122, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/edit2.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(504, 32, 122, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/remove2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(504, 57, 122, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(frmReserva.class.getResource("/img/cancel2.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBounds(504, 82, 122, 23);
		contentPane.add(btnSalir);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 113, 621, 137);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(209, 32, 21, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(209, 57, 21, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(209, 82, 21, 23);
		contentPane.add(btnNewButton_2);
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Reserva");
		m.addColumn("Codigo Cliente");
		m.addColumn("Codigo Empleado");
		m.addColumn("Codigo Funcion");
		m.addColumn("Fecha Reserva");
		m.addColumn("Hora Reserva");
		m.addColumn("Estado");
		table.setModel(m);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(arg0);
		}
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	ArregloReserva ar = new ArregloReserva("Reserva.txt");
	ArregloCliente ac = new ArregloCliente("Cliente.txt");
	ArregloEmpleado ap = new ArregloEmpleado("Empleado.txt");
	ArregloFuncion af = new ArregloFuncion("Funcion.txt");
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarReserva();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		ingresarReserva();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarReserva();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarReserva();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	//REFERENCIAS
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		Dialogo <Cliente> c = new Dialogo <> (ac.getCliente());
		c.mostrar();
		txtCliente.setText(c.getSelect());
		if(!txtCliente.getText().trim().equals("")){
			String cod = txtCliente.getText().trim();
			cod = c.getSelect().substring(0,cod.indexOf("-"));
			txtCliente.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
		Dialogo <Empleado> e = new Dialogo <> (ap.getEmp());
		e.mostrar();
		txtEmpleado.setText(e.getSelect());
		if(!txtEmpleado.getText().trim().equals("")){
			String cod = txtEmpleado.getText().trim();
			cod = e.getSelect().substring(0,cod.indexOf("-"));
			txtEmpleado.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent arg0) {
		Dialogo <Funcion> f = new Dialogo <> (af.getFu());
		f.mostrar();
		txtFuncion.setText(f.getSelect());
		if(!txtFuncion.getText().trim().equals("")){
			String cod = txtFuncion.getText().trim();
			cod = f.getSelect().substring(0,cod.indexOf("-"));
			txtFuncion.setText(cod);
		}
	}
	//LIEMPIEZA
	void limpieza(){
		txtCliente.setText("");
		txtEmpleado.setText("");
		txtFuncion.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
  	//METODOS LEER
  	int leerReserva(){
  		return Integer.parseInt(txtReserva.getText().trim());
  	}
  	int leerCliente(){
  		return Integer.parseInt(txtCliente.getText().trim());
  	}
  	int leerEmpleado(){
  		return Integer.parseInt(txtEmpleado.getText().trim());
  	}
  	int leerFuncion(){
  		return Integer.parseInt(txtFuncion.getText().trim());
  	}
  	String leerFecha(){
  		return txtFecha.getText().trim();
  	}
  	String leerHora(){
  		return txtHora.getText().trim();
  	}
  	int leerEstado(){
  		return cmbEstado.getSelectedIndex();
  	}
	
  	//METODO LISTAR
   	void listar() {
   		txtReserva.setText(ar.codigoCorrelativo()+"");
		m.setRowCount(0);
		for (int i=0; i<ar.tamaño(); i++) {
			Object[] fila = { ar.obtener(i).getCodReserva(),
					          ar.obtener(i).getCodCliente(),
					          ar.obtener(i).getCodEmpleado(),
					          ar.obtener(i).getCodiFuncion(),
					          ar.obtener(i).getFechaReserva(),
					          ar.obtener(i).getHoraReserva(),
					          ar.obtener(i).estadoReserva()};
			m.addRow(fila);
		}
	}
	  //BUSCAR
  	void buscarReserva() {
  		try {
  			Reserva x= ar.buscar(leerReserva());
  			if (x != null) {
  			  	txtCliente.setText(x.getCodCliente()+"");
  			   	txtEmpleado.setText(x.getCodEmpleado()+"");
  			   	txtFuncion.setText(x.getCodiFuncion()+"");
  			   	txtFecha.setText(x.getFechaReserva());
  			   	txtHora.setText(x.getHoraReserva());
  			}
  			else {
  				mensaje("El código " + leerReserva() + " no existe");
  				txtReserva.setText("");
  				txtReserva.requestFocus();
  			}
  		}
  		catch (Exception e) {
  			mensaje("ingrese CÓDIGO correcto");
  			txtReserva.setText("");
  			txtReserva.requestFocus();
  		}
  	}
	  //INGRESAR
		void ingresarReserva() {
			int codReserva = leerReserva();
			if(ar.buscar(codReserva)==null){
			int codCliente = leerCliente();
				try {
					int codEmpleado = leerEmpleado();
						try{
							int codiFuncion = leerFuncion();
							try{
								String  fechaReserva = leerFecha();
								try{
									String horaReserva = leerHora();
									try{
										int estado = leerEstado();
									Reserva nueva = new Reserva(codReserva,  codCliente,  codEmpleado,  codiFuncion,  fechaReserva,
													 horaReserva,  estado);
												 ar.adicionar(nueva);
												  ar.grabarReserva();
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
			}
		else {
		mensaje("El codigo ya existe");			
		}
	}
		//MODIFICAR
		void modificarReserva() {
			try{
			Reserva x = ar.buscar(leerReserva());
			int codCliente = leerCliente();
			try {
				int codEmpleado = leerEmpleado();
					try{
						int codiFuncion = leerFuncion();
						try{
							String  fechaReserva = leerFecha();
							try{
								String horaReserva = leerHora();
								try{
									int estado = leerEstado();
											x.setCodCliente(codCliente);
											x.setCodEmpleado(codEmpleado);
											x.setCodiFuncion(codiFuncion);
											x.setFechaReserva(fechaReserva);
											x.setHoraReserva(horaReserva);
											x.setEstado(estado);
											  ar.grabarReserva();
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
			}
		catch (Exception e) {	
		}
	}
		//ELIMINAR
		void eliminarReserva() {
			try {
				Reserva x = ar.buscar(leerReserva());
				if (x != null) {
					ar.eliminar(x);
					ar.grabarReserva();
					txtCliente.setText("");
					txtEmpleado.setText("");
					txtFuncion.setText("");
					txtFecha.setText("");
					txtHora.setText("");
					cmbEstado.setToolTipText("");
					listar();
				}
				else {
				}
			}
			catch (Exception e) {
			}	
		}
}
