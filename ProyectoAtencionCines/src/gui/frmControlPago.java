package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Vistas.Dialogo;
import clases.Cine;
import clases.Cliente;
import clases.DetalleReserva;
import clases.Empleado;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import controlador.ArregloButaca;
import controlador.ArregloCine;
import controlador.ArregloCliente;
import controlador.ArregloDetalleReserva;
import controlador.ArregloFuncion;
import controlador.ArregloPelicula;
import controlador.ArregloReserva;
import controlador.ArregloSala;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class frmControlPago extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigoDeReserva;
	private JTextField txtcodReserva;
	private JButton btnImprimir;
	private JTextArea txtS;
	private JPanel panel;
	private JScrollPane tblTabla;
	private JTable table;
	private JLabel lblSubtotal;
	private JLabel lblIgv;
	private JLabel lblTotal;
	private JTextField txtsubTotal;
	private JTextField txtIGV;
	private JTextField txtTotal;
	private DefaultTableModel m;
	private JButton btnSalir;
	private JButton btnNewButton;
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmControlPago frame = new frmControlPago();
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
	public frmControlPago() {
		setTitle("Control de Pago");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoDeReserva = new JLabel("Codigo de Reserva:");
		lblCodigoDeReserva.setBounds(10, 11, 138, 14);
		contentPane.add(lblCodigoDeReserva);
		
		txtcodReserva = new JTextField();
		txtcodReserva.setBounds(158, 8, 86, 20);
		contentPane.add(txtcodReserva);
		txtcodReserva.setColumns(10);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/Imprimir.png")));
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(354, 7, 111, 23);
		contentPane.add(btnImprimir);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 43, 499, 159);
		contentPane.add(txtS);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 213, 499, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 27, 489, 111);
		panel.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setBounds(228, 149, 69, 14);
		panel.add(lblSubtotal);
		
		lblIgv = new JLabel("IGV:");
		lblIgv.setBounds(228, 171, 46, 14);
		panel.add(lblIgv);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(228, 196, 46, 14);
		panel.add(lblTotal);
		
		txtsubTotal = new JTextField();
		txtsubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtsubTotal.setBounds(403, 143, 86, 20);
		panel.add(txtsubTotal);
		txtsubTotal.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIGV.setColumns(10);
		txtIGV.setBounds(403, 168, 86, 20);
		panel.add(txtIGV);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setColumns(10);
		txtTotal.setBounds(403, 193, 86, 20);
		panel.add(txtTotal);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(420, 469, 89, 23);
		contentPane.add(btnSalir);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/mas.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(254, 7, 23, 23);
		contentPane.add(btnNewButton);
		
		m = new DefaultTableModel();
		m.addColumn("Butaca");
		m.addColumn("Cantidad");
		m.addColumn("Tipo Entrada");
		m.addColumn("Precio Unit");
		m.addColumn("Importe");
		table.setModel(m);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/pagar.png")));
		btnPagar.addActionListener(this);
		btnPagar.setBounds(314, 469, 96, 23);
		contentPane.add(btnPagar);


	}	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnPagar) {
			actionPerformedBtnPagar(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
	}
	//Instancias a las ArrayList
	ArregloFuncion af = new ArregloFuncion("Funcion.txt");
	ArregloCine ac = new ArregloCine("cine.txt");
	ArregloCliente aCli = new ArregloCliente("Cliente.txt");
	ArregloDetalleReserva aDR = new ArregloDetalleReserva();
	ArregloPelicula ap = new ArregloPelicula("Pelicula.txt");
	ArregloSala as = new ArregloSala("Sala.txt");
	ArregloButaca ab = new ArregloButaca("Butacas.txt");
	
	ArregloReserva ar = new ArregloReserva("Reserva.txt");
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		Dialogo <Reserva> r = new Dialogo <> (ar.getRe());
		r.mostrar();
		txtcodReserva.setText(r.getSelect());
		if(!txtcodReserva.getText().trim().equals("")){
			String cod = txtcodReserva.getText().trim();
			cod = r.getSelect().substring(0,cod.indexOf("-"));
			txtcodReserva.setText(cod);
		}
	}

	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		//Buscando la reserva
		String codR = txtcodReserva.getText().trim();
		if(!codR.equals("")){
			Reserva r = ar.buscar(Integer.parseInt(codR));
			if(r != null){
				int codFuncion = r.getCodiFuncion();
				//Buscando la función
				Funcion f = af.buscar(codFuncion);
				if(f != null){
					int codCine = f.getCodCine();
					//Busncado el Cine
					Cine c = ac.buscar(codCine);
					if(c != null){
						txtS.setText("");
						imprimir("Nombre Cine\t\t: "+c.getNombre());
						imprimir("Cod. Empleado\t\t: "+r.getCodEmpleado());
						imprimir("Cod. Cliente\t\t: "+r.getCodCliente());
						//Buscando Cliente
						Cliente cli = aCli.buscar(r.getCodCliente());
						imprimir("Nombre Cliente\t\t: "+cli.getNombre());
						imprimir("Apellidos Cliente\t: "+cli.getApepat()+" "+cli.getApemat());
						imprimir("Cod.Sala\t\t: "+f.getCodSala());
						//Buscando Pelìcula
						int codPeli = f.getCodPeli();
						Pelicula p = ap.buscar(codPeli); 
						imprimir("Película\t\t: "+p.getTitDistribucion());
						imprimir("Genero Película\t: "+p.GeneroPelicula());
						listarDetalleReserva(Integer.parseInt(codR));
						
					}//Fin if Cine
				}//Fin if Función
			}else{
				mensaje("No se encuentra la reserva");
			}
		}else{
			mensaje("Ingrese el Código de Reserva");
			txtcodReserva.requestFocus();
		}
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	//IMPRIMIR
	void imprimir() {
		imprimir("");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listarDetalleReserva(int codRes){
		m.setRowCount(0);
		DetalleReserva dr;
		double sum = 0;
		for (int i = 0; i < aDR.tamanho(); i++) {
			dr = aDR.obtener(i);
			if(dr.getCodReserva() == codRes){
				Object fila [] = {
					dr.getCodButaca(),
					dr.getCantidad(),
					dr.detalleTipoEntrada(),
					dr.getPrecio(),
					dr.getCantidad()*dr.getPrecio()					
				};
				m.addRow(fila);
				sum = sum + (dr.getCantidad()*dr.getPrecio());
			}//Fin IF
		}//Fin FOR
		
		txtsubTotal.setText(""+redondear(sum, 2));
		//Cálculo del IGV
		double igv = sum*0.18;
		txtIGV.setText(""+redondear(igv, 2));		
		//Cálculo del subtotal + igv
		double total = sum+igv;
		txtTotal.setText(""+redondear(total, 2));
	}
	
	BigDecimal redondear(double numero, int digitos){
		String val = numero+"";
		BigDecimal big = new BigDecimal(val);
		big = big.setScale(digitos, RoundingMode.HALF_UP);
		return big;
	}
	//Función que compara fechas
	boolean compararFechaFuncion(String fechaFuncion, String fechaActual){
		boolean fun = false;
		try {
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaDateF = formateador.parse(fechaFuncion);
			Date fechaDateA = formateador.parse(fechaActual);
			
			if(fechaDateF.before(fechaDateA)){
				//mensaje("Ya caducó su Reserva");
				fun = false;
			}else{
				fun = true;
			}
		}
		catch (Exception e) {
			fun = false;
			System.out.println("Error!! "+e);
		}		
		return fun;
	}
	protected void actionPerformedBtnPagar(ActionEvent arg0) {
		//Verificando si está en la fecha correcta
		String codRes = txtcodReserva.getText().trim();
		if(codRes.equals("")){
			mensaje("Ingrese el Código de la Reserva");
		}else{
			Reserva r = ar.buscar(Integer.parseInt(codRes));
			if(r != null){
				int codFuncion = r.getCodiFuncion();
				//Buscando la función
				Funcion f = af.buscar(codFuncion);
				String fechaFuncion = f.getFecha();
				Date d = new Date();
				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
				String fechaActual = formateador.format(d);
				if(compararFechaFuncion(fechaFuncion, fechaActual)){
					mensaje("Pago de la reserva procesada");
					r.setEstado(1);
					ar.grabarReserva();
					dispose();
				}else{
					mensaje("Se Reserva Caducó");
				}
			}else{
				mensaje("No se encontró la Reserva");
			}
		}
		
	}
}
