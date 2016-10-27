package clases;

public class Cliente {
	private int codCliente;
	private String nombre;
	private String apepat;
	private String apermat;
	private String direccion;
	private String fechanacimiento;
	private String fechaafiliacion;
	private int estadocivil;
	private String telefono;
	private String dni;
	private String usuario;
	private String contraseña;
	public Cliente(int codCliente, String nombre, String apepat, String apermat, String direccion,
			String fechanacimiento, String fechaafiliacion, int estadocivil, String telefono, String dni,
			String usuario, String contraseña) {
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.apepat = apepat;
		this.apermat = apermat;
		this.direccion = direccion;
		this.fechanacimiento = fechanacimiento;
		this.fechaafiliacion = fechaafiliacion;
		this.estadocivil = estadocivil;
		this.telefono = telefono;
		this.dni = dni;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApepat() {
		return apepat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public String getApermat() {
		return apermat;
	}
	public void setApermat(String apermat) {
		this.apermat = apermat;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public String getFechaafiliacion() {
		return fechaafiliacion;
	}
	public void setFechaafiliacion(String fechaafiliacion) {
		this.fechaafiliacion = fechaafiliacion;
	}
	public int getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(int estadocivil) {
		this.estadocivil = estadocivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}