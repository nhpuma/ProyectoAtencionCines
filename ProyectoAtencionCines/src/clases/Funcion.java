package clases;

public class Funcion {
	//ATRIBUTOS PRIVADOS
	private int codFuncion, codCine, codSala, codPeli;
	private String fecha, hora;
	//CONSTRUCTOR
	public Funcion(int codFuncion, int codCine, int codSala, int codPeli, String fecha, String hora) {
		this.codFuncion = codFuncion;
		this.codCine = codCine;
		this.codSala = codSala;
		this.codPeli = codPeli;
		this.fecha = fecha;
		this.hora = hora;
	}
	//METODO SET/GET
	public int getCodFuncion() {
		return codFuncion;
	}
	public int getCodCine() {
		return codCine;
	}
	public int getCodSala() {
		return codSala;
	}
	public int getCodPeli() {
		return codPeli;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setCodFuncion(int codFuncion) {
		this.codFuncion = codFuncion;
	}
	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}
	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}
	public void setCodPeli(int codPeli) {
		this.codPeli = codPeli;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	

}
