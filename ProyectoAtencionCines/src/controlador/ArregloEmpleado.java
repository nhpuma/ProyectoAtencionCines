package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Empleado;

public class ArregloEmpleado {
	//ATRIBUTO PRIVADO
	private ArrayList <Empleado> emp;
	private String archivo;
	//CONSTRUCTOR
	public ArregloEmpleado(String archivo){
		emp = new ArrayList <Empleado> ();
		this.archivo = archivo;
		cargarEmpleado();
	}
	//METODOS SET/ GET
	public ArrayList<Empleado> getEmp() {
		return emp;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setEmp(ArrayList<Empleado> emp) {
		this.emp = emp;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	//OPERACIONES PUBLICAS
	public int tamanio(){
		return emp.size();
	}
	public Empleado obtener(int pos){
		return emp.get(pos);
	}
	public void adicionar(Empleado x){
		emp.add(x);
	}
	public void eliminar(Empleado x){
		emp.remove(x);
	}
	//GENERADOR DE CODIGO CORRELATIVO
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 10001;
		else
		return obtener(tamanio()-1).getCodEmpleado() + 1;		
	}
	
	//METODO BUSCAR
	public Empleado buscar(int codigo) {
		for (int i=0; i<tamanio(); i++)
			if (obtener(i).getCodEmpleado()== codigo)
				return obtener(i);
		return null;
	}
	//OPERACIONES PUBLICAS COMPLEMENTARIAS
		public void grabarEmpleado() {
			try {
				PrintWriter pw;
				String linea;
				Empleado x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i=0; i<tamanio(); i++) {
					x = obtener(i);
					linea = x.getCodEmpleado() + ";" +
						    x.getNombre() + ";" +
							x.getApePater() + ";" +
							x.getApeMater() + ";" +
							x.getTipoEmpleado()+ ";" +
							x.getUsuario()+ ";" +
							x.getContraseña();
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
				String linea, nombre, apePater, apeMater, usuario, contraseña ;
				String s[];
				int codEmpleado, tipoEmpleado;
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codEmpleado = Integer.parseInt(s[0].trim());
					nombre = s[1].trim();
					apePater = s[2].trim();
					apeMater = s[3].trim();
					tipoEmpleado = Integer.parseInt(s[4].trim());
					usuario = s[5].trim();
					contraseña = s[6].trim();
					adicionar(new Empleado(codEmpleado,nombre, apePater, apeMater, tipoEmpleado, usuario,
							contraseña));
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

