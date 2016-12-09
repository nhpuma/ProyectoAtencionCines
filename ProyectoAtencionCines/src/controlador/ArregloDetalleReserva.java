package controlador;

import clases.DetalleReserva;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author NielsenRichard
 */
public class ArregloDetalleReserva {
    //Atributos privados
    private ArrayList<DetalleReserva> detReserva;
    //Constructor

    public ArregloDetalleReserva() {
        detReserva = new ArrayList<DetalleReserva>();
        //cargarDetallesReservas();
    }
    //Operaciones públicas básicas
    public int tamanho(){
        return detReserva.size();
    }
    public DetalleReserva obtener(int i){
        return detReserva.get(i);
    }
    public void adicionar(DetalleReserva dr){
        detReserva.add(dr);
    }
    public void eliminar(DetalleReserva dr){
        detReserva.remove(dr);
    }
    //Métodos complementarios
    
    
    //Métodos para leer y escribir el fichero
    public void grabarDetalleReserva(){
        try {
            PrintWriter pw;
            DetalleReserva dr;
            String linea;
            
            pw = new PrintWriter(new FileWriter("DetalleReservas.txt"));
            
            for (int i = 0; i < tamanho(); i++) {
                dr = obtener(i);
                linea = dr.getCodButaca()+";"+
                        dr.getCodReserva()+";"+
                        dr.getTipoEntrada()+";"+
                        dr.getCantidad()+";"+
                        dr.getPrecio();
                
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error al escrbir en el fichero.\n"+e);
        }
    }
    public void cargarDetallesReservas(){
        try {
            BufferedReader br;
            String linea, s[];
            
            int codButaca, codReserva, tipoEntrada, cantidad;
            double precio;
            
            br = new BufferedReader(new FileReader("DetalleReservas.txt"));
            
            while((linea = br.readLine())!=null){
                s = linea.split(";");
                codButaca = Integer.parseInt(s[0]);
                codReserva = Integer.parseInt(s[1]);
                tipoEntrada = Integer.parseInt(s[2]);
                cantidad = Integer.parseInt(s[3]);
                precio = Double.parseDouble(s[4]);
                
                adicionar(new DetalleReserva(codButaca, codReserva, tipoEntrada, cantidad, precio));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error al leer el fichero.\n"+e);
        }
    }
    
}