package controlador;

import java.util.ArrayList;

import clases.Cine;

public class ArregloCine {
	//atributo privado
	private ArrayList <Cine> cine;
	//constructor
	public ArregloCine(){
		cine= new ArrayList <Cine> ();

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
//  Operaciones públicas complementarias
	public Cine buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodCine()== codigo)
				return obtener(i);
		return null;
	}

}
