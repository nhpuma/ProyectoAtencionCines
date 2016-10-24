package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmModificarCine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label;
	private JTextField txtCod;
	private JLabel label_1;
	private JTextField txtProv;
	private JLabel label_2;
	private JTextField txtNom;
	private JLabel label_3;
	private JTextField txtDist;
	private JLabel label_4;
	private JTextField txtDep;
	private JLabel label_5;
	private JTextField txtFecha;
	private JLabel lblTipo;
	private JComboBox cmbTipo;
	private JButton btnModificar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmModificarCine frame = new frmModificarCine();
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
	public frmModificarCine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("Codigo:");
		label.setBounds(10, 14, 46, 14);
		contentPane.add(label);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(93, 11, 86, 20);
		contentPane.add(txtCod);
		
		label_1 = new JLabel("Provincia:");
		label_1.setBounds(202, 14, 58, 14);
		contentPane.add(label_1);
		
		txtProv = new JTextField();
		txtProv.setColumns(10);
		txtProv.setBounds(267, 11, 86, 20);
		contentPane.add(txtProv);
		
		label_2 = new JLabel("Nombre:");
		label_2.setBounds(10, 39, 46, 14);
		contentPane.add(label_2);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(93, 36, 86, 20);
		contentPane.add(txtNom);
		
		label_3 = new JLabel("Distrito:");
		label_3.setBounds(202, 39, 46, 14);
		contentPane.add(label_3);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(267, 36, 86, 20);
		contentPane.add(txtDist);
		
		label_4 = new JLabel("Departamento:");
		label_4.setBounds(10, 64, 79, 14);
		contentPane.add(label_4);
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBounds(93, 61, 86, 20);
		contentPane.add(txtDep);
		
		label_5 = new JLabel("Fecha Inicio:");
		label_5.setBounds(202, 64, 68, 14);
		contentPane.add(label_5);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(267, 61, 86, 20);
		contentPane.add(txtFecha);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 89, 46, 14);
		contentPane.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setBounds(93, 89, 86, 20);
		contentPane.add(cmbTipo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(145, 140, 89, 23);
		contentPane.add(btnModificar);
		
		btnSalir = new JButton("salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(145, 174, 89, 23);
		contentPane.add(btnSalir);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
