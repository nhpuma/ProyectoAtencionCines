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
import clases.Reserva;
import clases.Sala;
import controlador.ArregloCliente;
import controlador.ArregloEmpleado;
import controlador.ArregloFuncion;
import controlador.ArregloReserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmReserva extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigoReserva;
	private JLabel lblCodigoCliente;
	private JLabel lblCodigoEmpleado;
	private JLabel lblCodigoFuncion;
	private JLabel lblNewLabel;
	private JTextField txtcodReserva;
	private JTextField txtcodCliente;
	private JTextField txtcodEmpleado;
	private JTextField txtcodFuncion;
	private JTextField txtFecha;
	private JLabel lblHoraReserva;
	private JTextField txtHora;
	private JLabel lblEstado;
	private JComboBox cmbEstado;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnBuscar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane tblTabla;
	private JTable table;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoReserva = new JLabel("Codigo Reserva:");
		lblCodigoReserva.setBounds(10, 11, 108, 14);
		contentPane.add(lblCodigoReserva);
		
		lblCodigoCliente = new JLabel("Codigo Cliente:");
		lblCodigoCliente.setBounds(10, 33, 108, 14);
		contentPane.add(lblCodigoCliente);
		
		lblCodigoEmpleado = new JLabel("Codigo Empleado:");
		lblCodigoEmpleado.setBounds(10, 58, 108, 14);
		contentPane.add(lblCodigoEmpleado);
		
		lblCodigoFuncion = new JLabel("Codigo Funcion:");
		lblCodigoFuncion.setBounds(10, 83, 108, 14);
		contentPane.add(lblCodigoFuncion);
		
		lblNewLabel = new JLabel("Fecha Reserva:");
		lblNewLabel.setBounds(243, 14, 108, 14);
		contentPane.add(lblNewLabel);
		
		txtcodReserva = new JTextField();
		txtcodReserva.setBounds(116, 8, 108, 20);
		contentPane.add(txtcodReserva);
		txtcodReserva.setColumns(10);
		
		txtcodCliente = new JTextField();
		txtcodCliente.setColumns(10);
		txtcodCliente.setBounds(116, 30, 86, 20);
		contentPane.add(txtcodCliente);
		
		txtcodEmpleado = new JTextField();
		txtcodEmpleado.setColumns(10);
		txtcodEmpleado.setBounds(116, 55, 86, 20);
		contentPane.add(txtcodEmpleado);
		
		txtcodFuncion = new JTextField();
		txtcodFuncion.setColumns(10);
		txtcodFuncion.setBounds(116, 80, 86, 20);
		contentPane.add(txtcodFuncion);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(361, 8, 129, 20);
		contentPane.add(txtFecha);
		
		lblHoraReserva = new JLabel("Hora Reserva:");
		lblHoraReserva.setBounds(243, 36, 108, 14);
		contentPane.add(lblHoraReserva);
		
		txtHora = new JTextField();
		txtHora.setBounds(361, 33, 129, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(243, 58, 108, 14);
		contentPane.add(lblEstado);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cmbEstado.setBounds(361, 58, 129, 20);
		contentPane.add(cmbEstado);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton.setBounds(204, 29, 20, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_1.setBounds(204, 54, 20, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_2.setBounds(204, 79, 20, 23);
		contentPane.add(btnNewButton_2);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(361, 83, 129, 23);
		contentPane.add(btnBuscar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/add2.png")));
		btnIngresar.setBounds(525, 5, 108, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(525, 27, 108, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(525, 52, 108, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmReserva.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(525, 77, 108, 23);
		contentPane.add(btnSalir);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 115, 623, 135);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
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
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	ArregloReserva ar = new ArregloReserva("Reserva.txt");
	ArregloCliente ac = new ArregloCliente("Cliente.txt");
	ArregloEmpleado ae = new ArregloEmpleado("Empleado.txt");
	ArregloFuncion af = new ArregloFuncion("Funcion.txt");
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarReserva();
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
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
	//REFERENCIA
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		Dialogo <Cliente> c = new Dialogo <> (ac.getCliente());
		c.mostrar();
		txtcodCliente.setText(c.getSelect());
		if(!txtcodCliente.getText().trim().equals("")){
			String cod = txtcodCliente.getText().trim();
			cod = c.getSelect().substring(0,cod.indexOf("-"));
			txtcodCliente.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
		Dialogo <Empleado> e = new Dialogo <> (ae.getEmp());
		e.mostrar();
		txtcodEmpleado.setText(e.getSelect());
		if(!txtcodEmpleado.getText().trim().equals("")){
			String cod = txtcodEmpleado.getText().trim();
			cod = e.getSelect().substring(0,cod.indexOf("-"));
			txtcodEmpleado.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent arg0) {
		Dialogo <Funcion> f = new Dialogo <> (af.getFu());
		f.mostrar();
		txtcodFuncion.setText(f.getSelect());
		if(!txtcodFuncion.getText().trim().equals("")){
			String cod = txtcodFuncion.getText().trim();
			cod = f.getSelect().substring(0,cod.indexOf("-"));
			txtcodFuncion.setText(cod);
		}
	}
	
	//LIMPIEZA
	void limpieza(){
		txtcodCliente.setText("");
		txtcodEmpleado.setText("");
		txtcodFuncion.setText("");
		txtFecha.setText("");
		txtHora.setText("");
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
  	//METODOS LEER
  	int leercodReserva(){
  		return Integer.parseInt(txtcodReserva.getText().trim());
  	}
  	int leercodCliente(){
  		return Integer.parseInt(txtcodCliente.getText().trim());
  	}
  	int leercodEmpleado(){
  		return Integer.parseInt(txtcodEmpleado.getText().trim());
  	}
  	int leercodFuncion(){
  		return Integer.parseInt(txtcodFuncion.getText().trim());
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
   		txtcodReserva.setText(ar.codigoCorrelativo()+"");
		m.setRowCount(0);
		for (int i=0; i<ar.tamaño(); i++) {
			Object[] fila = { ar.obtener(i).getCodReserva(),
					          ar.obtener(i).getCodCliente(),
					          ar.obtener(i).getCodEmpleado(),
					          ar.obtener(i).getCodFuncion(),
					          ar.obtener(i).getFechaReserva(),
					          ar.obtener(i).getHoraReserva(),
					          ar.obtener(i).estado_Reserva()};
			m.addRow(fila);
		}
	}
  //BUSCAR
  	void buscarReserva() {
  		try {
  			Reserva x = ar.buscar(leercodReserva());
  			if (x != null) {
  			  	txtcodCliente.setText(x.getCodCliente()+"");
  			   	txtcodEmpleado.setText(x.getCodEmpleado()+"");
  			   	txtcodFuncion.setText(x.getCodFuncion()+"");
  			   	txtFecha.setText(x.getFechaReserva());
  			   	txtHora.setText(x.getHoraReserva());
  			}
  			else {
  				mensaje("El código " + leercodReserva() + " no existe");
  				txtcodReserva.setText("");
  				txtcodReserva.requestFocus();
  			}
  		}
  		catch (Exception e) {
  			mensaje("ingrese CÓDIGO correcto");
  			txtcodReserva.setText("");
  			txtcodReserva.requestFocus();
  		}
  	}
  	 //INGRESAR
	void ingresarReserva() {
		int codReserva = leercodReserva();
		if(ar.buscar(codReserva)==null){
		int codCliente = leercodCliente();
			try {
				int codEmpleado = leercodEmpleado();
					try{
						int codFuncion = leercodFuncion();
						try{
							String  fechaReserva = leerFecha();
							try{
								String horaReserva = leerHora();
								try{
									int estado = leerEstado();
										Reserva nueva = new Reserva( codReserva,  codCliente,  codEmpleado,  codFuncion,  estado,  fechaReserva,
												 horaReserva);
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
				Reserva x = ar.buscar(leercodReserva());
				int codCliente = leercodCliente();
					try {
						int codEmpleado = leercodEmpleado();
							try{
								int codFuncion = leercodFuncion();
								try{
									String  fechaReserva = leerFecha();
									try{
										String horaReserva = leerHora();
										try{
											int estado = leerEstado();
												x.setCodCliente(codCliente);
												x.setCodEmpleado(codEmpleado);
												x.setCodFuncion(codFuncion);
												x.setFechaReserva(fechaReserva);
												x.setHoraReserva(horaReserva);
												x.setEstado(estado);
												ar.grabarReserva();;
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
		Reserva x = ar.buscar(leercodReserva());
			if (x != null) {
				ar.eliminar(x);
				ar.grabarReserva();
				txtcodCliente.setText("");
				txtcodEmpleado.setText("");
				txtcodFuncion.setText("");
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
