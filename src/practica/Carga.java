package practica;

/**
 *
 * @author Estudiante
 */
public class Carga extends Sensor {

    private int valNivel;
    private String nombreNivel;

    public Carga(int valNivel, String marca, String referencia, String fecha) {
        super(marca, referencia, fecha);
        this.valNivel = valNivel;
        this.nombreNivel = this.putNombre();
    }

    @Override
    protected void addRegistro(int registro, String fecha) {
        this.registros.put(fecha, registro);
        this.datos.add(registro);
        this.setValNivel(registro);
        this.setNombreNivel(this.putNombre());
    }

    @Override
    protected int getRegistroFecha(String FechaDelRegistro) {
        int registro = this.registros.get(FechaDelRegistro);
        this.setValNivel(registro);
        this.setNombreNivel(this.putNombre());
        return registro;
    }

    @Override
    protected double calcPromedio() {
        double total = 0;
        if (!datos.isEmpty()) {
            for (Integer dato : datos) {
                total += dato;
            }
            total /= datos.size();
        }
        return total;
    }

    public final String putNombre() {
        String n = "";
        switch (this.valNivel) {
            case 1:
                n = "Tormenta Eléctrica";
                break;
            case 2:
                n = "Rayos";
                break;
            case 3:
                n = "Truenos";
                break;
            case 4:
                n = "Normal";
                break;
        }
        return n;
    }

    public int getValNivel() {
        return valNivel;
    }

    public void setValNivel(int valNivel) {
        this.valNivel = valNivel;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

}
