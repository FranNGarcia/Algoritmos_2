package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
	private int longitud;
	private Nodo primero;

    private class Nodo {
        //completar
		int valor;
		Nodo sig;
		Nodo ant;
		
		Nodo(v){
			valor =v;
			sig = null;
			ant = null;
		}
		
    }

    public ListaEnlazada() {
        primero = null;
		longitud = 0;
		
    }

    public int longitud() {
		return this.longitud;
		}
    }

    public void agregarAdelante(T elem) {
		//aumento longitud
		this.longitud += 1;
		//creo nuevo nodo
		Nodo nuevo = new Nodo(elem)
		//el siguiente del nuevo es el anterior primero
		nuevo.sig = this.primero;
		//al anterior primero le agrego como anterior el nuevo
		this.primero.ant = nuevo;
		//el primero pasa a ser el nuevo
		this.primero = nuevo;
    }

    public void agregarAtras(T elem) {
		//aumento long y creo nodo nuevo
		this.longitud += 1;
		Nodo nuevo = new Node(elem);
		//obtengo ultimo nodo
		//TODO
    }

    public T obtener(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
