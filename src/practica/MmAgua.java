package practica;

/**
 *
 * @author Estudiante
 */
public class MmAgua extends Sensor {

    public MmAgua(String marca, String referencia, String fecha) {
        super(marca, referencia, fecha);
    }

    @Override
    protected void addRegistro(int registro, String fecha) {
        this.registros.put(fecha,registro);
        this.datos.add(registro);
    }

    @Override
    protected int getRegistroFecha(String FechaDelRegistro) {
        return this.registros.get(FechaDelRegistro);
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
    
}
