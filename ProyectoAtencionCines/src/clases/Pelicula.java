package clases;

public class Pelicula {
//ATRIBUTOS PRIVADOS DE LA CLASE
	private int codPeli;
	private String titDistribucion;
	private String titOriginal;
	private String fechaEstreno;
	private int tipoProyeccion;
	private int genero;
	private String PaisOrigen;
	private String sinopsis;
	private int duracion;
	private int tipoCensura;
	private int estadoProyeccion;
	private double recaudacion;
	
	//CONSTRUCTOR DE LA CLASE
	public Pelicula(int codPeli, String titDistribucion, String titOriginal, String fechaEstreno, int tipoProyeccion,
			int genero, String paisOrigen, String sinopsis, int duracion, int tipoCensura, int estadoProyeccion,
			double recaudacion) {
		this.codPeli = codPeli;
		this.titDistribucion = titDistribucion;
		this.titOriginal = titOriginal;
		this.fechaEstreno = fechaEstreno;
		this.tipoProyeccion = tipoProyeccion;
		this.genero = genero;
		PaisOrigen = paisOrigen;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.tipoCensura = tipoCensura;
		this.estadoProyeccion = estadoProyeccion;
		this.recaudacion = recaudacion;
	}
	//METODOS GET/SET
	public int getCodPeli() {
		return codPeli;
	}
	public String getTitDistribucion() {
		return titDistribucion;
	}
	public String getTitOriginal() {
		return titOriginal;
	}
	public String getFechaEstreno() {
		return fechaEstreno;
	}
	public int getTipoProyeccion() {
		return tipoProyeccion;
	}
	public int getGenero() {
		return genero;
	}
	public String getPaisOrigen() {
		return PaisOrigen;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public int getDuracion() {
		return duracion;
	}
	public int getTipoCensura() {
		return tipoCensura;
	}
	public int getEstadoProyeccion() {
		return estadoProyeccion;
	}
	public double getRecaudacion() {
		return recaudacion;
	}
	public void setCodPeli(int codPeli) {
		this.codPeli = codPeli;
	}
	public void setTitDistribucion(String titDistribucion) {
		this.titDistribucion = titDistribucion;
	}
	public void setTitOriginal(String titOriginal) {
		this.titOriginal = titOriginal;
	}
	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public void setTipoProyeccion(int tipoProyeccion) {
		this.tipoProyeccion = tipoProyeccion;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public void setPaisOrigen(String paisOrigen) {
		PaisOrigen = paisOrigen;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public void setTipoCensura(int tipoCensura) {
		this.tipoCensura = tipoCensura;
	}
	public void setEstadoProyeccion(int estadoProyeccion) {
		this.estadoProyeccion = estadoProyeccion;
	}
	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}
	
	//OPERACIONES PUBLICAS
	public String tipo_Proyeccion(){
		switch(tipoProyeccion){
		case 0:
			return "Estreno";
		default:
			return "Fuera de Estreno";
		}
	}
	public String Censura(){
		switch(tipoCensura){
		case 0:
			return "Apta para todos";
		case 1:
			return "Mayores de 14 años";
		default:
			return "Mayores de 18 años";
		}
	}
	
	public String estado_proyeccion(){
		switch(estadoProyeccion){
		case 0:
			return "En cartelera";
		default:
			return "Fuera de cartelera";
		}
	}
	public String GeneroPelicula(){
		switch(genero){
		case 0:
			return "Accion";
		case 1:
			return "Animacion";
		case 2:
			return "Aventura";
		case 3:
			return "Ciencia ficcion";
		case 4:
			return "Comedia";
		case 5:
			return "Drama";
		case 6:
			return "Musical";
		case 7:
			return "Romántico";
		default :
			return "Terror";
		}
	}
}








































