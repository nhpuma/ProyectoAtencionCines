package clases;

public class Reserva {
	//ATRIBUTOS PRIVADOS
	private int codReserva;
	private int codCliente;
	private int codEmpleado;
	private int codiFuncion;
	private String fechaReserva;
	private String horaReserva;
	private int estado;
	//CONSTRUCTOR
	public Reserva(int codReserva, int codCliente, int codEmpleado, int codiFuncion, String fechaReserva,
			String horaReserva, int estado) {
		this.codReserva = codReserva;
		this.codCliente = codCliente;
		this.codEmpleado = codEmpleado;
		this.codiFuncion = codiFuncion;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.estado = estado;
	}
	//METODOS SET/GET
	public int getCodReserva() {
		return codReserva;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public int getCodiFuncion() {
		return codiFuncion;
	}
	public String getFechaReserva() {
		return fechaReserva;
	}
	public String getHoraReserva() {
		return horaReserva;
	}
	public int getEstado() {
		return estado;
	}
	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public void setCodiFuncion(int codiFuncion) {
		this.codiFuncion = codiFuncion;
	}
	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	//OPERACIONES PUBLICAS
	public String estadoReserva(){
		switch(estado){
		case 0:
			return "Reservada";
		case 1:
			return "Reserva Usada";
		case 2:
			return "Reserva Cancelada";
		default:
			return "Reserva Caducada";
		}
	}
	

}
