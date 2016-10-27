package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cine;

public class ArregloCine {
	//atributo privado
	private ArrayList <Cine> cine;
	private String archivo;
	//constructor
	public ArregloCine(){
		cine= new ArrayList <Cine> ();
		cine.add(new Cine(123,"cineplamnet","lima","tacna","Jauja","25/02/1998",0));
		cine.add(new Cine(124,"cinemark","perene","huancayo","Jauja","25/02/2005",0));
		cine.add(new Cine(125,"cinestar","arequipa","huancayo","angamos","25/02/2008",0));

	}
	//operaciones publicas basicas
	public int tamanio(){
		return cine.size();
	}
	public Cine obtener (int pos){
		return cine.get(pos);
	}
	public void adicionar(Cine x){
		cine.add(x);
	}

	public void eliminar(Cine x){
		cine.remove(x);
	}
//  Operaciones p�blicas complementarias
	public Cine buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodCine()== codigo)
				return obtener(i);
		return null;
	}
	public void grabarPersonas() {
		try {
			PrintWriter pw;
			String linea;
			Cine x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodCine() + ";" +
					    x.getNombre() + ";" +
						x.getDepartamento() + ";" +
						x.getProvincia() + ";" +
						x.getDistrito() + ";" +
						x.getFechaInicio() + ";" +
						x.getTipo();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarPersonas() {
		try {
			BufferedReader br;
			String linea, nombre;
			String s[];
			int codCine;
			String departamento, provincia, distrito, fechaInicio;
			int tipo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCine = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				departamento = s[2].trim();
				provincia = s[3].trim();
				distrito = s[4].trim();
				fechaInicio = s[5].trim();
				tipo = Integer.parseInt(s[6].trim());
				adicionar(new Cine( codCine, nombre, departamento, provincia, distrito, fechaInicio,
						 tipo));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}		

}
