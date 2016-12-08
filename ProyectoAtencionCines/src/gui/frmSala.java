package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Vistas.Dialogo;
import clases.Cine;
import clases.Sala;
import controlador.ArregloCine;
import controlador.ArregloSala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSala extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCdigoSala;
	private JLabel lblCdigoCine;
	private JLabel lblNmeroSala;
	private JLabel lblNmeroFila;
	private JLabel lblNmeroButacas;
	private JTextField txtCodSala;
	private JTextField txtCodCine;
	private JTextField txtNumSala;
	private JTextField txtNumFila;
	private JTextField txtNumButaca;
	private JButton btnBuscar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnSalir;
	private JScrollPane tblTabla;
	private JTable table;
	private DefaultTableModel m;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSala frame = new frmSala();
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
	public frmSala() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigoSala = new JLabel("C\u00F3digo Sala:");
		lblCdigoSala.setBounds(10, 11, 76, 14);
		contentPane.add(lblCdigoSala);
		
		lblCdigoCine = new JLabel("C\u00F3digo Cine:");
		lblCdigoCine.setBounds(10, 36, 76, 14);
		contentPane.add(lblCdigoCine);
		
		lblNmeroSala = new JLabel("N\u00FAmero Sala:");
		lblNmeroSala.setBounds(10, 64, 83, 14);
		contentPane.add(lblNmeroSala);
		
		lblNmeroFila = new JLabel("N\u00FAmero Fila:");
		lblNmeroFila.setBounds(10, 95, 93, 14);
		contentPane.add(lblNmeroFila);
		
		lblNmeroButacas = new JLabel("N\u00FAmero Butacas:");
		lblNmeroButacas.setBounds(187, 11, 104, 14);
		contentPane.add(lblNmeroButacas);
		
		txtCodSala = new JTextField();
		txtCodSala.setBounds(96, 8, 86, 20);
		contentPane.add(txtCodSala);
		txtCodSala.setColumns(10);
		
		txtCodCine = new JTextField();
		txtCodCine.setColumns(10);
		txtCodCine.setBounds(96, 33, 64, 20);
		contentPane.add(txtCodCine);
		
		txtNumSala = new JTextField();
		txtNumSala.setColumns(10);
		txtNumSala.setBounds(96, 61, 86, 20);
		contentPane.add(txtNumSala);
		
		txtNumFila = new JTextField();
		txtNumFila.setColumns(10);
		txtNumFila.setBounds(96, 92, 86, 20);
		contentPane.add(txtNumFila);
		
		txtNumButaca = new JTextField();
		txtNumButaca.setColumns(10);
		txtNumButaca.setBounds(289, 8, 86, 20);
		contentPane.add(txtNumButaca);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmSala.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(289, 32, 113, 23);
		contentPane.add(btnBuscar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(frmSala.class.getResource("/img/add2.png")));
		btnIngresar.setBounds(289, 60, 113, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmSala.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(441, 7, 113, 23);
		contentPane.add(btnModificar);
		
		btnSalir = new JButton("Eliminar");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmSala.class.getResource("/img/remove2.png")));
		btnSalir.setBounds(441, 32, 113, 23);
		contentPane.add(btnSalir);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 120, 587, 165);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmSala.class.getResource("/img/play.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(162, 32, 21, 23);
		contentPane.add(btnNewButton);
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Sala");
		m.addColumn("Codigo Cine");
		m.addColumn("Numero Sala");
		m.addColumn("Numero Fila");
		m.addColumn("Numero Butaca");
		table.setModel(m);
		
		btnSalir_1 = new JButton("Salir");
		btnSalir_1.addActionListener(this);
		btnSalir_1.setIcon(new ImageIcon(frmSala.class.getResource("/img/cancel2.png")));
		btnSalir_1.setBounds(441, 60, 113, 23);
		contentPane.add(btnSalir_1);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir_1) {
			actionPerformedBtnSalir_1(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
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
	ArregloSala as = new ArregloSala("Sala.txt");
	ArregloCine ac = new ArregloCine("cine.txt");
	private JButton btnSalir_1;
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		buscarSala();
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		ingresarSala();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificarSala();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		eliminarSala();
	}
	protected void actionPerformedBtnSalir_1(ActionEvent arg0) {
		dispose();
	}
	//REFERENCIA
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		Dialogo <Cine> d = new Dialogo <> (ac.getCine());
		d.mostrar();
		txtCodCine.setText(d.getSelect());
		if(!txtCodCine.getText().trim().equals("")){
			String cod = txtCodCine.getText().trim();
			cod = d.getSelect().substring(0,cod.indexOf("-"));
			txtCodCine.setText(cod);
		}
	}
	
	//LIMPIEZA
	void limpieza(){
		txtCodCine.setText("");
		txtNumSala.setText("");
		txtNumFila.setText("");
		txtNumButaca.setText("");
	}
	//MENSAJE
  	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//METODOSS LEER
	int leerCodSala(){
		return Integer.parseInt(txtCodSala.getText().trim());
	}
	int leerCodCine(){
		return Integer.parseInt(txtCodCine.getText().trim());
	}
	int leerNumSala(){
		return Integer.parseInt(txtNumSala.getText().trim());
	}
	int leerNumFila(){
		return Integer.parseInt(txtNumFila.getText().trim());
	}
	int leerNumButaca(){
		return Integer.parseInt(txtNumButaca.getText().trim());
	}
  	//METODO LISTAR
   	void listar() {
   		txtCodSala.setText(""+as.codigoCorrelativo());
		m.setRowCount(0);
		for (int i=0; i<as.tamanho(); i++) {
			Object[] fila = { as.obtener(i).getCodigo(),
					          as.obtener(i).getCodCine(),
					          as.obtener(i).getNumSala(),
					          as.obtener(i).getNumFila(),
					          as.obtener(i).getNumButaca()};
			m.addRow(fila);
		}
	}
  //BUSCAR
  	void buscarSala() {
  		try {
  			Sala x= as.buscar(leerCodSala());
  			if (x != null) {
  			  	txtCodCine.setText(x.getCodCine()+"");
  			   	txtNumSala.setText(x.getNumSala()+"");
  			   	txtNumFila.setText(x.getNumFila()+"");
  			   	txtNumButaca.setText(x.getNumButaca()+"");
  			}
  			else {
  				mensaje("El código " + leerCodSala() + " no existe");
  				txtCodSala.setText("");
  				txtCodSala.requestFocus();
  			}
  		}
  		catch (Exception e) {
  			mensaje("ingrese CÓDIGO correcto");
  			txtCodSala.setText("");
  			txtCodSala.requestFocus();
  		}
  	}
  //INGRESAR
  		void ingresarSala() {
  			int codigo = leerCodSala();
  			if(as.buscar(codigo)==null){
  			int codCine = leerCodCine();
  				try {
  					int numSala = leerNumSala();
  						try{
  							int numFila = leerNumFila();
  							try{
  								int  numButaca = leerNumButaca();
  									Sala nueva = new Sala(codigo,  codCine,  numSala,  numFila,  numButaca);
  										as.adicionar(nueva);
  										as.grabarSala();;
  										listar();
  										limpieza();
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
  			void modificarSala() {
  				try{
  				Sala x = as.buscar(leerCodSala());
  				int codCine = leerCodCine();
  				try {
  					int numSala = leerNumSala();
  						try{
  							int numFila = leerNumFila();
  							try{
  								int  numButaca = leerNumButaca();
  											x.setCodCine(codCine);
  											x.setNumSala(numSala);
  											x.setNumFila(numFila);
  											x.setNumButaca(numButaca);
  												as.grabarSala();;
  												listar();
  												limpieza();
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
			void eliminarSala() {
				try {
					Sala x = as.buscar(leerCodSala());
					if (x != null) {
						as.eliminar(x);
						as.grabarSala();
						txtCodCine.setText("");
						txtNumSala.setText("");
						txtNumFila.setText("");
						txtNumButaca.setText("");
						listar();
					}
					else {
					}
				}
				catch (Exception e) {
				}	
			}
  
}











