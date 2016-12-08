package clases;

public class Reserva {
	//ATRIBUTOS PRIVADOS
		private int codReserva, codCliente, codEmpleado, codFuncion,estado ;
		private String fechaReserva, horaReserva;
	
	//constructor
		
		public Reserva(int codReserva, int codCliente, int codEmpleado, int codFuncion, int estado, String fechaReserva,
				String horaReserva) {
			super();
			this.codReserva = codReserva;
			this.codCliente = codCliente;
			this.codEmpleado = codEmpleado;
			this.codFuncion = codFuncion;
			this.estado = estado;
			this.fechaReserva = fechaReserva;
			this.horaReserva = horaReserva;
		}
		
		//metodos get y set
		
		public int getCodReserva() {
			return codReserva;
		}

		public void setCodReserva(int codReserva) {
			this.codReserva = codReserva;
		}

		public int getCodCliente() {
			return codCliente;
		}

		public void setCodCliente(int codCliente) {
			this.codCliente = codCliente;
		}

		public int getCodEmpleado() {
			return codEmpleado;
		}

		public void setCodEmpleado(int codEmpleado) {
			this.codEmpleado = codEmpleado;
		}

		public int getCodFuncion() {
			return codFuncion;
		}

		public void setCodFuncion(int codFuncion) {
			this.codFuncion = codFuncion;
		}

		public int getEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}

		public String getFechaReserva() {
			return fechaReserva;
		}

		public void setFechaReserva(String fechaReserva) {
			this.fechaReserva = fechaReserva;
		}

		public String getHoraReserva() {
			return horaReserva;
		}

		public void setHoraReserva(String horaReserva) {
			this.horaReserva = horaReserva;
		}
		
		//operacion publica
		
		public String estado_Reserva(){
			switch(estado){
			case 0:
				return "Reservada";
			case 1:
				return "Reserva usada";
			case 2:
				return "Reserva cancelada";
			default:
				return "Reserva caducada";
			}
		}
		
		
		
}
