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
import javax.swing.JTextField;

public class frmSalas extends JFrame {

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
		btnIngresar.setBounds(427, 55, 117, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(427, 89, 117, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(427, 123, 117, 23);
		contentPane.add(btnEliminar);
		
		btnListado = new JButton("Listado");
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
	ArregloSala as = new ArregloSala();
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
}
