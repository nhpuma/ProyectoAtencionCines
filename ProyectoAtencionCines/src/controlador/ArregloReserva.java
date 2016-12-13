package controlador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Reserva;

public class ArregloReserva {
	//ATRIBUTO PRIVADO
	private ArrayList <Reserva> re;
	private String archivo;
	//CONSTRUCTOR
	public ArregloReserva(String archivo){
		re = new ArrayList <Reserva> ();
		this.archivo = archivo;
		cargarReserva();
	}
	//OPERACIONES
	public int tamaño(){
		return re.size();
	}
	public Reserva obtener(int pos){
		return re.get(pos);
	}
	public void adicionar(Reserva x){
		re.add(x);
		
	}
	public void eliminar(Reserva x){
		re.remove(x);
	}
	//GENERADOR DE CODIGO CORRELATIVO
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
	return obtener(tamaño()-1).getCodReserva()+ 1;		
	}
		//METODO BUSCAR
	public Reserva buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodReserva()== codigo)
				return obtener(i);
		return null;
		}
		//OPERACIONES PUBLICAS COMPLEMENTARIAS
	public void grabarReserva() {
		try {
			PrintWriter pw;
			String linea;
			Reserva x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodReserva() + ";" +
						x.getCodCliente()+ ";" +
						x.getCodEmpleado() + ";" +
						x.getCodFuncion() + ";" +
						x.getFechaReserva()+ ";" +
						x.getHoraReserva()+ ";" +
						x.getEstado();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
	}
	
	public void cargarReserva() {
		try {
			BufferedReader br;
			String linea, fechaReserva, horaReserva;
			String s[];
			int codReserva, codCliente, codEmpleado, codFuncion, estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codReserva = Integer.parseInt(s[0].trim());
				codCliente = Integer.parseInt(s[1].trim());
				codEmpleado = Integer.parseInt(s[2].trim());
				codFuncion = Integer.parseInt(s[3].trim());
				estado = Integer.parseInt(s[4].trim());
				fechaReserva = s[5].trim();
				horaReserva = s[6].trim();
				adicionar(new Reserva(  codReserva,  codCliente,  codEmpleado,  codFuncion,  estado,  fechaReserva,
				horaReserva));
				}
				br.close();
			}
			catch (Exception e) {
			}
	}		
	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}	
}
