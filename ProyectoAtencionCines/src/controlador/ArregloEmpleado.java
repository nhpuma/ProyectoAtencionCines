package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cine;
import clases.Empleado;

public class ArregloEmpleado {
	//atributo privado
	
	private ArrayList <Empleado> empleado;
	private String archivo;
	//constructor
	public ArregloEmpleado(String archivo){
		empleado= new ArrayList <Empleado> ();
		this.archivo=archivo;
		cargarEmpleado();
	
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
		
		public void grabarEmpleado() {
			try {
				PrintWriter pw;
				String linea;
				Empleado x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i=0; i<tamano(); i++) {
					x = obtener(i);
					linea = x.getCodigoEmp() + ";" +
						    x.getNombres() + ";" +
							x.getApellido_paterno() + ";" +
							x.getApellido_materno() + ";" +
							x.getTipo() + ";" +
							x.getUsuario() + ";" +
							x.getContrasena();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}
		public void cargarEmpleado() {
			try {
				BufferedReader br;
				String linea, nombres;
				String s[];
				int codigoEmp;
				int tipo;
				String  apellido_paterno, apellido_materno,usuario, contrasena; 
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codigoEmp = Integer.parseInt(s[0].trim());
					tipo =  Integer.parseInt(s[1].trim());
					nombres = s[2].trim();
					apellido_paterno = s[3].trim();
					apellido_materno= s[4].trim();
					usuario = s[5].trim();
					contrasena = s[5].trim();
					adicionar(new Empleado( codigoEmp, tipo,nombres,  apellido_paterno, apellido_materno,
							 usuario, contrasena));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}		
		
}
