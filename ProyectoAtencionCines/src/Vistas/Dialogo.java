package 	Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog; 
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Cine;
import clases.Cliente;
import clases.Empleado;
import clases.Pelicula;
import clases.Sala;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialogo<T> extends JDialog { 
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<String> list;
	private String seleccionado; 
	private JButton okButton;
	
	public String getSelect(){
		return seleccionado;
	}
	public void mostrar() {
		try { 
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public Dialogo(ArrayList<T> lista){
		this();
		DefaultListModel<String> m= new DefaultListModel<>();
		list.setModel(m);
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) instanceof Cliente){
				Cliente p=(Cliente)lista.get(i);
				m.addElement(p.getCodCliente()+"-"+p.getNombre()+", "+p.getApepat()+" "+p.getApemat());				
			}else if(lista.get(i) instanceof Cine){
				Cine p=(Cine)lista.get(i);
				m.addElement(p.getCodCine()+"-"+p.getNombre()+"-"+p.getTipo()+"-"+p.getDepartamento());
			}else if(lista.get(i) instanceof Pelicula){
				Pelicula p=(Pelicula)lista.get(i);
				m.addElement(p.getCodPeli()+"-"+p.getTitOriginal());
			}else if(lista.get(i) instanceof Sala){
				Sala p=(Sala)lista.get(i);
				m.addElement(p.getCodigo()+"-Nro:"+p.getNumSala()+"- Filas:"+p.getNumFila());
			} else if(lista.get(i) instanceof Empleado){
				Empleado p=(Empleado)lista.get(i);
				m.addElement(p.getCodEmpleado()+"-"+p.getNombre()+", "+p.getApePater()+" "+p.getApeMater());
			}  
		} 
	}
	public Dialogo() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		seleccionado="";
		setTitle("Seleccione el Cliente");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		list = new JList<>();  
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					okButton.doClick();
		        }
			}
		});
		list.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			@Override
			public void valueChanged(ListSelectionEvent e) { 
				if(e.getValueIsAdjusting()){
					seleccionado=list.getSelectedValue(); 
				}
			}
		});		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL); 
		list.setBounds(0, 0, 434, 228);
		contentPanel.add(list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Elegir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						seleccionado="";
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setLocationRelativeTo(null);
	}
}

