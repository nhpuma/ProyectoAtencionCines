package clases;

public class DetalleReserva {
    //Atributos privados
    private int codButaca; //Referencia Clase Butaca
    private int codReserva; //Referencia Clase Reserva
    private int tipoEntrada; //0=General, 1=Menores 11, 2=Mayores 60
    private int cantidad;
    private double precio;
    //COnstructor

    public DetalleReserva(int codButaca, int codReserva, int tipoEntrada, int cantidad, double precio) {
        this.codButaca = codButaca;
        this.codReserva = codReserva;
        this.tipoEntrada = tipoEntrada;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    //Getters and Setters

    public int getCodButaca() {
        return codButaca;
    }

    public void setCodButaca(int codButaca) {
        this.codButaca = codButaca;
    }

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public int getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(int tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    //Operaciones públicas
    public String detalleTipoEntrada(){
        switch(tipoEntrada){
            case 0:
                return "General";
            case 1:
                return "Menores de 11 años";
            default:
                return "Mayores de 60 años";
        }
    }
}