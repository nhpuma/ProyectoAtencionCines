package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Vistas.dlgButacas;
import clases.Butaca;
import clases.Cine;
import clases.Cliente;
import clases.Empleado;
import clases.Pelicula;
import clases.Sala;
import controlador.ArregloButaca;
import controlador.ArregloCine;
import controlador.ArregloCliente;
import controlador.ArregloEmpleado;
import controlador.ArregloFuncion;
import controlador.ArregloPelicula;
import controlador.ArregloReserva;
import controlador.ArregloSala;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frmRegistroReserva extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodCliente;
	private JPanel panel;
	private JLabel lblDepartamento;
	private JLabel lblProvincia;
	private JLabel lblDistrito;
	private JComboBox cmbDepartamento;
	private JComboBox cmbProvincia;
	private JComboBox cmbDistrito;
	private JLabel lblCine;
	private JComboBox cmbCine;
	
	private String depart[] = {"Amazonas", "Ancash", "Apurímac", "Arequipa", 
	        "Ayacucho", "Cajamarca", "Callao", "Cusco", "Huancavelica", "Huánuco", 
	        "Ica", "Junín", "La Libertad", "Lambayeque", "Lima", "Loreto", 
	        "Madre De Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", 
	        "Tacna", "Tumbes", "Ucayali"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroReserva frame = new frmRegistroReserva();
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
	public frmRegistroReserva() {
		setTitle("Registro de Reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodCliente = new JLabel("Cod. Cliente:");
		lblCodCliente.setBounds(10, 63, 82, 14);
		contentPane.add(lblCodCliente);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ubicaci\u00F3n del Cine", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 125, 778, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(263, 31, 100, 14);
		panel.add(lblDepartamento);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(263, 56, 100, 14);
		panel.add(lblProvincia);
		
		lblDistrito = new JLabel("Distrito:");
		lblDistrito.setBounds(263, 81, 100, 14);
		panel.add(lblDistrito);
		
		cmbDepartamento = new JComboBox();
		cmbDepartamento.addActionListener(this);
		cmbDepartamento.setBounds(373, 28, 130, 20);
		panel.add(cmbDepartamento);
		
		cmbProvincia = new JComboBox();
		cmbProvincia.setBounds(373, 53, 130, 20);
		panel.add(cmbProvincia);
		
		cmbDistrito = new JComboBox();
		cmbDistrito.setBounds(373, 78, 130, 20);
		panel.add(cmbDistrito);
		
		lblCine = new JLabel("Cine:");
		lblCine.setBounds(263, 106, 100, 14);
		panel.add(lblCine);
		
		cmbCine = new JComboBox();
		cmbCine.setBounds(373, 103, 130, 20);
		panel.add(cmbCine);
		
		lblPelcula = new JLabel("Pel\u00EDcula:");
		lblPelcula.setBounds(10, 28, 99, 14);
		panel.add(lblPelcula);
		
		cmbPelicula = new JComboBox();
		cmbPelicula.addActionListener(this);
		cmbPelicula.setBounds(119, 25, 122, 20);
		panel.add(cmbPelicula);
		
		lblFechaFuncin = new JLabel("Fecha Funci\u00F3n:");
		lblFechaFuncin.setBounds(10, 53, 99, 14);
		panel.add(lblFechaFuncin);
		
		lblHoraFuncin = new JLabel("Hora Funci\u00F3n:");
		lblHoraFuncin.setBounds(10, 78, 99, 14);
		panel.add(lblHoraFuncin);
		
		cmbFecha = new JComboBox();
		cmbFecha.setBounds(119, 50, 122, 20);
		panel.add(cmbFecha);
		
		cmbHora = new JComboBox();
		cmbHora.setBounds(119, 75, 122, 20);
		panel.add(cmbHora);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Detalle Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 276, 514, 117);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblCantidadDeEntrada = new JLabel("Cantidad de entradas:");
		lblCantidadDeEntrada.setBounds(10, 51, 130, 14);
		panel_1.add(lblCantidadDeEntrada);
		
		lblButacas = new JLabel("Butacas:");
		lblButacas.setBounds(10, 76, 130, 14);
		panel_1.add(lblButacas);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(150, 48, 140, 20);
		panel_1.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnButacas = new JButton("Butacas");
		btnButacas.addActionListener(this);
		btnButacas.setBounds(150, 72, 140, 23);
		panel_1.add(btnButacas);
		
		lblTipoDeEntrada = new JLabel("Tipo de Entrada:");
		lblTipoDeEntrada.setBounds(10, 26, 130, 14);
		panel_1.add(lblTipoDeEntrada);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"General", "Menores de 11 a\u00F1os", "Mayores de 60 a\u00F1os"}));
		comboBox.setBounds(150, 23, 140, 20);
		panel_1.add(comboBox);
		
		lblSala = new JLabel("Sala:");
		lblSala.setBounds(300, 26, 62, 14);
		panel_1.add(lblSala);
		
		cmbSala = new JComboBox();
		cmbSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5", "Sala 6"}));
		cmbSala.setBounds(372, 23, 117, 20);
		panel_1.add(cmbSala);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Butacas Disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 404, 514, 225);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 494, 176);
		panel_2.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		cmbCodCliente = new JComboBox();
		cmbCodCliente.setBounds(102, 60, 159, 20);
		contentPane.add(cmbCodCliente);
		
		lblCodEmpleado = new JLabel("Cod. Empleado:");
		lblCodEmpleado.setBounds(271, 63, 103, 14);
		contentPane.add(lblCodEmpleado);
		
		cmbCodEmpleado = new JComboBox();
		cmbCodEmpleado.setBounds(384, 60, 140, 20);
		contentPane.add(cmbCodEmpleado);
		
		lblCodReserva = new JLabel("Cod. Reserva: ");
		lblCodReserva.setBounds(10, 11, 82, 14);
		contentPane.add(lblCodReserva);
		
		txtCodReserva = new JTextField();
		txtCodReserva.setBounds(102, 8, 159, 20);
		contentPane.add(txtCodReserva);
		txtCodReserva.setColumns(10);
		
		
		//Listando cmbDepartamento
		listarDepartamento();
		listarSalas();
		listarCliente();
		listarEmpleado();
		listaDePeliculas();
		
		txtCodReserva.setText(""+ares.codigoCorrelativo());
		
	}
	
	private JLabel lblPelcula;
	private JComboBox cmbPelicula;
	private JLabel lblFechaFuncin;
	private JLabel lblHoraFuncin;
	private JComboBox cmbFecha;
	private JComboBox cmbHora;
	private JPanel panel_1;
	private JLabel lblCantidadDeEntrada;
	private JLabel lblButacas;
	private JTextField txtCantidad;
	private JButton btnButacas;
	private JLabel lblTipoDeEntrada;
	private JComboBox comboBox;
	private JPanel panel_2;
	private JLabel lblSala;
	private JComboBox cmbSala;
	
	//Métodos complementarios
	ArregloCine ac = new ArregloCine("cine.txt");
	ArregloButaca ab = new ArregloButaca("Butacas.txt");
	ArregloSala as = new ArregloSala("Sala.txt");
	ArregloCliente acliente = new ArregloCliente("Cliente.txt");
	ArregloEmpleado aempl = new ArregloEmpleado("Empleado.txt");
	ArregloReserva ares = new ArregloReserva("Reserva.txt");
	ArregloPelicula aPeli = new ArregloPelicula("Pelicula.txt");
	ArregloFuncion aFun = new ArregloFuncion("Funcion.txt");
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JComboBox cmbCodCliente;
	private JLabel lblCodEmpleado;
	private JComboBox cmbCodEmpleado;
	private JLabel lblCodReserva;
	private JTextField txtCodReserva;
	
	void listaDePeliculas(){
		Pelicula p;
		for (int i = 0; i < aPeli.tamanio(); i++) {
			p = aPeli.obtener(i);
			cmbPelicula.addItem(p.getCodPeli()+"-"+p.getTitDistribucion());
		}
	}
	void listarEmpleado(){
		cmbCodEmpleado.removeAllItems();
		Empleado e;
		for (int i = 0; i < aempl.tamanio(); i++) {
			e = aempl.obtener(i);
			cmbCodEmpleado.addItem(e.getCodEmpleado());
		}
	}
	void listarCliente(){
		cmbCodCliente.removeAllItems();
		Cliente c;
		for (int i = 0; i < ac.tamanio(); i++) {
			c = acliente.obtener(i);
			cmbCodCliente.addItem(c.getCodCliente());
		}
	}
	void listarSalas(){
		cmbSala.removeAllItems();
		Sala s;
		for (int i = 0; i < as.tamanho(); i++) {
			s = as.obtener(i);
			cmbSala.addItem(s.getCodigo());
		}
	}
	void listarPelicula(){
		try {
			cmbProvincia.removeAllItems();
            cmbDistrito.removeAllItems();
            cmbCine.removeAllItems();
            
            Cine cine;
            System.out.println("CODIGO \t NOMBRE \t DEPARTAMENTO");
            String prov, aux;
            for (int i = 0; i < ac.tamanio(); i++) {
				cine = ac.obtener(i);
				if(cmbDepartamento.getSelectedItem().equals(cine.getDepartamento())){
					
					//prov[i] = cine.getProvincia();
					
					cmbProvincia.addItem(cine.getProvincia());
					cmbDistrito.addItem(cine.getDistrito());
					cmbCine.addItem(cine.getNombre());
				}
				
				System.out.println("Lista Filtrada: "+cine.getCodCine()+"\t"+
                        cine.getNombre()+"\t"+cine.getDepartamento());
			}
			
		}
		catch (Exception e) {
			System.out.println("Error al cargar "+e);
		}
	}
	void listarDepartamento(){
		for (int i = 0; i < depart.length; i++) {            
            cmbDepartamento.addItem(depart[i]);
        }
	}	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cmbPelicula) {
			actionPerformedCmbPelicula(arg0);
		}
		if (arg0.getSource() == btnButacas) {
			actionPerformedBtnButacas(arg0);
		}
		if (arg0.getSource() == cmbDepartamento) {
			actionPerformedCmbDepartamento(arg0);
		}
	}
	protected void actionPerformedCmbDepartamento(ActionEvent arg0) {
		listarPelicula();
	}
	protected void actionPerformedBtnButacas(ActionEvent arg0) {
		/*Info de Sala*/
		Sala s = as.buscar(Integer.parseInt(""+cmbSala.getSelectedItem()));
		int codSala = s.getCodigo();
		int f, c, resto;
		/*Butacas referenciadas*/
		ArregloButaca refButaca = new ArregloButaca();
		Butaca but;
		//Botones Butacas
		JToggleButton[] botones;		
		
		if(s != null){
			f = s.getNumFila();
			c = s.getNumButaca()/s.getNumFila();
			resto = s.getNumButaca()%s.getNumFila();
			
			if(resto != 0 && resto < f)
				c=c+1;	

			//LLamando al dialogo
			botones = new JToggleButton[s.getNumButaca()];
			
			dlgButacas dg = new dlgButacas(this, true);
			dg.setSize(600, 400);
			dg.jPanel1.setLayout(new GridLayout(f, c));
			
			for (int i = 0; i < ab.tamaño(); i++) {
				but = ab.obtener(i);
				if(but.getCodSala() == codSala){
					but = new Butaca(ab.obtener(i).getCodButaca(), ab.obtener(i).getCodSala(), 
							ab.obtener(i).getNumFila(), ab.obtener(i).getNumColumna(), ab.obtener(i).getEstado());
					refButaca.adicionar(but);
				}
			}
			
			int ndesact=0, nselec=0;
			for (int i = 0; i < botones.length; i++) {
				but = refButaca.obtener(i);
				botones[i] = new JToggleButton();
				botones[i].setText(but.getCodButaca()+"("+but.getNumFila()+";"+but.getNumColumna()+") - "+(i));
				if(but.getEstado() == 0){
					botones[i].setSelected(true);
					botones[i].setEnabled(false);
					ndesact++;
				}
				dg.jPanel1.add(botones[i]);
				
			}
			dg.setVisible(true);
			
			//Guardando la información de la reserva			
			String codB;
			for (int i = 0; i < botones.length; i++) {
				if(botones[i].isEnabled()==true && botones[i].isSelected()==true){
					codB = botones[i].getText();
					codB = codB.substring(0, codB.indexOf("("));
					System.out.println(""+codB);
					but = ab.buscar(Integer.parseInt(codB));
					but.setEstado(0);
					ab.grabarButaca();
				}
			}
		}//Fin primer if
		
		//Generando el reporte
		int codCliente = Integer.parseInt(""+cmbCodCliente.getSelectedItem());
		textArea.setText("");
		imprimir("Codigo de Reserva: "+ares.codigoCorrelativo());
		imprimir("Codigo del Empleado: "+cmbCodEmpleado.getSelectedItem());
		imprimir("Codigo de la Sala: "+cmbSala.getSelectedItem());
		imprimir("Codigo del Cliente: "+cmbCodCliente.getSelectedItem());
		imprimir("Nombre Cliente: "+acliente.buscar(codCliente).getNombre());
		imprimir("Apellidos Cliente: "+acliente.buscar(codCliente).getApepat()+" "+
		acliente.buscar(codCliente).getApemat());
		
		imprimir("Título Película: "+cmbPelicula.getSelectedItem());
		imprimir("Hora: "+cmbHora.getSelectedItem());
		imprimir("Fecha: "+cmbFecha.getSelectedItem());
		
		imprimir("Nº de entradas Tipo: ");
		imprimir("Cod. Butaca: ");
		
	}	
	
	void generarButacas(int butacas, int f, int c, int estado){
		JToggleButton[] botones;
		botones = new JToggleButton[butacas];
		
		dlgButacas dg = new dlgButacas(this, true);
		dg.setSize(600, 400);
		dg.jPanel1.setLayout(new GridLayout(f, c));
		
		//panel_2.setLayout(new GridLayout(5, 5));
		
		ImageIcon icono = new ImageIcon(getClass().getResource("/img/silla2x100.png"));		
		
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new JToggleButton();
			botones[i].setText(""+(i+1));
			botones[i].setIcon(icono);
			if(estado == 0){//Reservada
				botones[i].setSelected(true);
			}
			dg.jPanel1.add(botones[i]);
			//panel_2.add(botones[i], GridLayout.class);
			
		}
		dg.setVisible(true);
	}
	void imprimir(String s){
		textArea.append(s+"\n");
	}
	protected void actionPerformedCmbPelicula(ActionEvent arg0) {
		cmbFecha.removeAllItems();
		cmbHora.removeAllItems();
		String selec = ""+cmbPelicula.getSelectedItem();
		selec = selec.substring(0, selec.indexOf("-"));
		int codPeli = Integer.parseInt(selec);
		for (int i = 0; i < aFun.tamaño(); i++) {
			if(aFun.obtener(i).getCodPeli() == codPeli){
				cmbFecha.addItem(aFun.obtener(i).getFecha());
				cmbHora.addItem(aFun.obtener(i).getHora());
			}
		}		
	}
}
