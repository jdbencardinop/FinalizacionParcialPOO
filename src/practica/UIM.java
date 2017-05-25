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
        //uim.EscribirRegistro("Salida.txt");
        uim.EscribirPromedio("SalidaP.txt");
    }

    public String Promedios() {
        String s = "";
        for (Ciudad ciudade : ciudades) {
            s += ciudade.promedio() + "\n";
        }
        return s;
    }

    public void LeerRegistro() throws FileNotFoundException {
        Scanner entrada;
        entrada = new Scanner(new File(this.pathRegistro));
        //entrada.useDelimiter(" ");
        int i = 0;
        while (i < 12 && entrada.hasNextLine()) {
            String name = entrada.next();
            this.ciudades[i].setNombre(name);
            System.out.println(name);

            entrada.nextLine();

            int cant = entrada.nextInt();
            System.out.println(cant);
            this.ciudades[i].PopulateEstaciones(cant, entrada, "00/00/0000");
            i++;
        }
        entrada.close();
    }

    public String ActualizarRegistro() {
        String s = "";
        for (int i = 0; i < this.numciudades; i++) {
            s += this.ciudades[i].ActualizarRegistro() + "\n";
        }
        return s;
    }

    public void EscribirRegistro(String path) throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(path))) {
            System.out.println(this.ActualizarRegistro());
            os.print(this.ActualizarRegistro());
        }
    }

    public void EscribirRegistro() throws FileNotFoundException {
        try (PrintStream os = new PrintStream(new File(this.pathRegistro))) {
            System.out.println(this.ActualizarRegistro());
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
