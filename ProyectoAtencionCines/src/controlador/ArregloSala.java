package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Sala;

public class ArregloSala {
	//Atributo privado
	private ArrayList<Sala> sala;
	private String archivo;
	//Constructor

	public ArregloSala() {
		sala = new ArrayList<Sala>();
		this.archivo = archivo;
	}
	//METODOS SET/GET
	public ArrayList<Sala> getSala() {
		return sala;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setSala(ArrayList<Sala> sala) {
		this.sala = sala;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	//Operaciones públicas básicas
	public int tamanho(){
		return sala.size();
	}
	public Sala obtener(int cod){
		return sala.get(cod);
	}
	public void adicionar(Sala x){
		sala.add(x);
	}
	public void eliminar(Sala x){
		sala.remove(x);
	}
	//Operaciones complementarias
	public Sala buscar(int cod){
		for(int i=0; i<tamanho(); i++){
			if(obtener(i).getCodigo()==cod)
				return obtener(i);
		}
		return null;
	}
	//Correlativo
	public int codigoCorrelativo(){
		if(tamanho() == 0)
			return 10001;
		else
			return obtener(tamanho()-1).getCodigo()+1;
	}
	//GRABAR
	public void grabarSala() {
		try {
			PrintWriter pw;
			String linea;
			Sala x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamanho(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getCodCine() + ";" +
						x.getNumSala() + ";" +
						x.getNumFila() + ";" +
						x.getNumButaca();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarSala() {
		try {
			BufferedReader br;
			String linea;
			String s[];
			int codigo, codCine, numSala, numFila, numButaca;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				codCine = Integer.parseInt(s[1].trim());
				numSala = Integer.parseInt(s[2].trim());
				numFila = Integer.parseInt(s[3].trim());
				numButaca = Integer.parseInt(s[4].trim());
				adicionar(new Sala( codigo,  codCine,  numSala,  numFila,  numButaca));
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
