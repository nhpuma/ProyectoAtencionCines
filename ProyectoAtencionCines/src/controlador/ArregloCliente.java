package controlador;

import java.util.ArrayList;

import clases.Cliente;
import clases.Sala;

public class ArregloCliente {
	//atributo privado
	private ArrayList <Cliente> cliente;
	//constructor 
	public ArregloCliente(){
		cliente= new ArrayList <Cliente>(); 
		} 
	public int tamanio(){
		return cliente.size();
	}
	public Cliente obtener (int pos){
		return cliente.get(pos);
	}
	public void adicionar(Cliente x){
		cliente.add(x);
	}
	public void eliminar(Cliente x){
		cliente.remove(x);
	}
	public Cliente buscar(int cod){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getCodCliente()==cod)
				return obtener(i);
		}
		return null;
	}
	public int codcor(){
		if(tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio()-1).getCodCliente()+1;
	}
	
}
