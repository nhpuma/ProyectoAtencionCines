package clases;

public class Sala {
	//Atributos
	private int codigo; //Autogenerado desde 10001
	private int codCine; //Referencia a la Clase Cine
	private int numSala; 
	private int numFila;
	private int numButaca;
	//Constructor
	public Sala(int codigo, int codCine, int numSala, int numFila, int numButaca) {		
		this.codigo = codigo;
		this.codCine = codCine;
		this.numSala = numSala;
		this.numFila = numFila;
		this.numButaca = numButaca;
	}
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodCine() {
		return codCine;
	}
	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}
	public int getNumSala() {
		return numSala;
	}
	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
	public int getNumFila() {
		return numFila;
	}
	public void setNumFila(int numFila) {
		this.numFila = numFila;
	}
	public int getNumButaca() {
		return numButaca;
	}
	public void setNumButaca(int numButaca) {
		this.numButaca = numButaca;
	}
	//Métodos complementarios
}
