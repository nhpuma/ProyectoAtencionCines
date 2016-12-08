package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Vistas.Dialogo;
import clases.Cine;
import clases.Empleado;
import clases.Funcion;
import controlador.ArregloCine;
import controlador.ArregloFuncion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmFuncion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtFuncion;
	private JTextField txtCine;
	private JTextField txtSala;
	private JTextField txtPelicula;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnIngresar;
	private DefaultTableModel m;
	private JScrollPane tblTabla;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncion frame = new frmFuncion();
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
	public frmFuncion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDePelicula = new JLabel("C\u00F3digo de pel\u00EDcula:");
		lblCdigoDePelicula.setBounds(235, 34, 113, 14);
		contentPane.add(lblCdigoDePelicula);
		
		JLabel lblCdigoDeCine = new JLabel("C\u00F3digo de cine :");
		lblCdigoDeCine.setBounds(10, 59, 95, 14);
		contentPane.add(lblCdigoDeCine);
		
		JLabel lblCdigoDeSala = new JLabel("C\u00F3digo de  sala:");
		lblCdigoDeSala.setBounds(10, 86, 95, 14);
		contentPane.add(lblCdigoDeSala);
		
		JLabel lblCdigoDeFuncin = new JLabel("C\u00F3digo de funci\u00F3n:");
		lblCdigoDeFuncin.setBounds(10, 34, 95, 14);
		contentPane.add(lblCdigoDeFuncin);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la funci\u00F3n:");
		lblFechaDeLa.setBounds(235, 59, 113, 14);
		contentPane.add(lblFechaDeLa);
		
		JLabel lblHoraDeLa = new JLabel("Hora de la funci\u00F3n:");
		lblHoraDeLa.setBounds(235, 86, 95, 14);
		contentPane.add(lblHoraDeLa);
		
		txtFuncion = new JTextField();
		txtFuncion.setBounds(108, 31, 117, 20);
		contentPane.add(txtFuncion);
		txtFuncion.setColumns(10);
		
		txtCine = new JTextField();
		txtCine.setBounds(108, 56, 86, 20);
		contentPane.add(txtCine);
		txtCine.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setBounds(108, 84, 86, 20);
		contentPane.add(txtSala);
		txtSala.setColumns(10);
		
		txtPelicula = new JTextField();
		txtPelicula.setBounds(342, 31, 86, 20);
		contentPane.add(txtPelicula);
		txtPelicula.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(342, 56, 117, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(342, 83, 117, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/add2.png")));
		btnIngresar.setBounds(501, 11, 113, 33);
		contentPane.add(btnIngresar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(501, 45, 113, 33);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(501, 82, 113, 33);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(624, 11, 101, 33);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(624, 50, 101, 33);
		contentPane.add(btnSalir);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 121, 715, 179);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(198, 55, 27, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(198, 82, 27, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(431, 30, 27, 23);
		contentPane.add(btnNewButton_2);
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Funcion");
		m.addColumn("Codigo Cine");
		m.addColumn("Codigo Sala");
		m.addColumn("Codigo pelicula");
		m.addColumn("fecha funcion");
		m.addColumn("Hora Funcion");
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
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	ArregloFuncion ae=new ArregloFuncion("Funcion.txt");
	ArregloCine ac = new ArregloCine("cine.txt");
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		ingresarFuncion();
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarFuncion();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarFuncion();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarFuncion();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
	dispose();
	}
	//REFERENCIAS
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		Dialogo <Cine> d = new Dialogo <> (ac.getCine());
		d.mostrar();
		txtCine.setText(d.getSelect());
		if(!txtCine.getText().trim().equals("")){
			String cod = txtCine.getText().trim();
			cod = d.getSelect().substring(0,cod.indexOf("-"));
			txtCine.setText(cod);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent arg0) {
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent arg0) {
	}
	
	//Limpieza
		void limpieza(){
			txtCine.setText("");
			txtSala.setText("");
			txtPelicula.setText("");
			txtFecha.setText("");
			txtHora.setText("");
			
		}
		
		//METODO LEER
		   int leerCodigoFuncion(){
			   return Integer.parseInt(txtFuncion.getText().trim());
		   }	
		   	
		   int leerCodigoSala(){
			   return Integer.parseInt(txtSala.getText().trim());
		   }	
		   
		   int leerCodigoPelicula(){
			   return Integer.parseInt(txtPelicula.getText().trim());
		   }	
		   
		   int leerCodigoCine(){
			   return Integer.parseInt(txtCine.getText().trim());
		   }	
		   
		   String leerhora(){
			   return txtHora.getText().trim();
		   }
		   String leerfecha(){
			   return txtFecha.getText().trim();
		   }
		   	
			//MENSAJE
		  	void mensaje(String s) {
				JOptionPane.showMessageDialog(this, s);
			}
		
	  	//METODO LISTAR
	   	void listar() {
	   		txtFuncion.setText(""+ae.codigoCorrelativo());
			m.setRowCount(0);
			for (int i=0; i<ae.tamaño(); i++) {
				Object[] fila = { ae.obtener(i).getCodFuncion(),
						          ae.obtener(i).getCodCine(),
						          ae.obtener(i).getCodSala(),
						          ae.obtener(i).getCodPeli(),
						          ae.obtener(i).getFecha(),
						          ae.obtener(i).getHora()};
				m.addRow(fila);
			}
		}
	  	
	  //BUSCAR
	  	void buscarFuncion() {
	  		try {
	  			Funcion x= ae.buscar(leerCodigoFuncion());
	  			if (x != null) {
	  			  	txtCine.setText(x.getCodCine()+"");
	  			   	txtSala.setText(x.getCodSala()+"");
	  			   	txtPelicula.setText(x.getCodPeli()+"");
	  			   	txtFecha.setText(x.getFecha());
	  			   	txtHora.setText(x.getHora());
	  			}
	  			else {
	  				mensaje("El código " + leerCodigoFuncion() + " no existe");
	  				txtFuncion.setText("");
	  				txtFuncion.requestFocus();
	  			}
	  		}
	  		catch (Exception e) {
	  			mensaje("ingrese CÓDIGO correcto");
	  			txtFuncion.setText("");
	  			txtFuncion.requestFocus();
	  		}
	  	}
	  	
	  //INGRESAR
		void ingresarFuncion() {
			int codFuncion = leerCodigoFuncion();
			if(ae.buscar(codFuncion)==null){
			int codCine = leerCodigoCine();
				try {
					int codSala = leerCodigoSala();
						try{
							int codPeli = leerCodigoPelicula();
							try{
								String  fecha = leerfecha();
								try{
									String hora = leerhora();
											Funcion nueva = new Funcion(codFuncion,  codCine,  codSala,  codPeli,  fecha,  hora);
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
	//MODIFICAR
		void modificarFuncion() {
			try{
			Funcion x = ae.buscar(leerCodigoFuncion());
			int codCine = leerCodigoCine();
				try {
					int codSala = leerCodigoSala();
						try{
							int codPeli = leerCodigoPelicula();
							try{
								String  fecha = leerfecha();
								try{
									String hora = leerhora();
										x.setCodCine(codCine);
										x.setCodSala(codSala);
										x.setCodPeli(codPeli);
										x.setFecha(fecha);
										x.setHora(hora);
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
		catch (Exception e) {	
		}
	}
	//ELIMINAR
			void eliminarFuncion() {
				try {
					Funcion x = ae.buscar(leerCodigoFuncion());
					if (x != null) {
						ae.eliminar(x);
						ae.grabarFuncion();
						txtCine.setText("");
						txtFecha.setText("");
						txtFuncion.setText("");
						txtHora.setText("");
						txtPelicula.setText("");
						txtSala.setText("");
						
						listar();
					}
					else {
					}
				}
				catch (Exception e) {
				}	
			}

}
