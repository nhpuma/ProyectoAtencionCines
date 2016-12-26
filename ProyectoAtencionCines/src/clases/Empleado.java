package clases;

public class Empleado {
	//ATRIBUTOS PRIVADOS
	private int codEmpleado;
	private String nombre;
	private String apePater;
	private String apeMater;
	private int tipoEmpleado;
	private String usuario;
	private String contraseña;
	//CONSTRUCTOR DE LA CLASE
	public Empleado(int codEmpleado, String nombre, String apePater, String apeMater, int tipoEmpleado, String usuario,
			String contraseña) {
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.apePater = apePater;
		this.apeMater = apeMater;
		this.tipoEmpleado = tipoEmpleado;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	//METODOS GET/SET
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApePater() {
		return apePater;
	}
	public String getApeMater() {
		return apeMater;
	}
	public int getTipoEmpleado() {
		return tipoEmpleado;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApePater(String apePater) {
		this.apePater = apePater;
	}
	public void setApeMater(String apeMater) {
		this.apeMater = apeMater;
	}
	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	//OPERACIONES PUBLICAS
	public String tipo_Empleado(){
		switch (tipoEmpleado){
		case 0:
			return "Administrador";
		case 1:
			return "Supervisor";
		default:
			return "Cajero";
		}
	}
	public String Usuario(){
		return nombre.charAt(0)+"";
	}
	
	

}
