package controlador;

import java.util.ArrayList;

import clases.Cine;
import clases.Empleado;

public class ArregloEmpleado {
	//atributo privado
	
	private ArrayList <Empleado> empleado;
	
	//constructor 
	public ArregloEmpleado(){
		empleado= new ArrayList <Empleado>(); 
	} 
	
	//operaciones publicas basicas
		public int tamano(){
			return empleado.size();
		}
		public Empleado obtener (int pos){
			return empleado.get(pos);
		}
		public void adicionar(Empleado x){
			empleado.add(x);
		}
		public void eliminar(Empleado x){
			empleado.remove(x);
		}
	
	//  Operaciones públicas complementarias
		public Empleado buscar(int codigo) {
			for (int i=0; i<tamano(); i++)
				if (obtener(i).getCodigoEmp()== codigo)
					return obtener(i);
			return null;
		}
	
	
	//Correlativo
		public int cod_Correlativo(){
			if(tamano() == 0)
				return 10001;
			else
				return obtener(tamano()-1).getCodigoEmp()+1;
		}
		
}
