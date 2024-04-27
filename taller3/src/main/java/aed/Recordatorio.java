package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje + " @ " + this.fecha + " " + this.horario;
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || this.getClass() != otro.getClass()){
            return false;
        }
        return (this.mensaje.equals(((Recordatorio) otro).mensaje()) &&
                this.fecha.equals(((Recordatorio) otro).fecha()) &&
                this.horario.equals(((Recordatorio) otro).horario()));
    }

}
