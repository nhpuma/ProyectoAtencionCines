package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloSala;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSalas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tblSalas;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListado;
	private JLabel lblCdigoDeCine;
	private JTextField txtCodcine;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSalas frame = new frmSalas();
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
	public frmSalas() {
		setTitle("Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 407, 313);
		contentPane.add(scrollPane);
		
		tblSalas = new JTable();
		scrollPane.setViewportView(tblSalas);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Codigo Cine");
		modelo.addColumn("Num. Sala");
		modelo.addColumn("Num. Filas");
		modelo.addColumn("Num. Butacas");
		tblSalas.setModel(modelo);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(427, 55, 117, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(427, 89, 117, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(427, 123, 117, 23);
		contentPane.add(btnEliminar);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(427, 157, 117, 23);
		contentPane.add(btnListado);
		
		lblCdigoDeCine = new JLabel("C\u00F3digo de Cine:");
		lblCdigoDeCine.setBounds(10, 14, 104, 14);
		contentPane.add(lblCdigoDeCine);
		
		txtCodcine = new JTextField();
		txtCodcine.setBounds(125, 11, 162, 20);
		contentPane.add(txtCodcine);
		txtCodcine.setColumns(10);
		
		listar();
	}
	
	//Declaración GLobal
	public static ArregloSala as = new ArregloSala();
	public static int codEnv = 0;
	
	void listar(){
		modelo.setRowCount(0);
		for (int i = 0; i < as.tamanho(); i++) {
			Object fila[] = {
					as.obtener(i).getCodigo(),
					as.obtener(i).getCodCine(),
					as.obtener(i).getNumSala(),
					as.obtener(i).getNumFila(),
					as.obtener(i).getNumButaca()
			};
			modelo.addRow(fila);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnListado) {
			actionPerformedBtnListado(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		//new dlgSalas(this).setVisible(true);
		dlgSalas dgs = new dlgSalas();
		dgs.setTitle("Ingresar");
		dgs.setModal(true);
		dgs.setLocationRelativeTo(this);
		
		dgs.setVisible(true);
		listar();
	}
	protected void actionPerformedBtnListado(ActionEvent arg0) {
		listar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		if(tblSalas.getSelectedRow()!=-1){
			int rpta = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar", "Eliminar", JOptionPane.YES_NO_OPTION);
			if(rpta==JOptionPane.YES_OPTION){
				int cod=Integer.parseInt(""+tblSalas.getValueAt(tblSalas.getSelectedRow(), 0));
				//Sala bsala = as.buscar(cod);
				as.eliminar(as.buscar(cod));
				listar();
			}
		}else{
			JOptionPane.showMessageDialog(this, "Seleccione un dato");
		}
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		//Capturando la selección en la tabla
		int fila = tblSalas.getSelectedRow();
		//Si selecciona o no una FILA
		if(fila!=-1){
			codEnv = Integer.parseInt(""+ tblSalas.getValueAt(fila, 0));
			dlgSalas dgSalas = new dlgSalas();
			dgSalas.setTitle("Modificar");
			dgSalas.setModal(true);
			dgSalas.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "Seleccione un dato");
		}
	}
}
