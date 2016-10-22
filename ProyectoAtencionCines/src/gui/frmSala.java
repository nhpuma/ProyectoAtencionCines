package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmSala extends JFrame {

	private JPanel contentPane;
	private JLabel lblSalas;
	private JLabel lblCdigo;
	private JLabel lblCdigoDeCine;
	private JLabel lblNmeroDeSala;
	private JLabel lblNmeroDeFilas;
	private JLabel lblNmeroDeButacas;
	private JComboBox cmbCodigoSala;
	private JTextField txtCodsala;
	private JTextField txtCodcine;
	private JTextField txtNumsala;
	private JTextField txtNumfilas;
	private JTextField txtNumbutacas;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;

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
		setTitle("Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSalas = new JLabel("Código Salas:");
		lblSalas.setBounds(6, 21, 140, 16);
		contentPane.add(lblSalas);
		
		lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(6, 70, 140, 16);
		contentPane.add(lblCdigo);
		
		lblCdigoDeCine = new JLabel("Código de Cine:");
		lblCdigoDeCine.setBounds(6, 108, 140, 16);
		contentPane.add(lblCdigoDeCine);
		
		lblNmeroDeSala = new JLabel("Número de Sala:");
		lblNmeroDeSala.setBounds(6, 146, 140, 16);
		contentPane.add(lblNmeroDeSala);
		
		lblNmeroDeFilas = new JLabel("Número de filas:");
		lblNmeroDeFilas.setBounds(6, 184, 140, 16);
		contentPane.add(lblNmeroDeFilas);
		
		lblNmeroDeButacas = new JLabel("Número de butacas:");
		lblNmeroDeButacas.setBounds(6, 222, 140, 16);
		contentPane.add(lblNmeroDeButacas);
		
		cmbCodigoSala = new JComboBox();
		cmbCodigoSala.setBounds(158, 17, 190, 27);
		contentPane.add(cmbCodigoSala);
		
		txtCodsala = new JTextField();
		txtCodsala.setBounds(168, 65, 190, 26);
		contentPane.add(txtCodsala);
		txtCodsala.setColumns(10);
		
		txtCodcine = new JTextField();
		txtCodcine.setBounds(168, 103, 190, 26);
		contentPane.add(txtCodcine);
		txtCodcine.setColumns(10);
		
		txtNumsala = new JTextField();
		txtNumsala.setBounds(168, 141, 190, 26);
		contentPane.add(txtNumsala);
		txtNumsala.setColumns(10);
		
		txtNumfilas = new JTextField();
		txtNumfilas.setBounds(168, 179, 190, 26);
		contentPane.add(txtNumfilas);
		txtNumfilas.setColumns(10);
		
		txtNumbutacas = new JTextField();
		txtNumbutacas.setBounds(168, 217, 190, 26);
		contentPane.add(txtNumbutacas);
		txtNumbutacas.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(412, 65, 117, 29);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(412, 103, 117, 29);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(412, 141, 117, 29);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(412, 179, 117, 29);
		contentPane.add(btnListar);
	}
}
