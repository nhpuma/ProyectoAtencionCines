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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

public class frmControlPago extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigoDeReserva;
	private JTextField txtcodReserva;
	private JButton btnImprimir;
	private JTextArea txtS;
	private JPanel panel;
	private JScrollPane tblTabla;
	private JTable table;
	private JLabel lblSubtotal;
	private JLabel lblIgv;
	private JLabel lblTotal;
	private JTextField txtsubTotal;
	private JTextField txtIGV;
	private JTextField txtTotal;
	private DefaultTableModel m;
	private JButton btnSalir;

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
		setTitle("Control de Pago");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoDeReserva = new JLabel("Codigo de Reserva:");
		lblCodigoDeReserva.setBounds(10, 11, 138, 14);
		contentPane.add(lblCodigoDeReserva);
		
		txtcodReserva = new JTextField();
		txtcodReserva.setBounds(158, 8, 86, 20);
		contentPane.add(txtcodReserva);
		txtcodReserva.setColumns(10);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(354, 7, 89, 23);
		contentPane.add(btnImprimir);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setBounds(10, 43, 499, 159);
		contentPane.add(txtS);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 213, 499, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tblTabla = new JScrollPane();
		tblTabla.setBounds(10, 27, 489, 111);
		panel.add(tblTabla);
		
		table = new JTable();
		tblTabla.setViewportView(table);
		
		lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setBounds(228, 149, 69, 14);
		panel.add(lblSubtotal);
		
		lblIgv = new JLabel("IGV:");
		lblIgv.setBounds(228, 171, 46, 14);
		panel.add(lblIgv);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(228, 196, 46, 14);
		panel.add(lblTotal);
		
		txtsubTotal = new JTextField();
		txtsubTotal.setBounds(403, 143, 86, 20);
		panel.add(txtsubTotal);
		txtsubTotal.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setColumns(10);
		txtIGV.setBounds(403, 168, 86, 20);
		panel.add(txtIGV);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(403, 193, 86, 20);
		panel.add(txtTotal);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(frmControlPago.class.getResource("/img/cancel2.png")));
		btnSalir.setBounds(420, 469, 89, 23);
		contentPane.add(btnSalir);
		
		m = new DefaultTableModel();
		m.addColumn("Cantidad");
		m.addColumn("Tipo Entrada");
		m.addColumn("Precio Unit");
		m.addColumn("Importe");
		table.setModel(m);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
	}
	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		imprimir();
		imprimir("Nombre del Cine	:");
		imprimir("Codigo Empleado	:");
		imprimir("Codigo Cliente		:");
		imprimir("Nombre Cliente		:");
		imprimir("Codigo Sala		:");
		imprimir("Titulo Pelicula		:");
		imprimir("Butacas Reservadas	:");
		
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	//IMPRIMIR
	void imprimir() {
		imprimir("");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

}
