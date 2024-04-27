package aed;

public class Agenda {

    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String fechaYSeparador = this.fechaActual.toString().concat("\n=====\n");
        String stringRecordatorios ="";
        for (int i = 0; i < this.recordatorios.longitud(); i++) {
            if(this.recordatorios.obtener(i).fecha().equals(this.fechaActual)){
                stringRecordatorios += (recordatorios.obtener(i).toString()) + "\n";
            }
        }
        return (fechaYSeparador + stringRecordatorios);
    }

    public void incrementarDia() {
        this.fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return (new Fecha(this.fechaActual));
    }

}
