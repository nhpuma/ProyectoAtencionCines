package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class frmButaca extends JFrame {

	private JPanel contentPane;
	private JLabel lblCdigo;
	private JLabel lblNewLabel;
	private JLabel lblNumeroDeFila;
	private JLabel lblNmeroDeColumna;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JLabel lblEstado;
	private JComboBox comboBox;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmButaca frame = new frmButaca();
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
	public frmButaca() {
		setTitle("Butaca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo Butaca:");
		lblCdigo.setBounds(10, 11, 84, 14);
		contentPane.add(lblCdigo);
		
		lblNewLabel = new JLabel("C\u00F3digo sala:");
		lblNewLabel.setBounds(10, 36, 114, 14);
		contentPane.add(lblNewLabel);
		
		lblNumeroDeFila = new JLabel("N\u00FAmero de fila:");
		lblNumeroDeFila.setBounds(219, 11, 114, 14);
		contentPane.add(lblNumeroDeFila);
		
		lblNmeroDeColumna = new JLabel("N\u00FAmero de columna:");
		lblNmeroDeColumna.setBounds(219, 36, 114, 14);
		contentPane.add(lblNmeroDeColumna);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 8, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(343, 33, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 33, 86, 20);
		contentPane.add(textField_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(104, 8, 86, 20);
		contentPane.add(textField);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(453, 11, 46, 14);
		contentPane.add(lblEstado);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Reservada", "Disponible"}));
		comboBox.setBounds(509, 8, 92, 20);
		contentPane.add(comboBox);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(512, 39, 89, 23);
		contentPane.add(btnIngresar);
	}
}
