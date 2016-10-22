package controlador;

import java.util.ArrayList;

import clases.Sala;

public class ArregloSala {
	//Atributo privado
	private ArrayList<Sala> sala;
	//Constructor

	public ArregloSala() {
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
}
