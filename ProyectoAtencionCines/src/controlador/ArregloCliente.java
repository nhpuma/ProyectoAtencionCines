package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;

public class ArregloCliente {
	//atributo privado
	private ArrayList <Cliente> cliente;
	private String archivo;
	//constructor 
	public ArregloCliente(String archivo){
		cliente= new ArrayList <Cliente>(); 
		this.archivo=archivo;
		cargarCliente();
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
	//operaciones complementarias
	public void grabarCliente() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i=0; i<tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodCliente() + ";" +
					    x.getNombre() + ";" +
						x.getApepat() + ";" +
						x.getApemat() + ";" +
						x.getDireccion() + ";" +
						x.getFechanacimiento() + ";" +
						x.getFechaafiliacion() + ";" +
						x.getEstadocivil() + ";" +
						x.getTelefono() + ";" +
						x.getDni() + ";" +
						x.getUsuario() + ";" +
						x.getContraseña();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	public void cargarCliente() {
		try {
			BufferedReader br;
			String linea, nombre;
			String s[];
			int codCliente;
			String apepat,apermat,direccion,fechanacimiento,fechaafiliacion, telefono,
			dni,usuario,contraseña;
			int estadocivil; 
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCliente = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apepat = s[2].trim();
				apermat = s[3].trim();
				direccion = s[4].trim();
				fechanacimiento = s[5].trim();
				fechaafiliacion = s[6].trim();
				estadocivil = Integer.parseInt(s[7].trim());
				telefono = s[8].trim();
				dni = s[9].trim();
				usuario = s[10].trim();
				contraseña = s[11].trim();
				adicionar(new Cliente(codCliente,nombre,apepat,apermat,direccion,fechanacimiento,fechaafiliacion,estadocivil,
						telefono,dni,usuario,contraseña));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}		
	
}
