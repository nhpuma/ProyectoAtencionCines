package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Funcion;

public class ArregloFuncion {
	//ATRIBUTO PRIVADO
	private ArrayList <Funcion> fu;
	private String archivo;
	//CONSTRUCTOR 
	public ArregloFuncion(String archivo) {
		fu= new ArrayList <Funcion> ();
		this.archivo = archivo;
		cargarFuncion();
	}
	//METODOS SET/GET
	public ArrayList<Funcion> getFu() {
		return fu;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setFu(ArrayList<Funcion> fu) {
		this.fu = fu;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	//OPERACIONES
	public int tamaño(){
		return fu.size();
	}
	public Funcion obtener(int pos){
		return fu.get(pos);
	}
	public void adicionar(Funcion x){
		fu.add(x);
	}
	public void eliminar(Funcion x){
		fu.remove(x);
	}
	//GENERADOR DE CODIGO CORRELATIVO
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
		return obtener(tamaño()-1).getCodFuncion()+ 1;		
	}
	//METODO BUSCAR
	public Funcion buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodFuncion()== codigo)
				return obtener(i);
		return null;
	}
	//OPERACIONES PUBLICAS COMPLEMENTARIAS
			public void grabarFuncion() {
				try {
					PrintWriter pw;
					String linea;
					Funcion x;
					pw = new PrintWriter(new FileWriter(archivo));
					for (int i=0; i<tamaño(); i++) {
						x = obtener(i);
						linea = x.getCodFuncion() + ";" +
							    x.getCodCine()+ ";" +
								x.getCodSala() + ";" +
								x.getCodPeli() + ";" +
								x.getFecha()+ ";" +
								x.getHora();
						pw.println(linea);
					}
					pw.close();
				}
				catch (Exception e) {
				}
			}
		
			public void cargarFuncion() {
				try {
					BufferedReader br;
					String linea, fecha, hora;
					String s[];
					int codFuncion, codCine, codSala, codPeli;
					br = new BufferedReader(new FileReader(archivo));
					while ((linea = br.readLine()) != null) {
						s = linea.split(";");
						codFuncion = Integer.parseInt(s[0].trim());
						codCine = Integer.parseInt(s[1].trim());
						codSala = Integer.parseInt(s[2].trim());
						codPeli = Integer.parseInt(s[3].trim());
						fecha = s[4].trim();
						hora = s[5].trim();
						adicionar(new Funcion( codFuncion,  codCine,  codSala,  codPeli,  fecha,  hora));
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
