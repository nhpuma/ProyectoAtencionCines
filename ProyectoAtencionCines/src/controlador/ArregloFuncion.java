package controlador;

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
	}
	
	public int tamaño(){
		return fu.size();
	}
	
	

}
