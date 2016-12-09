package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Vistas.Dialogo;
import clases.Cine;
import clases.Cliente;
import clases.Empleado;
import clases.Funcion;
import clases.Pelicula;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmReserva extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtReserva;
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	private JTextField txtFuncion;
	private JTextField txtFechaReserv;
	private JTextField txtHoraReserv;
	private JComboBox cmbEstado; //el problema estaba aqui nomas te faltaba crear esta variable o como se llame
	private DefaultTableModel m;
	private JScrollPane tblTabla;
	private JTable table;
	private JButton btnBuscar;
	private JButton btnNewButton;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoReserva = new JLabel("C\u00F3digo Reserva:");
		lblCdigoReserva.setBounds(10, 11, 103, 23);
		contentPane.add(lblCdigoReserva);
		
		JLabel lblCdigoCliente = new JLabel("C\u00F3digo Cliente:");
		lblCdigoCliente.setBounds(10, 35, 103, 23);
		contentPane.add(lblCdigoCliente);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo Empleado:");
		lblCdigoEmpleado.setBounds(10, 60, 103, 23);
		contentPane.add(lblCdigoEmpleado);
		
		JLabel lblCdigoFuncion = new JLabel("C\u00F3digo Funci\u00F3n:");
		lblCdigoFuncion.setBounds(10, 84, 103, 23);
		contentPane.add(lblCdigoFuncion);
		
		JLabel lblFechaReserva = new JLabel("Fecha de la Reserva:");
		lblFechaReserva.setBounds(237, 11, 145, 23);
		contentPane.add(lblFechaReserva);
		
		JLabel lblHoraDeReserva = new JLabel("Hora de la Reserva:");
		lblHoraDeReserva.setBounds(237, 35, 145, 23);
		contentPane.add(lblHoraDeReserva);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(237, 62, 145, 18);
		contentPane.add(lblEstado);
		
		txtReserva = new JTextField();
		txtReserva.setText("10001");
		txtReserva.setBounds(124, 12, 103, 20);
		contentPane.add(txtReserva);
		txtReserva.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(124, 36, 78, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(124, 61, 78, 20);
		contentPane.add(txtEmpleado);
		
		txtFuncion = new JTextField();
		txtFuncion.setColumns(10);
		txtFuncion.setBounds(124, 85, 78, 20);
		contentPane.add(txtFuncion);
		
		txtFechaReserv = new JTextField();
		txtFechaReserv.setColumns(10);
		txtFechaReserv.setBounds(392, 12, 125, 20);
		contentPane.add(txtFechaReserv);
		
		txtHoraReserv = new JTextField();
		txtHoraReserv.setColumns(10);
		txtHoraReserv.setBounds(392, 36, 125, 20);
		contentPane.add(txtHoraReserv);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 118, 774, 194);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		JComboBox cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cmbEstado.setBounds(392, 61, 125, 20);
		contentPane.add(cmbEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(527, 11, 114, 23);
		contentPane.add(btnBuscar);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(frmReserva.class.getResource("/img/add2.png")));
		btnNewButton.setBounds(527, 35, 114, 23);
		contentPane.add(btnNewButton);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(527, 60, 114, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(651, 35, 114, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmReserva.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(651, 60, 114, 23);
		contentPane.add(btnSalir);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_1.setBounds(204, 35, 23, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_2.setBounds(204, 60, 23, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_3.setBounds(204, 84, 23, 23);
		contentPane.add(btnNewButton_3);
		
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Reserva");
		m.addColumn("Codigo Cliente");
		m.addColumn("Codigo Empleado");
		m.addColumn("Codigo Funcion");
		m.addColumn("fecha de la Reserva");
		m.addColumn("Hora de la Reserva");
		m.addColumn("Estado");
		table.setModel(m);
		listar();
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton_3) {
			actionPerformedBtnNewButton_3(arg0);
		}
		if (arg0.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(arg0);
		}
		if (arg0.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(arg0);
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
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	
	ArregloReserva ar=new ArregloReserva("Reserva.txt");
	ArregloCliente ab=new ArregloCliente("Cliente.txt");
	ArregloEmpleado ac=new ArregloEmpleado("Empleado.txt");
	ArregloFuncion ad=new ArregloFuncion("Funcion.txt");
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarReserva();
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
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
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
		Dialogo <Cliente> b = new Dialogo <> (ab.getCliente());//listo benyi tu error estaba een esta linea
		b.mostrar();
		txtCliente.setText(b.getSelect());
		if(!txtCliente.getText().trim().equals("")){
			String cod = txtCliente.getText().trim();
			cod = b.getSelect().substring(0,cod.indexOf("-"));
			txtCliente.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent arg0) {
		Dialogo <Empleado> c = new Dialogo <> (ac.getEmp());//en la clase arregloEmpleado tienes que crear los metodos set/get
		c.mostrar();
		txtEmpleado.setText(c.getSelect());
		if(!txtEmpleado.getText().trim().equals("")){
			String cod = txtEmpleado.getText().trim();
			cod = c.getSelect().substring(0,cod.indexOf("-"));
			txtEmpleado.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_3(ActionEvent arg0) {
		Dialogo <Funcion> c = new Dialogo <> (ad.getFu());
		c.mostrar();
		txtFuncion.setText(c.getSelect());
		if(!txtFuncion.getText().trim().equals("")){
			String cod = txtFuncion.getText().trim();
			cod = c.getSelect().substring(0,cod.indexOf("-"));
			txtFuncion.setText(cod);
		}
	}
	
	//Limpieza
	void limpieza(){
		txtCliente.setText("");
		txtEmpleado.setText("");
		txtFuncion.setText("");
		txtHoraReserv.setText("");
		txtFechaReserv.setText("");
		
	}

//METODO LEER
	   int leerCodigoReserva(){
		   return Integer.parseInt(txtReserva.getText().trim());
	   }	
	   	
	   int leerCodigoCliente(){
		   return Integer.parseInt(txtCliente.getText().trim());
	   }	
	   
	   int leerCodigoEmpleado(){
		   return Integer.parseInt(txtEmpleado.getText().trim());
	   }	
	   
	   int leerCodigoFuncion(){
		   return Integer.parseInt(txtFuncion.getText().trim());
	   }
	   int leerEstado(){
		  return cmbEstado.getSelectedIndex();
		}
	   String leerhora_reserva(){
		   return txtHoraReserv.getText().trim();
	   }
	   String leerfecha_reserva(){
		   return txtFechaReserv.getText().trim();
	   }
	   	
		//MENSAJE
	  	void mensaje(String s) {
			JOptionPane.showMessageDialog(this, s);
		}


	  //METODO LISTAR
	   	void listar() {
	   		txtReserva.setText(""+ar.codigoCorrelativo());
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
	  			Reserva x= ar.buscar(leerCodigoReserva());
	  			if (x != null) {
	  			  	txtReserva.setText(x.getCodReserva()+"");
	  			   	txtCliente.setText(x.getCodCliente()+"");
	  			   	txtEmpleado.setText(x.getCodEmpleado()+"");
	  			   	txtFechaReserv.setText(x.getFechaReserva());
	  			   	txtHoraReserv.setText(x.getHoraReserva());
	  			}
	  			else {
	  				mensaje("El código " + leerCodigoReserva() + " no existe");
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
				int codReserva = leerCodigoReserva();
				if(ar.buscar(codReserva)==null){
				int codCliente = leerCodigoCliente();
					try {
						int codEmpleado = leerCodigoEmpleado();
							try{
								int codFuncion = leerCodigoFuncion();
								try{
									int estado = leerEstado();
									try{
										String  fechaReserva = leerfecha_reserva();
										try{
										String horaReserva = leerhora_reserva();
										Reserva nueva = new Reserva( codReserva, codCliente, codEmpleado, codFuncion, estado, fechaReserva,
													 horaReserva);
													 ar.adicionar(nueva);
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
						catch(Exception e){
					}
					}
					catch (Exception e){
						
					}
				}
			else {
			mensaje("El codigo ya existe");			
		}
	}
	//MODIFICAR
		void modificarReserva() {
			try{
			Reserva x = ar.buscar(leerCodigoReserva());
				int codCliente = leerCodigoCliente();
					try{
						int codEmpleado = leerCodigoEmpleado();
							try{
								int codFuncion = leerCodigoCliente();
									try{
										int estado= leerEstado();
											try{
												String  fechareserva = leerfecha_reserva();
												try{
													String horareserva = leerhora_reserva();
													x.setCodCliente(codCliente);
													x.setCodEmpleado(codEmpleado);
													x.setCodFuncion(codFuncion);
													x.setEstado(estado);
													x.setFechaReserva(fechareserva);
													x.setHoraReserva(horareserva);
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
						catch(Exception e){
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
				Reserva x = ar.buscar(leerCodigoReserva());
				if (x != null) {
					ar.eliminar(x);
					ar.grabarReserva();
					txtCliente.setText("");
					txtEmpleado.setText("");
					txtFuncion.setText("");
					txtFechaReserv.setText("");
					txtReserva.setText("");
					txtHoraReserv.setText("");
					
					listar();
				}
				else {
				}
			}
			catch (Exception e) {
			}	
		}
}
