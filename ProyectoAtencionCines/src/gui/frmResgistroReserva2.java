package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Butaca;
import clases.Cine;
import clases.Cliente;
import clases.DetalleReserva;
import clases.Empleado;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import clases.Sala;
import controlador.ArregloButaca;
import controlador.ArregloCine;
import controlador.ArregloCliente;
import controlador.ArregloDetalleReserva;
import controlador.ArregloEmpleado;
import controlador.ArregloFuncion;
import controlador.ArregloPelicula;
import controlador.ArregloReserva;
import controlador.ArregloSala;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.ObjectStreamException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class frmResgistroReserva2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodReserva;
	private JTextField txtCodreserva;
	private JLabel lblCodCliente;
	private JComboBox cmbCliente;
	private JLabel lblEmpleado;
	private JComboBox cmbEmpleado;
	
	private String depart[] = {"Arequipa", "Cusco",  "Lima"};
	private JPanel panel;
	private JLabel lblPelcula;
	private JComboBox cmbPeliculas;
	private JLabel lblHoraFuncin;
	private JLabel lblFechaFuncin;
	private JComboBox cmbHora;
	private JComboBox cmbFecha;
	private JLabel lblCiudad;
	private JComboBox cmbCiudad;
	private JPanel panel_1;
	private JLabel lblTipoEntrada;
	private JLabel lblSala;
	private JLabel lblButaca;
	private JComboBox cmbTipoEntrada;
	private JComboBox cmbSala;
	private JComboBox cmbButaca;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JTable tablaDetalleReserva;
	private JButton btnCancelar;
	private JButton btnGenerarReserva;
	
	private DefaultTableModel modelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmResgistroReserva2 frame = new frmResgistroReserva2();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmResgistroReserva2() {
		setTitle("Registro de Reserva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 747, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodReserva = new JLabel("Cod. Reserva:");
		lblCodReserva.setBounds(10, 11, 87, 14);
		contentPane.add(lblCodReserva);
		
		txtCodreserva = new JTextField();
		txtCodreserva.setBounds(107, 8, 167, 20);
		contentPane.add(txtCodreserva);
		txtCodreserva.setColumns(10);
		
		lblCodCliente = new JLabel("Cliente:");
		lblCodCliente.setBounds(10, 64, 87, 14);
		contentPane.add(lblCodCliente);
		
		cmbCliente = new JComboBox();
		cmbCliente.setBounds(107, 61, 271, 20);
		contentPane.add(cmbCliente);
		
		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(10, 36, 87, 14);
		contentPane.add(lblEmpleado);
		
		cmbEmpleado = new JComboBox();
		cmbEmpleado.setBounds(107, 33, 271, 20);
		contentPane.add(cmbEmpleado);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pel\u00EDcula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 89, 377, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPelcula = new JLabel("Pel\u00EDcula:");
		lblPelcula.setBounds(10, 24, 75, 14);
		panel.add(lblPelcula);
		
		cmbPeliculas = new JComboBox();
		cmbPeliculas.addActionListener(this);
		cmbPeliculas.setBounds(116, 18, 239, 20);
		panel.add(cmbPeliculas);
		
		lblHoraFuncin = new JLabel("Hora Funci\u00F3n:");
		lblHoraFuncin.setBounds(10, 49, 96, 14);
		panel.add(lblHoraFuncin);
		
		lblFechaFuncin = new JLabel("Fecha Funci\u00F3n:");
		lblFechaFuncin.setBounds(10, 74, 96, 14);
		panel.add(lblFechaFuncin);
		
		cmbHora = new JComboBox();
		cmbHora.setBounds(116, 43, 239, 20);
		panel.add(cmbHora);
		
		cmbFecha = new JComboBox();
		cmbFecha.setBounds(116, 68, 239, 20);
		panel.add(cmbFecha);
		
		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 123, 75, 14);
		panel.add(lblCiudad);
		
		cmbCiudad = new JComboBox();
		cmbCiudad.addActionListener(this);
		cmbCiudad.setBounds(95, 120, 239, 20);
		panel.add(cmbCiudad);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Detalle Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(397, 89, 307, 188);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblTipoEntrada = new JLabel("Tipo Entrada:");
		lblTipoEntrada.setBounds(10, 23, 106, 14);
		panel_1.add(lblTipoEntrada);
		
		lblSala = new JLabel("Sala:");
		lblSala.setBounds(10, 51, 106, 14);
		panel_1.add(lblSala);
		
		lblButaca = new JLabel("Butaca:");
		lblButaca.setBounds(10, 76, 106, 14);
		panel_1.add(lblButaca);
		
		cmbTipoEntrada = new JComboBox();
		cmbTipoEntrada.setModel(new DefaultComboBoxModel(new String[] {"General", "Menores de 11 a\u00F1os", "Mayores de 60 a\u00F1os"}));
		cmbTipoEntrada.setBounds(126, 20, 171, 20);
		panel_1.add(cmbTipoEntrada);
		
		cmbSala = new JComboBox();
		cmbSala.addActionListener(this);
		cmbSala.setBounds(126, 48, 171, 20);
		panel_1.add(cmbSala);
		
		cmbButaca = new JComboBox();
		cmbButaca.setBounds(126, 73, 171, 20);
		panel_1.add(cmbButaca);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(120, 154, 89, 23);
		panel_1.add(btnAgregar);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 101, 106, 14);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(126, 98, 171, 20);
		panel_1.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 288, 711, 142);
		contentPane.add(scrollPane);
		
		tablaDetalleReserva = new JTable();
		scrollPane.setViewportView(tablaDetalleReserva);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(632, 454, 89, 23);
		contentPane.add(btnCancelar);
		
		btnGenerarReserva = new JButton("Generar Reserva");
		btnGenerarReserva.addActionListener(this);
		btnGenerarReserva.setBounds(481, 454, 141, 23);
		contentPane.add(btnGenerarReserva);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Reserva");
		modelo.addColumn("Cod. Empleado");
		modelo.addColumn("Cod. Sala");
		modelo.addColumn("Cod. Cliente");
		modelo.addColumn("Título Película");
		modelo.addColumn("Hora Función");
		modelo.addColumn("Fecha Función");
		modelo.addColumn("Tipo Entrada");
		modelo.addColumn("Butaca");
		
		modelo.addColumn("Cod. Butaca");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");		
		
		tablaDetalleReserva.setModel(modelo);
		
		txtCodreserva.setText(""+ar.codigoCorrelativo());
		
		listarEmpleados();
		listarClientes();
		listarPelicula();
		listarCiudades();
	}
	
	//Arreglos
	ArregloReserva ar = new ArregloReserva("Reserva.txt");
	ArregloEmpleado ae = new ArregloEmpleado("Empleado.txt");
	ArregloCliente ac = new ArregloCliente("Cliente.txt");
	ArregloPelicula ap = new ArregloPelicula("Pelicula.txt");
	ArregloFuncion af = new ArregloFuncion("Funcion.txt");
	ArregloCine aCine = new ArregloCine("cine.txt");
	ArregloSala aSala = new ArregloSala("Sala.txt");
	ArregloButaca aBut = new ArregloButaca("Butacas.txt");
	ArregloDetalleReserva aDetRes = new ArregloDetalleReserva();
	int codFuncion;
	//Métodos complementarios
	void listarCiudades(){
		cmbCiudad.removeAllItems();
		Cine c;
		Funcion f;
		int codCine;
		for (int i = 0; i < af.tamaño(); i++) {
			f=af.obtener(i);
			codCine=f.getCodCine();
			if(aCine.buscar(codCine)!=null){
				c=aCine.buscar(codCine);
				cmbCiudad.addItem(c.getCodCine()+"-"+c.getDistrito());
			}
			//c = aCine.obtener(i);
			//cmbCiudad.addItem(c.getCodCine()+"-"+c.getDistrito());
		}
	}
	void listarPelicula(){
		cmbPeliculas.removeAllItems();
		Pelicula p;
		Funcion f;
		int codCine;
		for (int i = 0; i < af.tamaño(); i++) {
			f=af.obtener(i);
			codCine=f.getCodCine();
			if(ap.buscar(codCine)!=null){
				p=ap.buscar(codCine);
				cmbPeliculas.addItem(p.getCodPeli()+"-"+p.getTitDistribucion());
			}
			//p = ap.obtener(i);
			//cmbPeliculas.addItem(p.getCodPeli()+"-"+p.getTitDistribucion());
			
		}
	}
	void listarClientes(){
		cmbCliente.removeAllItems();
		Cliente c;
		for (int i = 0; i < ac.tamanio(); i++) {
			c = ac.obtener(i);
			cmbCliente.addItem(c.getCodCliente()+"-"+c.getNombre());
		}
	}
	void listarEmpleados(){
		cmbEmpleado.removeAllItems();
		Empleado e;
		for (int i = 0; i < ae.tamanio(); i++) {
			e = ae.obtener(i);
			cmbEmpleado.addItem(e.getCodEmpleado()+"-"+e.getNombre());
		}
	}
	//Obteniendo de las componentes
	int obtEstado(){
		return 0;
	}
	String obtHoraReserva(){
		Date hora = new Date();
		return hora.getHours()+":"+hora.getMinutes()+" h";
	}
	String obtFechaReserva(){
		Date fecha = new Date();
		return fecha.getDay()+"/"+fecha.getMonth()+"/"+fecha.getYear();
	}
	int obtCodFuncion(){
		String f = ""+cmbFecha.getSelectedItem();
		f = f.substring(f.indexOf("-")+1, f.length());
		return Integer.parseInt(f);
	}
	int obtCodEmpleado(){
		String e = ""+cmbEmpleado.getSelectedItem();
		e = e.substring(0, e.indexOf("-")); 
		return Integer.parseInt(e);
	}
	int obtCodCliente(){
		String c = ""+cmbCliente.getSelectedItem();
		c = c.substring(0, c.indexOf("-"));
		return Integer.parseInt(c);
	}
	int obtCodReserva(){
		return Integer.parseInt(txtCodreserva.getText());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbSala) {
			actionPerformedCmbSala(arg0);
		}
		if (arg0.getSource() == cmbCiudad) {
			actionPerformedCmbCiudad(arg0);
		}
		if (arg0.getSource() == cmbPeliculas) {
			actionPerformedCmbPeliculas(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnGenerarReserva) {
			actionPerformedBtnGenerarReserva(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		this.dispose();
	}
	protected void actionPerformedBtnGenerarReserva(ActionEvent arg0) {
		int rpta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de guardar la Reserva?",
				"Reserva", JOptionPane.YES_NO_OPTION);
		if(rpta == JOptionPane.YES_OPTION){
			//fichero RESERVA
			int codR = obtCodReserva();
			int codC = obtCodCliente();
			int codE = obtCodEmpleado();
			int codF = obtCodFuncion();
			String fR = obtFechaReserva();
			String hR = obtHoraReserva();
			int estR= obtEstado();
			//Grabando en el fichero
			try{
				Reserva re = new Reserva(codR, codC, codE, codF, fR, hR, estR);
				ar.adicionar(re);
				ar.grabarReserva();
				System.out.print(""+obtCodFuncion());
				
				//Fichero DetalleReserva
				String codBR; //= obtCodButaca();
				//Se jala el código de reserva
				int tipoEntrada; //= 0; //= cmbTipoEntrada.getSelectedIndex();
				int cantEntrada; //= 1; //= Integer.parseInt(txtCantidad.getText());
				double precio; //= 19.5; //= Double.parseDouble(txtPrecio.getText());
				
				//Recorriendo el Jtable
				DetalleReserva dr;
				for (int i = 0; i < modelo.getRowCount(); i++) {
					codBR = ""+modelo.getValueAt(i, 8);
					codBR = codBR.substring(0, codBR.indexOf("-"));
					tipoEntrada = Integer.parseInt(""+modelo.getValueAt(i, 7));
					cantEntrada = Integer.parseInt(""+modelo.getValueAt(i, 10));
					precio = Double.parseDouble(""+modelo.getValueAt(i, 11));
					//COD Reserva
					dr = new DetalleReserva(Integer.parseInt(codBR), codR, tipoEntrada, cantEntrada, precio);
					aDetRes.adicionar(dr);
					aDetRes.grabarDetalleReserva();
					//Cambiando estado de la butaca a Reservada
					aBut.buscar(Integer.parseInt(codBR)).setEstado(0);
					aBut.grabarButaca();
				}
			}catch(Exception e){
				System.out.println("Error +"+e);
			}
		}else{
			this.dispose();
		}
		
	}
	  protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		//Para reserva
		//Falta implementar aquí el reporte hacia la tabla
		int codRes = Integer.parseInt(txtCodreserva.getText());
		String cod =""+ cmbButaca.getSelectedItem();
		cod = cod.substring(0,cod.indexOf("-"));
		Object fila[] = {
				/*obtCodReserva(),
				obtCodCliente(),
				obtCodEmpleado(),
				obtCodFuncion(),
				obtFechaReserva(),
				obtHoraReserva(),
				obtEstado()*/
				obtCodReserva(),
				obtCodEmpleado(),
				cmbSala.getSelectedItem(),
				obtCodCliente(),
				cmbCiudad.getSelectedItem(),
				obtHoraReserva(),
				obtFechaReserva(),
				cmbTipoEntrada.getSelectedIndex(),
				cmbButaca.getSelectedItem(),
				cod,
				1,
				txtPrecio.getText()
				
		};
		modelo.addRow(fila);
	}
	protected void actionPerformedCmbPeliculas(ActionEvent arg0) {
		cmbHora.removeAllItems();
		cmbFecha.removeAllItems();
		String codPeli = ""+cmbPeliculas.getSelectedItem();
		codPeli = codPeli.substring(0, codPeli.indexOf("-"));
		Funcion f;
		for (int i = 0; i < af.tamaño(); i++) {
			f = af.obtener(i);
			if(f.getCodPeli() == Integer.parseInt(codPeli)){
				cmbHora.addItem(f.getHora()+"-"+f.getCodFuncion());
				cmbFecha.addItem(f.getFecha()+"-"+f.getCodFuncion());
				codFuncion = f.getCodFuncion();
			}
		}
	}
	protected void actionPerformedCmbCiudad(ActionEvent arg0) {
		cmbSala.removeAllItems();
		String codCine = ""+cmbCiudad.getSelectedItem();
		codCine = codCine.substring(0, codCine.indexOf("-"));
		Sala s;
		
		System.out.println("Cod del Cine: "+codCine);
		
		for (int i = 0; i < aSala.tamanho(); i++) {
			s = aSala.obtener(i);
			if(s.getCodCine() == Integer.parseInt(codCine)){
				cmbSala.addItem(s.getCodigo()+"-"+s.getNumSala());
			}
//			if(s.getCodCine() == Integer.parseInt(codCine)){
//				System.out.println("Sala "+i+" "+s.getCodigo()+" "+s.getCodCine());
//				cmbSala.addItem(""+s.getCodigo());
//			}
		}
	}
	protected void actionPerformedCmbSala(ActionEvent arg0) {
		cmbButaca.removeAllItems();
		String codSala = ""+cmbSala.getSelectedItem();
		codSala = codSala.substring(0, codSala.indexOf("-"));
		Butaca b;
		for (int i = 0; i < aBut.tamaño(); i++) {
			b = aBut.obtener(i);
			if(b.getCodSala() == Integer.parseInt(codSala)){
			//if(true){
				if(b.getEstado() == 1){
					cmbButaca.addItem(b.getCodButaca()+"-("+b.getNumFila()+","+b.getNumColumna()+")-"+b.estadoButaca());
				}
			}
		}
	}
}
