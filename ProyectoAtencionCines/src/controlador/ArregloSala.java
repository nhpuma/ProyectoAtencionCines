package controlador;

import java.util.ArrayList;

import clases.Sala;

public class ArregloSala {
	//Atributo privado
	private ArrayList<Sala> sala;
	//Constructor

	public ArregloSala() {
		sala = new ArrayList<Sala>();
		sala.add(new Sala(123, 1, 2, 5, 20));
		sala.add(new Sala(124, 4, 3, 3, 12));
		sala.add(new Sala(125, 7, 4, 4, 16));
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
}
