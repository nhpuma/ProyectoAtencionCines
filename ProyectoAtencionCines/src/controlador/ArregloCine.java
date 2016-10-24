package controlador;

import java.util.ArrayList;

import clases.Cine;
import clases.Sala;

public class ArregloCine {
	//atributo privado
	private ArrayList <Cine> cine;
	//constructor
	public ArregloCine(){
		cine= new ArrayList <Cine> ();
		cine.add(new Cine(123,"Carlos","Lima","Lima","SJL","22/12/1998",0));
		cine.add(new Cine(123,"Maria","Junin","Huancayo","Jauja","01/07/2007",1));
		cine.add(new Cine(123,"Carlos","Lima","Lima","Lima","17/02/2001",0));
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

}
