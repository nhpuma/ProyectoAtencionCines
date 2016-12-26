package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cliente;
import clases.Empleado;
import clases.Funcion;
import clases.Pelicula;
import clases.Reserva;
import controlador.ArregloCliente;
import controlador.ArregloEmpleado;
import controlador.ArregloFuncion;
import controlador.ArregloPelicula;
import controlador.ArregloReserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Reporte extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTipo;
	private JComboBox cmbTipoReporte;
	private JPanel panel_1;
	private JLabel lblDesde;
	private JComboBox <String> cmbDesdedia;
	private JComboBox <String> cmbDesdemes;
	private JComboBox <String> cmbDesdeaño;
	private JComboBox <String> cmbHastadia;
	private JComboBox <String> cmbHastames;
	private JComboBox <String> cmbHastaaño;
	private JLabel lblHasta;
	private JTextArea txtS;
	private JLabel lblEmpleado;
	private JComboBox cmbEmpleado;
	private JLabel lblCliente;
	private JComboBox cmbCliente;
	private JScrollPane tblTabla;
	private JTable table;
	private DefaultTableModel m,me;
	private JButton btnProcesar;
	private JButton btnSalir;
	private JScrollPane tblTablaE;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
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
	public Reporte() {
		setTitle("Reporte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tipo Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 228, 117);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 24, 46, 14);
		panel.add(lblTipo);
		
		cmbTipoReporte = new JComboBox();
		cmbTipoReporte.addItemListener(this);
		cmbTipoReporte.addActionListener(this);
		cmbTipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Pelicula m\u00E1s Taquillera", "Listado de Reservas", "Reservas por Empleado", "Reservas por Cliente"}));
		cmbTipoReporte.setBounds(46, 21, 172, 20);
		panel.add(cmbTipoReporte);
		
		lblEmpleado = new JLabel("Empleado:");
		lblEmpleado.setBounds(10, 58, 79, 14);
		panel.add(lblEmpleado);
		
		cmbEmpleado = new JComboBox();
		cmbEmpleado.addActionListener(this);
		cmbEmpleado.setBounds(46, 83, 172, 20);
		panel.add(cmbEmpleado);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 58, 79, 14);
		panel.add(lblCliente);
		
		cmbCliente = new JComboBox();
		cmbCliente.addActionListener(this);
		cmbCliente.setBounds(46, 83, 172, 20);
		panel.add(cmbCliente);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rango de Fechas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(248, 11, 269, 117);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 22, 46, 14);
		panel_1.add(lblDesde);
		
		cmbDesdedia = new JComboBox <String> ();
		colocarItems(cmbDesdedia,1,31);
		cmbDesdedia.addActionListener(this);
		cmbDesdedia.setBounds(57, 19, 46, 20);
		panel_1.add(cmbDesdedia);
		
		cmbDesdemes = new JComboBox <String>();
		colocarMeses(cmbDesdemes);
		cmbDesdemes.addActionListener(this);
		cmbDesdemes.setBounds(104, 19, 90, 20);
		panel_1.add(cmbDesdemes);
		
		cmbDesdeaño = new JComboBox <String>();
		colocarItems(cmbDesdeaño,añoActual(),2000);
		cmbDesdeaño.addActionListener(this);
		cmbDesdeaño.setBounds(197, 19, 62, 20);
		panel_1.add(cmbDesdeaño);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(10, 58, 46, 14);
		panel_1.add(lblHasta);
		
		cmbHastadia = new JComboBox <String>();
		colocarItems(cmbHastadia,1,31);
		colocarDiaActual();
		cmbHastadia.addActionListener(this);
		cmbHastadia.setBounds(57, 55, 46, 20);
		panel_1.add(cmbHastadia);
		
		cmbHastames = new JComboBox <String>();
		colocarMeses(cmbHastames);
		colocarMesActual();
		cmbHastames.addActionListener(this);
		cmbHastames.setBounds(104, 55, 90, 20);
		panel_1.add(cmbHastames);
		
		cmbHastaaño = new JComboBox <String>();
		colocarItems(cmbHastaaño,añoActual(),2000);
		cmbHastaaño.addActionListener(this);
		cmbHastaaño.setBounds(197, 55, 62, 20);
		panel_1.add(cmbHastaaño);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 133, 507, 171);
		contentPane.add(txtS);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 133, 507, 171);
		contentPane.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(Reporte.class.getResource("/img/Cancelar.png")));
		btnSalir.setBounds(428, 315, 89, 23);
		contentPane.add(btnSalir);
		
		btnProcesar = new JButton("Limpiar");
		btnProcesar.addActionListener(this);
		btnProcesar.setIcon(new ImageIcon(Reporte.class.getResource("/img/Limpiar.png")));
		btnProcesar.setBounds(10, 315, 109, 23);
		contentPane.add(btnProcesar);
		
		tblTablaE = new JScrollPane();
		tblTablaE.setBounds(10, 139, 507, 165);
		contentPane.add(tblTablaE);
		
		table_1 = new JTable();
		tblTablaE.setViewportView(table_1);
		
		m = new DefaultTableModel();
		m.addColumn("Codigo Reserva");
		m.addColumn("Nombre Cliente");
		m.addColumn("Nombre Empleado");
		m.addColumn("Fecha");
		m.addColumn("Hora");
		table.setModel(m);
		
		me = new DefaultTableModel();
		me.addColumn("Codigo Reserva");
		me.addColumn("Fecha Registro");
		me.addColumn("Hora Registro");
		table_1.setModel(me);
		
		lblEmpleado.setVisible(false);
		cmbEmpleado.setVisible(false);
		lblCliente.setVisible(false);
		cmbCliente.setVisible(false);
		tblTablaE.setVisible(false);
		tblTabla.setVisible(false);
		
		listarEmpleado();
		listarClientes();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbCliente) {
			actionPerformedCmbCliente(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == cmbEmpleado) {
			actionPerformedCmbEmpleado(arg0);
		}
		if (arg0.getSource() == cmbHastaaño) {
			actionPerformedCmbHastaaño(arg0);
		}
		if (arg0.getSource() == cmbHastames) {
			actionPerformedCmbHastames(arg0);
		}
		if (arg0.getSource() == cmbHastadia) {
			actionPerformedCmbHastadia(arg0);
		}
		if (arg0.getSource() == cmbDesdeaño) {
			actionPerformedCmbDesdeaño(arg0);
		}
		if (arg0.getSource() == cmbDesdemes) {
			actionPerformedCmbDesdemes(arg0);
		}
		if (arg0.getSource() == cmbDesdedia) {
			actionPerformedCmbDesdedia(arg0);
		}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cmbTipoReporte) {
			itemStateChangedCmbTipoReporte(arg0);
		}
	}
	ArregloReserva ar = new ArregloReserva("Reserva.txt");
	ArregloEmpleado ae = new ArregloEmpleado("Empleado.txt");
	ArregloCliente ac = new ArregloCliente("Cliente.txt");
	ArregloFuncion af = new ArregloFuncion("Funcion.txt");
	ArregloPelicula ap = new ArregloPelicula("Pelicula.txt");

	protected void itemStateChangedCmbTipoReporte(ItemEvent arg0) {
		seleccionar();
	}
	protected void actionPerformedCmbDesdedia(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbDesdemes(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbDesdeaño(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbHastadia(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbHastames(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbHastaaño(ActionEvent arg0) {
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			taquillera();
			break;
		case 1:
			listadoReserva();
			break;
		case 2:
			reservaPorEmpleado();
			break;
		default:
			reservaPorCliente();
		}
	}
	protected void actionPerformedCmbEmpleado(ActionEvent arg0) {
		reservaPorEmpleado();
	}
	protected void actionPerformedCmbCliente(ActionEvent arg0) {
		reservaPorCliente();
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		limpiar();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	//METODO SELECCIONAR: OCULTA CAMPOS NO NECESARIOS
	void seleccionar(){
		switch(cmbTipoReporte.getSelectedIndex()){
		case 0:
			lblEmpleado.setVisible(false);
			cmbEmpleado.setVisible(false);
			lblCliente.setVisible(false);
			cmbCliente.setVisible(false);
			tblTablaE.setVisible(false);
			tblTabla.setVisible(false);
			txtS.setVisible(true);
			break;
		case 1:
			lblEmpleado.setVisible(false);
			cmbEmpleado.setVisible(false);
			lblCliente.setVisible(false);
			cmbCliente.setVisible(false);
			tblTablaE.setVisible(false);
			tblTabla.setVisible(true);
			txtS.setVisible(false);
			m.setRowCount(0);
			break;
		case 2:
			lblEmpleado.setVisible(true);
			cmbEmpleado.setVisible(true);
			lblCliente.setVisible(false);
			cmbCliente.setVisible(false);
			tblTablaE.setVisible(true);
			tblTabla.setVisible(false);
			txtS.setVisible(false);
			me.setRowCount(0);
			break;
		default:
			lblEmpleado.setVisible(false);
			cmbEmpleado.setVisible(false);
			lblCliente.setVisible(true);
			cmbCliente.setVisible(true);
			tblTablaE.setVisible(true);
			tblTabla.setVisible(false);
			txtS.setVisible(false);
			me.setRowCount(0);
		}
	}
	//LISTAR EMPLEADO
	void listarEmpleado(){
		cmbEmpleado.removeAllItems();
		Empleado e;
		for(int i=0; i<ae.tamanio(); i++){
			e = ae.obtener(i);
			cmbEmpleado.addItem(e.getCodEmpleado()+"-"+e.getNombre()+"-"+e.getApePater());
		}
	}
	//LISTAR CLIENTES
	void listarClientes(){
		cmbCliente.removeAllItems();
		Cliente c;
		for(int i=0; i<ac.tamanio(); i++){
			c = ac.obtener(i);
			cmbCliente.addItem(c.getCodCliente()+"-"+c.getNombre()+"-"+c.getApepat());
		}
	}
	
	//FUNCION PARA FECHA
		//COLOCAR ITEMS
	void colocarMeses(JComboBox <String> cbo) {
		for (int i=1; i<=12; i++)
			cbo.addItem(obtenerMes(i));
	}
	void colocarItems(JComboBox <String> cbo, int desde, int hasta) {
		if (desde < hasta)
			while (desde <= hasta) {
				cbo.addItem("" + desde);
				desde ++;
			}
		else
			while (desde >= hasta) {
				cbo.addItem("" + desde);
				desde --;
			}
	}
	void colocarDiaActual() {
		Calendar calendario = new GregorianCalendar();
		cmbHastadia.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH)-1);
	}
	void colocarMesActual() {
		Calendar calendario = new GregorianCalendar();
		cmbHastames.setSelectedIndex(calendario.get(Calendar.MONTH));
	}
	
	//FILTRAR
	void filtrar(){
		int desde = leerDesde(),
			hasta = leerHasta(),
			fecha;
			
	}
	//METODOS LEER
	int añoActual() {
		Calendar calendario = new GregorianCalendar();
		return calendario.get(Calendar.YEAR);
	}
	int leerDesde(){
		int aa = Integer.parseInt(cmbDesdeaño.getSelectedItem().toString()),
			mm = (cmbDesdemes.getSelectedIndex()+1),
			dd = (cmbDesdedia.getSelectedIndex()+1);
		return (aa * 100 + mm) * 100 + dd;
	}
	int leerHasta() {
		int aa = Integer.parseInt(cmbHastaaño.getSelectedItem().toString()),
		    mm = (cmbHastames.getSelectedIndex() + 1),
			dd = (cmbHastadia.getSelectedIndex() + 1);
		return (aa * 100 + mm) * 100 + dd;
	}
	int obtEmpleado(){
		String emp = cmbEmpleado.getSelectedItem()+"";
		emp = emp.substring(0,emp.indexOf("-"));
		return Integer.parseInt(emp);
	}
	int obtCliente(){
		String cli = cmbCliente.getSelectedItem()+"";
		cli = cli.substring(0,5);
		return Integer.parseInt(cli);
	}
	//OBTENER MES
	public String obtenerMes(int mes) {
		switch (mes) {
			case  1: return "Enero";
			case  2: return "Febrero";
			case  3: return "Marzo";
			case  4: return "Abril";
			case  5: return "Mayo";
			case  6: return "Junio";
			case  7: return "Julio";
			case  8: return "Agosto";
			case  9: return "Setiembre";
			case 10: return "Octubre";
			case 11: return "Noviembre";
			default: return "Diciembre";
		}
	}
	//PELICULA MAS TAQUILLERA
	void taquillera(){
		int desde = leerDesde();
		int hasta = leerHasta();
		int fecha;
		
		for(int i=0; i<ar.tamaño(); i++){
			int codReserva = ar.obtener(i).getCodReserva();
			//Convertir fecha a entero
			String dato = ar.obtener(i).getFechaReserva();
			dato = dato.substring(6,10)+dato.substring(3,5)+dato.substring(0,2);
			fecha = Integer.parseInt(dato);
			
			Reserva r = ar.buscar(codReserva);
			Funcion f = af.buscar(r.getCodiFuncion());
			Pelicula p = ap.buscar(f.getCodPeli());
					if(fecha >=desde && fecha <=hasta){
						txtS.setText("");
						imprimir("La pelicula mas taquilera	:"+p.getTitOriginal());
						imprimir("Genero de Pelicula	:"+p.GeneroPelicula());
					}
				
		}
	}
	//LISTADO DE RESERVA POR RANGO DE FECHA
	void listadoReserva(){
		int desde = leerDesde();
		int hasta = leerHasta();
		int fecha;
		
		m.setRowCount(0);
		for(int i=0; i<ar.tamaño(); i++){
			int codRes = ar.obtener(i).getCodReserva();
			//Convertir fecha a entero
			String dato = ar.obtener(i).getFechaReserva();
			dato = dato.substring(6,10)+dato.substring(3,5)+dato.substring(0,2);
			fecha = Integer.parseInt(dato);
			//Buscando la reserva
			Reserva r = ar.buscar(codRes);
				//Buscando al cliente
				Cliente c = ac.buscar(r.getCodCliente());
				//Buscando al empleado
				Empleado e = ae.buscar(r.getCodEmpleado());
				if(fecha >= desde  &&  fecha <= hasta){
					Object fila[]={
							ar.obtener(i).getCodReserva(),
							c.getNombre()+" "+c.getApepat()+" "+c.getApemat(),
							e.getNombre()+" "+e.getApePater()+" "+e.getApeMater(),
							ar.obtener(i).getFechaReserva(),
							ar.obtener(i).getHoraReserva()};
					m.addRow(fila);
				}
		}
	}
	//RESERVAS POR EMPLEADO
	void reservaPorEmpleado(){
		int 	desde = leerDesde(),
				hasta = leerHasta(),
				fecha;
		
		me.setRowCount(0);
		for(int i=0; i<ar.tamaño(); i++){
			int codRes = ar.obtener(i).getCodReserva();
			//Convertir fecha a entero
			String dato = ar.obtener(i).getFechaReserva();
			dato = dato.substring(6,10)+dato.substring(3,5)+dato.substring(0,2);
			fecha = Integer.parseInt(dato);
			
			//Pasando codigo del empleado
			int codEmpleado = obtEmpleado();
			Reserva r = ar.buscar(codRes);
			Empleado e = ae.buscar(r.getCodEmpleado());

			
		if(e.getCodEmpleado()== codEmpleado){
			if(fecha >= desde  &&  fecha <= hasta){
					Object fila[]={
							r.getCodReserva(),
							r.getFechaReserva(),
							r.getHoraReserva()};
					me.addRow(fila);
				}
			}
		}
	}
	//RESERVAS POR CLIENTE
	void reservaPorCliente(){
		int		desde = leerDesde(),
				hasta = leerHasta(),
				fecha;
		
		me.setRowCount(0);
		for(int i=0; i<ar.tamaño(); i++){
			int codRes = ar.obtener(i).getCodReserva();
			//Convertir fecha a entero
			String dato = ar.obtener(i).getFechaReserva();
			dato = dato.substring(6,10)+dato.substring(3,5)+dato.substring(0,2);
			fecha = Integer.parseInt(dato);
			
			
			//Pasando codigo del cliente
			Reserva r = ar.buscar(codRes);
			int codCliente = obtCliente();
			Cliente c = ac.buscar(r.getCodCliente());
			if(c.getCodCliente()== codCliente){
				if(fecha >= desde  &&  fecha <= hasta){
						Object fila[]={
								r.getCodReserva(),
								r.getFechaReserva(),
								r.getHoraReserva()};
						me.addRow(fila);
					}
				}
		}
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
	//Limpiar
	void limpiar(){
		txtS.setText("");
		m.setRowCount(0);
		me.setRowCount(0);
	}

}








