package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class frmFuncion extends JFrame {

	private JPanel contentPane;
	private JTextField txtFuncion;
	private JTextField txtCine;
	private JTextField txtSala;
	private JTextField txtPelicula;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTable tblTabla;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;

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
		setBounds(100, 100, 803, 350);
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
		txtCine.setBounds(108, 56, 117, 20);
		contentPane.add(txtCine);
		txtCine.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setBounds(108, 84, 117, 20);
		contentPane.add(txtSala);
		txtSala.setColumns(10);
		
		txtPelicula = new JTextField();
		txtPelicula.setBounds(342, 31, 117, 20);
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 126, 715, 174);
		contentPane.add(scrollPane_1);
		
		tblTabla = new JTable();
		scrollPane_1.setViewportView(tblTabla);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/add2.png")));
		btnIngresar.setBounds(501, 11, 113, 33);
		contentPane.add(btnIngresar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/buscar.png")));
		btnBuscar.setBounds(501, 45, 113, 33);
		contentPane.add(btnBuscar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/edit2.png")));
		btnModificar.setBounds(501, 82, 113, 33);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/remove2.png")));
		btnEliminar.setBounds(624, 11, 101, 33);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setIcon(new ImageIcon(frmFuncion.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(624, 50, 101, 33);
		contentPane.add(btnSalir);
	}
}
