package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Acerca extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acerca frame = new Acerca();
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
	public Acerca() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(160, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtS.setBounds(10, 11, 414, 211);
		contentPane.add(txtS);
		imprimir();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		dispose();
	}
	//IMPRIMIR
	void imprimir(){
		txtS.setText("");
		txtS.append("\t\tIntegrantes\n\n");
		txtS.append("\t1. Puma Jihuallanca Richard\n");
		txtS.append("\t2. Solgada Pino Reyder\n");
		txtS.append("\t3. Rivas Figueroa Edgar Benyi\n");
		txtS.append("\t4. Huiallcapuma Acha Percy");
	}
}
