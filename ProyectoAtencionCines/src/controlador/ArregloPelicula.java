package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cine;
import clases.Pelicula;

public class ArregloPelicula {
	//ATRIBUTO PRIVADO
	private ArrayList <Pelicula> peli;
	private String archivo;
	//CONSTRUCTOR
	public ArregloPelicula( String archivo){
		peli = new ArrayList <Pelicula> ();
		this.archivo = archivo;
		cargarPelicula();
	}
	
	//operaciones publicas basicas
	public int tamanio(){
		return peli.size();
	}
	public Pelicula obtener (int pos){
		return peli.get(pos);
	}
	public void adicionar(Pelicula x){
		peli.add(x);
	}

	public void eliminar(Pelicula x){
		peli.remove(x);
	}
	//GENERADOR DE CODIGO CORRELATIVO
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio()-1).getCodPeli() + 1;		
	}
	//METODO BUSACR
	public Pelicula buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodPeli()== codigo)
				return obtener(i);
		return null;
	}
	//OPERACIONES PUBLICAS COMPLEMENTARIAS
	public void grabarPelicula() {
		try {
			PrintWriter pw;
			String linea;
			Pelicula x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodPeli() + ";" +
					    x.getTitDistribucion() + ";" +
						x.getTitOriginal() + ";" +
						x.getFechaEstreno() + ";" +
						x.getTipoProyeccion()+ ";" +
						x.getGenero()+ ";" +
						x.getPaisOrigen() + ";" +
						x.getSinopsis() + ";" +
						x.getDuracion() + ";" +
						x.getTipoCensura() + ";" +
						x.getEstadoProyeccion()+ ";" +
						x.getRecaudacion();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public void cargarPelicula() {
		try {
			BufferedReader br;
			String linea, titDistribucion,titOriginal, fechaEstreno, genero, paisOrigen, sinopsis ;
			String s[];
			int codPeli, tipoProyeccion, duracion, tipoCensura, estadoProyeccion;
			double recaudacion;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codPeli = Integer.parseInt(s[0].trim());
				titDistribucion = s[1].trim();
				titOriginal = s[2].trim();
				fechaEstreno = s[3].trim();
				tipoProyeccion = Integer.parseInt(s[4].trim());
				genero= s[5].trim();
				paisOrigen= s[6].trim();
				sinopsis= s[7].trim();
				duracion = Integer.parseInt(s[8].trim());
				tipoCensura= Integer.parseInt(s[9].trim());
				estadoProyeccion = Integer.parseInt(s[10].trim());
				recaudacion = Double.parseDouble(s[11].trim());
				adicionar(new Pelicula(codPeli,  titDistribucion, titOriginal,  fechaEstreno, tipoProyeccion,
					genero, paisOrigen, sinopsis, duracion,  tipoCensura,  estadoProyeccion,
						 recaudacion));
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
























