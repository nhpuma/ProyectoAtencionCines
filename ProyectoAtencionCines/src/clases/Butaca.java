package clases;

public class Butaca {
	//ATRIBUTOS PRIVADOS
	private int codButaca;
	private int codSala;
	private int numFila;
	private int numColumna;
	private int estado;
	//CONSTRUCTOR
	public Butaca(int codButaca, int codSala, int numFila, int numColumna, int estado) {
		this.codButaca = codButaca;
		this.codSala = codSala;
		this.numFila = numFila;
		this.numColumna = numColumna;
		this.estado = estado;
	}
	//Metodos set/get
	public int getCodButaca() {
		return codButaca;
	}
	public int getCodSala() {
		return codSala;
	}
	public int getNumFila() {
		return numFila;
	}
	public int getNumColumna() {
		return numColumna;
	}
	public int getEstado() {
		return estado;
	}
	public void setCodButaca(int codButaca) {
		this.codButaca = codButaca;
	}
	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}
	public void setNumFila(int numFila) {
		this.numFila = numFila;
	}
	public void setNumColumna(int numColumna) {
		this.numColumna = numColumna;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	//OPERACIONES PUBLICAS
	public String estadoButaca(){
		switch(estado){
		case 0:
			return "Ocupado";
		default:
			return "Disponible";
		}
	}
	
	

}
