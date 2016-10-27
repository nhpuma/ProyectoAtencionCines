package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Sala;
import controlador.ArregloSala;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgSalas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCdigoSala;
	private JTextField txtcodsala;
	private JTextField txtcodcine;
	private JTextField txtnumsala;
	private JTextField txtnumfilas;
	private JTextField txtnumbutacas;
	private JLabel lblCdigoCine;
	private JLabel lblNmeroDeSala;
	private JLabel lblNmeroDeFilas;
	private JLabel lblNmeroDeButacas;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgSalas dialog = new dlgSalas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgSalas() {
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCdigoSala = new JLabel("C\u00F3digo de Sala:");
		lblCdigoSala.setBounds(10, 14, 120, 14);
		contentPanel.add(lblCdigoSala);
		
		txtcodsala = new JTextField();
		txtcodsala.setText("CodSala");
		txtcodsala.setBounds(150, 11, 183, 20);
		contentPanel.add(txtcodsala);
		txtcodsala.setColumns(10);
		
		txtcodcine = new JTextField();
		txtcodcine.setText("CodCine");
		txtcodcine.setBounds(150, 42, 183, 20);
		contentPanel.add(txtcodcine);
		txtcodcine.setColumns(10);
		
		txtnumsala = new JTextField();
		txtnumsala.setText("NumSala");
		txtnumsala.setBounds(150, 73, 183, 20);
		contentPanel.add(txtnumsala);
		txtnumsala.setColumns(10);
		
		txtnumfilas = new JTextField();
		txtnumfilas.setText("NumFilas");
		txtnumfilas.setBounds(150, 104, 183, 20);
		contentPanel.add(txtnumfilas);
		txtnumfilas.setColumns(10);
		
		txtnumbutacas = new JTextField();
		txtnumbutacas.setText("NumButacas");
		txtnumbutacas.setBounds(150, 135, 183, 20);
		contentPanel.add(txtnumbutacas);
		txtnumbutacas.setColumns(10);
		
		lblCdigoCine = new JLabel("C\u00F3digo de Cine:");
		lblCdigoCine.setBounds(10, 45, 120, 14);
		contentPanel.add(lblCdigoCine);
		
		lblNmeroDeSala = new JLabel("N\u00FAmero de sala:");
		lblNmeroDeSala.setBounds(10, 76, 120, 14);
		contentPanel.add(lblNmeroDeSala);
		
		lblNmeroDeFilas = new JLabel("N\u00FAmero de filas:");
		lblNmeroDeFilas.setBounds(10, 107, 120, 14);
		contentPanel.add(lblNmeroDeFilas);
		
		lblNmeroDeButacas = new JLabel("N\u00FAmero de butacas:");
		lblNmeroDeButacas.setBounds(10, 138, 120, 14);
		contentPanel.add(lblNmeroDeButacas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		limpieza();
		
		//Si es Ingreso o Modificación
		verificacion();
		
	}
	
	
	private JButton cancelButton;
	
	void limpieza(){
		txtcodsala.setText("");
		txtcodcine.setText("");
		txtnumsala.setText("");
		txtnumfilas.setText("");
		txtnumbutacas.setText("");
	}
	void verificacion(){
		if(frmSalas.codEnv == 0){
			txtcodsala.setText(""+frmSalas.as.codigoCorrelativo());
		}else {
			int cod = frmSalas.codEnv;
			Sala s = frmSalas.as.buscar(cod);
			txtcodsala.setText(""+s.getCodigo());
			txtcodcine.setText(""+s.getCodCine());
			txtnumsala.setText(""+s.getNumSala());
			txtnumfilas.setText(""+s.getNumFila());
			txtnumbutacas.setText(""+s.getNumButaca());
			frmSalas.codEnv = 0;
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		int codigo = Integer.parseInt(txtcodsala.getText());
		int codCine = Integer.parseInt(txtcodcine.getText());
		int numSala = Integer.parseInt(txtnumsala.getText());
		int numFila = Integer.parseInt(txtnumfilas.getText());
		int numButaca = Integer.parseInt(txtnumbutacas.getText());
		
		Sala sala = new Sala(codigo, codCine, numSala, numFila, numButaca);
		frmSalas.as.adicionar(sala);
		dispose();
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		dispose();
	}
}
