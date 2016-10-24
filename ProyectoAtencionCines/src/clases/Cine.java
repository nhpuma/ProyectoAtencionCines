package clases;

public class Cine {
	//atributos privados de la clase
	private int codCine;
	private String nombre;
	private String departamento;
	private String provincia;
	private String distrito;
	private String fechaInicio;
	private int tipo;
	//constructor de la clase
	public Cine(int codCine, String nombre, String departamento, String provincia, String distrito, String fechaInicio,
			int tipo) {
		
		this.codCine = codCine;
		this.nombre = nombre;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.fechaInicio = fechaInicio;
		this.tipo = tipo;
	}
	//metodos set/get
	public int getCodCine() {
		return codCine;
	}

	public void setCodCine(int codCine) {
		this.codCine = codCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	//operaciones publicas
	public String tipoCine(){
		switch (tipo){
		case 0:
			return "Estandar";
		default:
			return "Prime";
		}
	}


	
	

}











