package practica;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Estudiante
 */
public abstract class Sensor {
    protected String marca;
    protected String referencia;
    protected String fecha;
    protected String fechaLectura;
    protected HashMap<String, Integer> registros = new HashMap<>();
    protected ArrayList<Integer> datos = new ArrayList<>();

    public Sensor(String marca, String referencia, String fecha) {
        this.marca = marca;
        this.referencia = referencia;
        this.fecha = fecha;
    }
    
    protected abstract void addRegistro(int registro, String fecha);
    protected abstract int getRegistroFecha(String FechaDelRegistro);
    protected abstract double calcPromedio();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(String fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public HashMap<String, Integer> getRegistros() {
        return registros;
    }

    public void setRegistros(HashMap<String, Integer> registros) {
        this.registros = registros;
    }

    public ArrayList<Integer> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Integer> datos) {
        this.datos = datos;
    }  
    
}
