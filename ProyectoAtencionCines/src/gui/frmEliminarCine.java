package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmEliminarCine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JTextField txtCod;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEliminarCine frame = new frmEliminarCine();
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
	public frmEliminarCine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCod = new JTextField();
		txtCod.setBounds(55, 8, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(165, 7, 89, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(299, 7, 89, 23);
		contentPane.add(btnSalir);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 36, 414, 214);
		contentPane.add(txtS);
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
