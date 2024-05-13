package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private int longitud;
    private Nodo primero;

    private class Nodo {
        T valor;
        Nodo sig;
        Nodo ant;

        Nodo(T v) {
            valor = v;
            sig = null;
            ant = null;
        }

    }

    public ListaEnlazada() {
        primero = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        // creo nuevo nodo
        Nodo nuevo = new Nodo(elem);
        // el siguiente del nuevo es el anterior primero
        nuevo.sig = primero;
        if (longitud > 1) {
            // al anterior primero le agrego como anterior el nuevo
            primero.ant = nuevo;
        }
        // el primero pasa a ser el nuevo
        primero = nuevo;
        // aumento longitud
        longitud += 1;
    }

    public void agregarAtras(T elem) {
        if (longitud == 0) {
            primero = new Nodo(elem);
        }
        Nodo nuevo = new Nodo(elem);
        Nodo actual = primero;
        if (longitud > 1) {
            // obtengo ultimo nodo
            while (actual.sig != null) {
                actual = actual.sig;
            }
        }
        // asigno el siguiente y ultimo a cada uno
        actual.sig = nuevo;
        nuevo.ant = actual;
        // aumento long
        longitud += 1;

    }

    public T obtener(int i) {
        int contador = 0;
        Nodo candidato = primero;
        while (contador != i) {
            candidato = candidato.sig;
            contador += 1;
        }
        return (candidato.valor);

    }

    public void eliminar(int i) {
        if (longitud > 0) {
            int contador = 0;
            Nodo buscado = primero;
            while (contador != i) {
                buscado = buscado.sig;
                contador += 1;
            }
            if (buscado.ant != null) {
                if (buscado.sig != null) {
                    buscado.ant.sig = buscado.sig;
                } else {
                    buscado.ant.sig = null;
                }
            } else {
                if (buscado.sig != null) {
                    buscado.sig.ant = null;
                }
                primero = buscado.sig;
            }

            longitud -= 1;
        }

    }

    public void modificarPosicion(int indice, T elem) {
        int contador = 0;
        Nodo buscado = primero;
        while (contador != indice) {
            buscado = buscado.sig;
            contador += 1;
        }
        buscado.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
        int contador = 0;
        Nodo buscado = primero;
        while (contador != longitud) {
            nuevaLista.agregarAtras(buscado.valor);
            buscado = buscado.sig;
            contador += 1;
        }
        return (nuevaLista);
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        this();
        Nodo current = lista.primero;
        while (current != null) {
            this.agregarAtras(current.valor);
            current = current.sig;
        }
    }

    @Override
    public String toString() {
        String texto = "[";
        int contador = 0;
        Nodo buscado = primero;
        while (contador != longitud) {
            texto += String.valueOf(buscado.valor);
            if (contador < longitud-1) {
                texto += ", ";
            }
            buscado = buscado.sig;
            contador += 1;
        }
        texto += "]";
        return texto;
    }

    private class ListaIterador implements Iterador<T> {
        // Completar atributos privados
        int indice = 0;

        public boolean haySiguiente() {
            return(indice < longitud && longitud > 0);
        }

        public boolean hayAnterior() {
            return(indice != 0 && longitud > 0);
        }

        public T siguiente() {
            Nodo actual = primero;
            for (int i = 0; i < indice; i++) {
                actual = actual.sig;
            }
            indice += 1;
            return (actual.valor);
        }

        public T anterior() {
            Nodo actual = primero;
            for (int i = 0; i < indice-1; i++) {
                actual = actual.sig;
            }
            indice -= 1;
            return (actual.valor);
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
