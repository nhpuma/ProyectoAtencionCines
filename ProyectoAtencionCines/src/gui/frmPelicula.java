package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloPelicula;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmPelicula extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblTituloDistribucion;
	private JLabel lblTituloOriginal;
	private JLabel lblNewLabel;
	private JTextField txtCodpelicula;
	private JTextField txtTitdistribucion;
	private JTextField txtTitoriginal;
	private JTextField txtFechaestreno;
	private JLabel lblTipoProyeccion;
	private JLabel lblGnero;
	private JLabel lblPaisOrigen;
	private JLabel lblSinopsis;
	private JComboBox cmbTipoproyeccion;
	private JTextField txtGenero;
	private JTextField txtPaisorigen;
	private JTextField txtSinopsis;
	private JLabel lblDuracion;
	private JLabel lblTipoCensura;
	private JLabel lblEstadoProyeccion;
	private JLabel lblRecaudacion;
	private JTextField txtDuracion;
	private JComboBox cmbTipocensura;
	private JComboBox cmbEstadoproyeccion;
	private JTextField txtRecaudacion;
	private JButton btnBuscar;
	private JButton btnIngresa;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
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
					frmPelicula frame = new frmPelicula();
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
	public frmPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1097, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 112, 14);
		contentPane.add(lblCodigo);
		
		lblTituloDistribucion = new JLabel("Titulo Distribucion:");
		lblTituloDistribucion.setBounds(10, 36, 112, 14);
		contentPane.add(lblTituloDistribucion);
		
		lblTituloOriginal = new JLabel("Titulo Original:");
		lblTituloOriginal.setBounds(10, 61, 112, 14);
		contentPane.add(lblTituloOriginal);
		
		lblNewLabel = new JLabel("Fecha Estreno:");
		lblNewLabel.setBounds(10, 86, 112, 14);
		contentPane.add(lblNewLabel);
		
		txtCodpelicula = new JTextField();
		txtCodpelicula.setBounds(132, 8, 123, 20);
		contentPane.add(txtCodpelicula);
		txtCodpelicula.setColumns(10);
		
		txtTitdistribucion = new JTextField();
		txtTitdistribucion.setColumns(10);
		txtTitdistribucion.setBounds(132, 33, 123, 20);
		contentPane.add(txtTitdistribucion);
		
		txtTitoriginal = new JTextField();
		txtTitoriginal.setColumns(10);
		txtTitoriginal.setBounds(132, 58, 123, 20);
		contentPane.add(txtTitoriginal);
		
		txtFechaestreno = new JTextField();
		txtFechaestreno.setColumns(10);
		txtFechaestreno.setBounds(132, 83, 123, 20);
		contentPane.add(txtFechaestreno);
		
		lblTipoProyeccion = new JLabel("Tipo Proyeccion:");
		lblTipoProyeccion.setBounds(280, 11, 112, 14);
		contentPane.add(lblTipoProyeccion);
		
		lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(280, 36, 112, 14);
		contentPane.add(lblGnero);
		
		lblPaisOrigen = new JLabel("Pais Origen:");
		lblPaisOrigen.setBounds(280, 64, 112, 14);
		contentPane.add(lblPaisOrigen);
		
		lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setBounds(280, 89, 112, 14);
		contentPane.add(lblSinopsis);
		
		cmbTipoproyeccion = new JComboBox();
		cmbTipoproyeccion.setModel(new DefaultComboBoxModel(new String[] {"Estreno", "Fuera de Estreno"}));
		cmbTipoproyeccion.setBounds(402, 11, 123, 20);
		contentPane.add(cmbTipoproyeccion);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(402, 36, 123, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtPaisorigen = new JTextField();
		txtPaisorigen.setColumns(10);
		txtPaisorigen.setBounds(402, 61, 123, 20);
		contentPane.add(txtPaisorigen);
		
		txtSinopsis = new JTextField();
		txtSinopsis.setColumns(10);
		txtSinopsis.setBounds(402, 83, 123, 20);
		contentPane.add(txtSinopsis);
		
		lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(547, 14, 112, 14);
		contentPane.add(lblDuracion);
		
		lblTipoCensura = new JLabel("Tipo Censura:");
		lblTipoCensura.setBounds(547, 39, 112, 14);
		contentPane.add(lblTipoCensura);
		
		lblEstadoProyeccion = new JLabel("Estado Proyeccion:");
		lblEstadoProyeccion.setBounds(547, 67, 112, 14);
		contentPane.add(lblEstadoProyeccion);
		
		lblRecaudacion = new JLabel("Recaudacion:");
		lblRecaudacion.setBounds(547, 92, 112, 14);
		contentPane.add(lblRecaudacion);
		
		txtDuracion = new JTextField();
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(669, 11, 123, 20);
		contentPane.add(txtDuracion);
		
		cmbTipocensura = new JComboBox();
		cmbTipocensura.setModel(new DefaultComboBoxModel(new String[] {"Apta para todos", "Mayores de 14 a\u00F1os", "Mayores de 18 a\u00F1os"}));
		cmbTipocensura.setBounds(669, 36, 123, 20);
		contentPane.add(cmbTipocensura);
		
		cmbEstadoproyeccion = new JComboBox();
		cmbEstadoproyeccion.setModel(new DefaultComboBoxModel(new String[] {"En cartelera", "Fuera de Cartelera"}));
		cmbEstadoproyeccion.setBounds(669, 64, 123, 20);
		contentPane.add(cmbEstadoproyeccion);
		
		txtRecaudacion = new JTextField();
		txtRecaudacion.setBounds(669, 89, 123, 20);
		contentPane.add(txtRecaudacion);
		txtRecaudacion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(frmPelicula.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(818, 32, 120, 23);
		contentPane.add(btnBuscar);
		
		btnIngresa = new JButton("Ingresar");
		btnIngresa.addActionListener(this);
		btnIngresa.setIcon(new ImageIcon(frmPelicula.class.getResource("/img/add2.png")));
		btnIngresa.setBounds(818, 61, 120, 23);
		contentPane.add(btnIngresa);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(frmPelicula.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(951, 32, 120, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(frmPelicula.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(951, 57, 120, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmPelicula.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(951, 82, 120, 23);
		contentPane.add(btnSalir);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 127, 1061, 327);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("código");
		modelo.addColumn("Titulo Distribucion");
		modelo.addColumn("Titulo Original");
		modelo.addColumn("Fecha Estreno");
		modelo.addColumn("Tipo Proyeccion");
		modelo.addColumn("Género");
		modelo.addColumn("Pais Origen");
		modelo.addColumn("Sinopsis");
		modelo.addColumn("Duracion");
		modelo.addColumn("Tipo Censura");
		modelo.addColumn("Estado Proyeccion");
		modelo.addColumn("Recaudacion");
		table.setModel(modelo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresa) {
			actionPerformedBtnIngresa(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}
	ArregloPelicula ap = new ArregloPelicula("Pelicula.txt");
	
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnIngresa(ActionEvent arg0) {
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	
//  Métodos tipo void (sin parámetros)
   	void limpieza() {
	   	txtCodpelicula.setText("");
	   	txtTitdistribucion.setText("");
	   	txtTitoriginal.setText("");
	   	txtFechaestreno.setText("");
	   	txtGenero.setText("");
	   	txtPaisorigen.setText("");
	   	txtSinopsis.setText("");
	   	txtDuracion.setText("");
		txtRecaudacion.setText("");
   	}
   	
   	//METODO LISTAR
   	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamanio(); i++) {
			Object[] fila = { ap.obtener(i).getCodPeli(),
					          ap.obtener(i).getTitDistribucion(),
					          ap.obtener(i).getTitOriginal(),
					          ap.obtener(i).getFechaEstreno(),
					          ap.obtener(i).tipo_Proyeccion(),
					          ap.obtener(i).getGenero(),
					          ap.obtener(i).getPaisOrigen(),
					          ap.obtener(i).getSinopsis(),
					          ap.obtener(i).getDuracion(),
					          ap.obtener(i).Censura(),
					          ap.obtener(i).estado_proyeccion(),
					          ap.obtener(i).getRecaudacion() };
			modelo.addRow(fila);
		}
	}
   	
}














