package clases;

public class Empleado {
	//atributos privados
	
		private int codigoEmp, tipo;
		//Autogenerado y correlativo a partir de 10001 
		
		private String nombres, apellido_paterno, apellido_materno, usuario, contrasena;
		
		//constructor
		public Empleado(int codigoEmp, int tipo, String nombres, String apellido_paterno, String apellido_materno,
				String usuario, String contrasena) {
			super();
			this.codigoEmp = codigoEmp;
			this.tipo = tipo;
			this.nombres = nombres;
			this.apellido_paterno = apellido_paterno;
			this.apellido_materno = apellido_materno;
			this.usuario = usuario;
			this.contrasena = contrasena;
		}

		//METODOS GET and SET
		
		public int getCodigoEmp() {
			return codigoEmp;
		}

		public void setCodigoEmp(int codigoEmp) {
			this.codigoEmp = codigoEmp;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public String getNombres() {
			return nombres;
		}

		public void setNombres(String nombres) {
			this.nombres = nombres;
		}

		public String getApellido_paterno() {
			return apellido_paterno;
		}

		public void setApellido_paterno(String apellido_paterno) {
			this.apellido_paterno = apellido_paterno;
		}

		public String getApellido_materno() {
			return apellido_materno;
		}

		public void setApellido_materno(String apellido_materno) {
			this.apellido_materno = apellido_materno;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		
		// DEFINIENDO LOS TIPOS DE EMPLEADOS
		//0 = Administrador  1 = Supervisor  2 = Cajero 
		
		public String tipoEmpleado(){
			switch(tipo){
			case 0: return "Administrador";
			case 1: return "Supervisor";
			case 2: return "Cajero";
			default: return "error de eleccion";
			}
			
		}
		
}
