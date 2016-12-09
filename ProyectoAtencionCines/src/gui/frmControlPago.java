package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmControlPago extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDeReserva = new JLabel("C\u00F3digo de reserva:");
		lblCdigoDeReserva.setBounds(64, 67, 93, 28);
		contentPane.add(lblCdigoDeReserva);
		
		textField = new JTextField();
		textField.setBounds(179, 67, 123, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 106, 493, 255);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnProcesar = new JButton("PROCESAR");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProcesar.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/checked2.png")));
		btnProcesar.setBounds(434, 65, 123, 30);
		contentPane.add(btnProcesar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/play.png")));
		button.setBounds(311, 67, 48, 28);
		contentPane.add(button);
	}

}
