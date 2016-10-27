package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmListarCine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnSalir;
	private JTable table;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListarCine frame = new frmListarCine();
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
	public frmListarCine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, -15, 582, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(441, 272, 89, 23);
		contentPane.add(btnSalir);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(135, 272, 89, 23);
		contentPane.add(btnListar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			do_btnListar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	frmIngresoCine ic=new frmIngresoCine();
	protected void do_btnListar_actionPerformed(ActionEvent arg0) {
		ic.listar();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}

}
