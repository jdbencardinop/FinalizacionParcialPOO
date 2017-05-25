package practica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Ciudad {
    private String nombre;
    private final ArrayList<Estacion> estaciones = new ArrayList<>();
    protected HashMap<String, Estacion> registros = new HashMap<>();

    public Ciudad(String nombre) {
        this.nombre = nombre;
        
    }
    
    public void addEstacion(Estacion e) {
        this.estaciones.add(e);
        this.registros.put(e.getNombre(), e);
    }
    
    public String ActualizarRegistro() {
        String s = this.nombre + "\n\n" + this.estaciones.size() + "\n\n";
        for (Estacion estacione : estaciones) {
            s += estacione.ToStringAll();
        }
        return s;
    }
    
    public void PopulateEstaciones(int i, Scanner s, String fecha) {        
        //s.nextLine();
        for (int j = 0; j < i; j++) {
            String name = s.next();
            System.out.println("nombre estacion " + name);
            int reg = s.nextInt();
            System.out.println("carajo es un 4? " + reg + " !");
            if (this.registros.containsKey(name)) {
                System.out.println("Lo tiene");
                this.registros.get(name).PopulateRegistros(reg, s);
            } else {
                System.out.println("Lo creó");
                Estacion e = new Estacion(name, this.nombre, fecha);
                e.PopulateRegistros(reg, s);
                this.addEstacion(e);
            }
        }        
    }
    
    public double promedioAgua() {
        double d = 0;
        d = estaciones.stream().map((estacion) -> estacion.promedioAgua()).reduce(d, (accumulator, _item) -> accumulator + _item);
        d /= this.estaciones.size();
        return d;
    }
    
    public double promedioTemp() {
        double d = 0;
        d = estaciones.stream().map((estacione) -> estacione.promedioTemp()).reduce(d, (accumulator, _item) -> accumulator + _item);
        d /= this.estaciones.size();
        return d;
    }
    
    public double promedioCarga() {
        double d = 0;
        d = estaciones.stream().map((estacione) -> estacione.promedioCarga()).reduce(d, (accumulator, _item) -> accumulator + _item);
        d /= this.estaciones.size();
        return d;
    }
    
    public String promedio() {                
        return this.nombre + " " + this.promedioTemp() + " " + this.promedioAgua() + " " + this.promedioCarga();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Estacion> getEstaciones() {
        return estaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
