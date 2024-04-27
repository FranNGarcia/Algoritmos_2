package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] lista;

    public ArregloRedimensionableDeRecordatorios() {
        this.lista = new Recordatorio[0];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.lista = new Recordatorio[vector.longitud()];
        for (int i = 0; i < vector.longitud(); i++){
            modificarPosicion(i, vector.obtener(i));
        }
    }

    public int longitud() {
        return(this.lista.length);
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] copiaDeLista = new Recordatorio[this.lista.length + 1];
        for (int k = 0; k < this.lista.length; k++){
            copiaDeLista[k] = this.lista[k];
        }
        copiaDeLista[copiaDeLista.length-1] = i;
        this.lista = copiaDeLista;
    }

    public Recordatorio obtener(int i) {
        return (this.lista[i]);
    }

    public void quitarAtras() {
        Recordatorio[] copiaDeLista = new Recordatorio[this.lista.length -1];
        for (int k = 0; k < this.lista.length-1; k++){
            copiaDeLista[k] = this.lista[k];
        }
        this.lista = copiaDeLista;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.lista[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copiaDeLista = new ArregloRedimensionableDeRecordatorios();

        for (int i = 0; i < this.lista.length; i++) {
            copiaDeLista.agregarAtras(obtener(i));
        }
        return (copiaDeLista);
    }

}
