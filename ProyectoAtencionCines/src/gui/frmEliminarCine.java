package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cine;
import controlador.ArregloCine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmEliminarCine extends JFrame implements ActionListener {

	private JPanel contentPane;

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
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("Codigo:");
		label.setBounds(10, 22, 46, 14);
		contentPane.add(label);
		
		txtCod = new JTextField();
		txtCod.setText("10001");
		txtCod.setColumns(10);
		txtCod.setBounds(96, 19, 86, 20);
		contentPane.add(txtCod);
		
		label_1 = new JLabel("Provincia:");
		label_1.setBounds(10, 118, 58, 14);
		contentPane.add(label_1);
		
		txtProv = new JTextField();
		txtProv.setColumns(10);
		txtProv.setBounds(96, 115, 86, 20);
		contentPane.add(txtProv);
		
		label_2 = new JLabel("Tipo:");
		label_2.setBounds(10, 213, 46, 14);
		contentPane.add(label_2);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Estandar", "Prime"}));
		cmbTipo.setBounds(96, 210, 86, 20);
		contentPane.add(cmbTipo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(262, 18, 89, 23);
		contentPane.add(btnBuscar);
		
		label_3 = new JLabel("Nombre:");
		label_3.setBounds(10, 53, 46, 14);
		contentPane.add(label_3);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(96, 50, 86, 20);
		contentPane.add(txtNom);
		
		label_4 = new JLabel("Distrito:");
		label_4.setBounds(10, 148, 46, 14);
		contentPane.add(label_4);
		
		txtDist = new JTextField();
		txtDist.setColumns(10);
		txtDist.setBounds(96, 145, 86, 20);
		contentPane.add(txtDist);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(262, 52, 89, 23);
		contentPane.add(btnEliminar);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(96, 176, 86, 20);
		contentPane.add(txtFecha);
		
		label_5 = new JLabel("Fecha Inicio:");
		label_5.setBounds(10, 177, 68, 14);
		contentPane.add(label_5);
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBounds(96, 82, 86, 20);
		contentPane.add(txtDep);
		
		label_6 = new JLabel("Departamento:");
		label_6.setBounds(10, 85, 79, 14);
		contentPane.add(label_6);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(262, 86, 89, 23);
		contentPane.add(btnSalir);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			do_button_actionPerformed(arg0);
		}
	}
	ArregloCine ac=new ArregloCine("cine.txt");
	private JLabel label;
	private JTextField txtCod;
	private JLabel label_1;
	private JTextField txtProv;
	private JLabel label_2;
	private JComboBox cmbTipo;
	private JButton btnBuscar;
	private JLabel label_3;
	private JTextField txtNom;
	private JLabel label_4;
	private JTextField txtDist;
	private JButton btnEliminar;
	private JTextField txtFecha;
	private JLabel label_5;
	private JTextField txtDep;
	private JLabel label_6;
	private JButton btnSalir;
//  Métodos tipo void (sin parámetros)
  	void limpieza() {
   		txtCod.setText("");
   	
   	}
  	public  void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
//  Métodos que retornan valor sin parámetros
	int leerCodigo() {
		return Integer.parseInt(txtCod.getText().trim());
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		consultarCine();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		eliminarCine();
	}
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	//CONSULTAR CINE
		void consultarCine() {
			try {
				Cine x= ac.buscar(leerCodigo());
				if (x != null) {
					txtNom.setText(x.getNombre());
					txtDep.setText(x.getDepartamento());
					txtProv.setText(x.getProvincia());
					txtDist.setText(x.getDistrito());
					txtFecha.setText(x.getFechaInicio());
					cmbTipo.setSelectedIndex(x.getTipo());
				}
				else {
					mensaje("El código " + leerCodigo() + " no existe");
					txtCod.setText("");
					txtCod.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese CÓDIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}
		
		void eliminarCine() {
			try {
				Cine x = ac.buscar(leerCodigo());
				if (x != null) {
					ac.eliminar(x);
					ac.grabarCine();
					txtCod.setText("");
					txtNom.setText("");
					txtDep.setText("");
					txtProv.setText("");
					txtDist.setText("");
					txtFecha.setText("");
					cmbTipo.setToolTipText("");
					txtCod.requestFocus();
				}
				else {
					mensaje("El código " + leerCodigo() + " no existe");
					txtCod.setText("");
					txtCod.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("ingrese CÓDIGO correcto");
				txtCod.setText("");
				txtCod.requestFocus();
			}	
		}
}
