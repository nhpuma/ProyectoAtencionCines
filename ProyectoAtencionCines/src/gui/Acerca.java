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
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Acerca extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAceptar;
	private JLabel txtS;
	private JTextArea txtS_1;

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
		setTitle("Desarrolladores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		
		txtS_1 = new JTextArea();
		txtS_1.setEditable(false);
		txtS_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtS_1.setBounds(94, 58, 264, 133);
		contentPane.add(txtS_1);
		btnAceptar.setBounds(164, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		txtS = new JLabel("");
		txtS.setIcon(new ImageIcon(Acerca.class.getResource("/img/fondoa.jpg")));
		txtS.setBounds(0, 0, 434, 261);
		contentPane.add(txtS);
		imprimir();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		dispose();
	}
	//IMPRIMIR
	void imprimir(){
		txtS_1.setText("\n");
		txtS_1.append("\tIntegrantes\n\n");
		txtS_1.append("1. Puma Jihuallanca Richard\n");
		txtS_1.append("2. Solgada Pino Reyder\n");
		txtS_1.append("3. Rivas Figueroa Edgar Benyi\n");
		txtS_1.append("4. Huiallcapuma Acha Percy");
	}
}
