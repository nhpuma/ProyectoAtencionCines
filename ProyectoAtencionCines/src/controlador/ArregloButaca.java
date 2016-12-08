package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Butaca;

public class ArregloButaca {
	//ATRIBUTO PRIVADO
	private ArrayList <Butaca> but;
	private String archivo;
	
	//CONSTRUCTOR
	public ArregloButaca(){
		but = new ArrayList <Butaca> ();
		this.archivo = archivo;
	}
	
	public int tamaño(){
		return but.size();
	}
	public Butaca obtener(int pos){
		return but.get(pos);
	}
	public void adicionar(Butaca b){
		but.add(b);
	}
	public void eliminar(Butaca b){
		but.remove(b);
	}
	//GENERADOR DE CODIGO CORRELATIVO
		public int codigoCorrelativo() {
			if (tamaño() == 0)
				return 10001;
			else
			return obtener(tamaño()-1).getCodButaca() + 1;		
		}
	//BUSCAR
	public Butaca buscar(int codigo){
		for(int i=0; i<tamaño(); i++){
			if(obtener(i).getCodButaca()==codigo)
				return obtener(i);
		}
		return null;
	}
	
	//OPERACIONES PUBLICAS COMPLEMENTARIAS
			public void grabarButaca() {
				try {
					PrintWriter pw;
					String linea;
					Butaca x;
					pw = new PrintWriter(new FileWriter(archivo));
					for (int i=0; i<tamaño(); i++) {
						x = obtener(i);
						linea = x.getCodButaca() + ";" +
							    x.getCodSala() + ";" +
								x.getNumFila() + ";" +
								x.getNumColumna() + ";" +
								x.getEstado();
						pw.println(linea);
					}
					pw.close();
				}
				catch (Exception e) {
				}
			}
		
			public void cargarButaca() {
				try {
					BufferedReader br;
					String linea;
					String s[];
					int codButaca, codSala, numFila, numColumna, estado;
					br = new BufferedReader(new FileReader(archivo));
					while ((linea = br.readLine()) != null) {
						s = linea.split(";");
						codButaca = Integer.parseInt(s[0].trim());
						codSala = Integer.parseInt(s[1].trim());
						numFila = Integer.parseInt(s[2].trim());
						numColumna = Integer.parseInt(s[3].trim());
						estado = Integer.parseInt(s[4].trim());
						
						adicionar(new Butaca( codButaca,  codSala,  numFila,  numColumna,  estado));
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
