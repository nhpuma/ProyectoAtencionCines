package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Funcion;
import clases.Reserva;
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

public class frmReserva extends JFrame {

	private JPanel contentPane;
	private JTextField txtReserva;
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	private JTextField txtFuncion;
	private JTextField txtFechaReserv;
	private JTextField txtHoraReserv;
	private JTable tblTable;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoReserva = new JLabel("C\u00F3digo Reserva:");
		lblCdigoReserva.setBounds(41, 27, 103, 23);
		contentPane.add(lblCdigoReserva);
		
		JLabel lblCdigoCliente = new JLabel("C\u00F3digo Cliente:");
		lblCdigoCliente.setBounds(41, 51, 103, 23);
		contentPane.add(lblCdigoCliente);
		
		JLabel lblCdigoEmpleado = new JLabel("C\u00F3digo Empleado:");
		lblCdigoEmpleado.setBounds(41, 76, 103, 23);
		contentPane.add(lblCdigoEmpleado);
		
		JLabel lblCdigoFuncion = new JLabel("C\u00F3digo Funci\u00F3n:");
		lblCdigoFuncion.setBounds(41, 100, 103, 23);
		contentPane.add(lblCdigoFuncion);
		
		JLabel lblFechaReserva = new JLabel("Fecha de la Reserva:");
		lblFechaReserva.setBounds(329, 27, 116, 23);
		contentPane.add(lblFechaReserva);
		
		JLabel lblHoraDeReserva = new JLabel("Hora de la Reserva:");
		lblHoraDeReserva.setBounds(329, 51, 116, 23);
		contentPane.add(lblHoraDeReserva);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(329, 78, 116, 18);
		contentPane.add(lblEstado);
		
		txtReserva = new JTextField();
		txtReserva.setText("10001");
		txtReserva.setBounds(155, 28, 103, 20);
		contentPane.add(txtReserva);
		txtReserva.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(155, 52, 103, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setColumns(10);
		txtEmpleado.setBounds(155, 77, 103, 20);
		contentPane.add(txtEmpleado);
		
		txtFuncion = new JTextField();
		txtFuncion.setColumns(10);
		txtFuncion.setBounds(155, 101, 103, 20);
		contentPane.add(txtFuncion);
		
		txtFechaReserv = new JTextField();
		txtFechaReserv.setColumns(10);
		txtFechaReserv.setBounds(473, 28, 103, 20);
		contentPane.add(txtFechaReserv);
		
		txtHoraReserv = new JTextField();
		txtHoraReserv.setColumns(10);
		txtHoraReserv.setBounds(473, 52, 103, 20);
		contentPane.add(txtHoraReserv);
		
		JComboBox cbmEstado = new JComboBox();
		cbmEstado.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Reserva usada", "Reserva cancelada", "Reserva caducada"}));
		cbmEstado.setBounds(473, 76, 103, 23);
		contentPane.add(cbmEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 161, 836, 256);
		contentPane.add(scrollPane);
		
		tblTable = new JTable();
		tblTable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTable);
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Reserva");
		m.addColumn("Codigo Cliente");
		m.addColumn("Codigo Empleado");
		m.addColumn("Codigo Funcion");
		m.addColumn("fecha de la Reserva");
		m.addColumn("Hora de la Reserva");
		m.addColumn("Estado");
		tblTable.setModel(m);
		listar();
		
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIngresar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/add2.png")));
		btnIngresar.setBounds(627, 23, 114, 31);
		contentPane.add(btnIngresar);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(627, 68, 114, 31);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(627, 110, 114, 31);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setIcon(new ImageIcon(frmReserva.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(763, 23, 114, 31);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(frmReserva.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(763, 65, 114, 31);
		contentPane.add(btnSalir);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton.setBounds(268, 51, 32, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		btnNewButton_1.setBounds(268, 76, 32, 23);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(frmReserva.class.getResource("/img/play.png")));
		button.setBounds(268, 100, 32, 23);
		contentPane.add(button);
		
		
	
		
	}
	
	ArregloReserva ae=new ArregloReserva("Reserva.txt");
	
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
			   
			   //no puedo ver mi error , que horror!!!!!
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
			   		txtReserva.setText(""+ae.codigoCorrelativo());
					m.setRowCount(0);
					for (int i=0; i<ae.tamaño(); i++) {
						Object[] fila = { ae.obtener(i).getCodReserva(),
								          ae.obtener(i).getCodCliente(),
								          ae.obtener(i).getCodEmpleado(),
								          ae.obtener(i).getCodFuncion(),
								          ae.obtener(i).getEstado(),
								          ae.obtener(i).getFechaReserva(),
								          ae.obtener(i).getHoraReserva()};
						m.addRow(fila);
					}
				}
	
			    //BUSCAR
			  	void buscarReserva() {
			  		try {
			  			Reserva x= ae.buscar(leerCodigoReserva());
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
				void ingresarFuncion() {
					int codReserva = leerCodigoReserva();
					if(ae.buscar(codReserva)==null){
					int codCliente = leerCodigoCliente();
						try {
							int codEmpleado = leerCodigoEmpleado();
								try{
									int codFuncion = leerCodigoFuncion();
									try{
										String  fechareserva = leerfecha_reserva();
										try{
											String horareserva = leerhora_reserva();
													Reserva nueva = new Reserva(codReserva,  codCliente,  codEmpleado,  codFuncion,  fechareserva,  horareserva);
														 ae.adicionar(nueva);
														  ae.grabarFuncion();;
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
				else {
				mensaje("El codigo ya existe");			
				}
				}
	
	
				
				
				//ELIMINAR
				void eliminarReserva() {
					try {
						Reserva x = ae.buscar(leerCodigoReserva());
						if (x != null) {
							ae.eliminar(x);
							ae.grabarFuncion();
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
