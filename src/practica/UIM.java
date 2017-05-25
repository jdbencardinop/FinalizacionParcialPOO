package practica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class UIM {
    private String pathRegistro;
    private final Ciudad[] ciudades = new Ciudad[12];
    private int numciudades;

    public UIM() {
        this.pathRegistro = "Registro.txt";
        this.numciudades = 12;
        //System.out.println(this.ciudades.length);
        for (int i = 0; i < ciudades.length; i++) {
            ciudades[i] = new Ciudad("asfd" + i); 
            //System.out.println("ciudad " + i + " creada");
        }
    }
    
    public UIM(String path) {
        this.pathRegistro = path;
        this.numciudades = 12;
        //System.out.println(this.ciudades.length);
        for (int i = 0; i < ciudades.length; i++) {
            ciudades[i] = new Ciudad("asfd" + i); 
            //System.out.println("ciudad " + i + " creada");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        UIM uim = new UIM();
        uim.LeerRegistro();
        //uim.EscribirRegistro();
    }
    
    public String Promedios() {
        String s = "";
        for (Ciudad ciudade : ciudades) {
            s += ciudade.promedio() + "\n\n";
        }
        return s;
    }
    
    public void LeerRegistro() throws FileNotFoundException {
        Scanner entrada;
        entrada = new Scanner(new File(this.pathRegistro));
        entrada.useDelimiter(" ");
        for (int i = 0; i < 12; i++) {
            
            String name = entrada.nextLine();
            this.ciudades[i].setNombre(name);
            System.out.println("!" + name + "#");
            
            System.out.println("!" + entrada.nextLine() + "#");
            //System.out.println("!" + entrada.nextLine() + "#");
            
            String cant = entrada.next();
            
            System.out.println("!" + cant + "#");            
            this.ciudades[i].PopulateEstaciones(0, entrada, "00/00/0000");
        }
        entrada.close();        
    }
    
    public String ActualizarRegistro() {
        String s = "";
        for (int i = 0; i < this.numciudades; i++) {
            s += this.ciudades[i].ActualizarRegistro() + "\n\n";
        }
        return s;
    }
    
    public void EscribirRegistro(String path) throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(path))) {
            os.print(this.ActualizarRegistro());
        }
    }
    
    public void EscribirRegistro() throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(this.pathRegistro))) {
            os.print(this.ActualizarRegistro());
        }
    }
    
    public void EscribirPromedio() throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(this.pathRegistro))) {
            System.out.println(this.Promedios());
            os.print(this.Promedios());
        }
    }
    
    public void EscribirPromedio(String path) throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(path))) {
            System.out.println(this.Promedios());
            os.print(this.Promedios());
        }
    }
    
    public void addCiudad(Ciudad c) {
        if (this.numciudades < this.ciudades.length) {
            this.ciudades[this.numciudades++] = c;
        } else {
            System.out.println("Ya no hay memoria para mas ciudades");
        }
    }

    public Ciudad[] getCiudades() {
        return ciudades;
    }    

    public String getPathRegistro() {
        return pathRegistro;
    }

    public void setPathRegistro(String pathRegistro) {
        this.pathRegistro = pathRegistro;
    }

}
