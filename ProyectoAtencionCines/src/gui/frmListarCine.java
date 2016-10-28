package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ArregloCine;

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
	private DefaultTableModel modelo;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 582, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(230, 283, 89, 23);
		contentPane.add(btnSalir);
		
		//Creando el modelo en la tabla
				modelo = new DefaultTableModel();
				//Aquí agregas las columnas para tu tabla
				modelo.addColumn("Código");
				modelo.addColumn("Nombre");
				modelo.addColumn("Departamento");
				modelo.addColumn("Provincia");
				modelo.addColumn("Distrito");
				modelo.addColumn("Fecha Inicio");
				modelo.addColumn("Tipo");
				table.setModel(modelo);
		listar();
	}
//  Métodos tipo void (con parámetros)
	public void listar(){
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Object fila[] = {
					ac.obtener(i).getCodCine(),
					ac.obtener(i).getNombre(),
					ac.obtener(i).getDepartamento(),
					ac.obtener(i).getProvincia(),
					ac.obtener(i).getDistrito(),
					ac.obtener(i).getFechaInicio(),
					ac.obtener(i).tipoCine()
			};
			modelo.addRow(fila);
		}
	}
	
	ArregloCine ac=new ArregloCine("cine.txt");
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
	}
	frmIngresoCine ic=new frmIngresoCine();
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
}
