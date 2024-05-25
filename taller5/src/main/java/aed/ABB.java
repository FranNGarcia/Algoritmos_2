package aed;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private int longitud;
    private Nodo raiz;

    private class Nodo {
        // Agregar atributos privados del Nodo
        private T elem;
        private Nodo izq;
        private Nodo der;
        private Nodo padre;

        // Crear Constructor del nodo
        public Nodo(T elem) {
            this.elem = elem;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }

    public ABB() {
        this.longitud = 0;
        this.raiz = null;
    }

    public int cardinal() {
        return (this.longitud);
    }

    public T minimo() {
        Nodo minimo = this.raiz;
        while (minimo.izq != null) {
            minimo = minimo.izq;
        }
        return minimo.elem;
    }

    public T maximo() {
        Nodo maximo = this.raiz;
        while (maximo.der != null) {
            maximo = maximo.der;
        }
        return maximo.elem;
    }

    public void insertar(T elem) {
        if (this.raiz == null) {
            this.raiz = new Nodo(elem);
            this.longitud++;
        } else {
            Nodo actual = this.raiz;
            Nodo superior = null;
            int cmp = 0;
            while (actual != null) {
                cmp = elem.compareTo(actual.elem);
                superior = actual;
                if (cmp < 0) {
                    actual = actual.izq;
                } else if (cmp > 0) {
                    actual = actual.der;
                } else {
                    return; // me salgo para no agregar elementos repetidos
                }
            }
            Nodo nuevo = new Nodo(elem);
            nuevo.padre = superior; // Establecemos el padre del nuevo nodo
            if (cmp < 0) {
                superior.izq = nuevo;
            } else {
                superior.der = nuevo;
            }
            this.longitud++;
        }
    }

    public boolean pertenece(T elem) {
        boolean encontrado = false;
        Nodo actual = this.raiz;
        while (actual != null) {
            if (elem.compareTo(actual.elem) < 0) {
                actual = actual.izq;
            } else if (elem.compareTo(actual.elem) > 0) {
                actual = actual.der;
            } else {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void eliminar(T elem) {
        Nodo actual = this.raiz;
        Nodo superior = null;
        int cmp = 0;
        while (actual != null) {
            cmp = elem.compareTo(actual.elem);
            if (cmp < 0) {
                superior = actual;
                actual = actual.izq;
            } else if (cmp > 0) {
                superior = actual;
                actual = actual.der;
            } else {
                break;
            }
        }
        if (actual == null) {
            return;
        }
        if (actual.izq == null) {
            if (superior == null) {
                this.raiz = actual.der;
            } else {
                if (cmp < 0) {
                    superior.izq = actual.der;
                } else {
                    superior.der = actual.der;
                }
            }
        } else {
            Nodo maximo = actual.izq;
            Nodo superiorMaximo = actual;
            while (maximo.der != null) {
                superiorMaximo = maximo;
                maximo = maximo.der;
            }
            actual.elem = maximo.elem;
            if (superiorMaximo == actual) {
                superiorMaximo.izq = maximo.izq;
            } else {
                superiorMaximo.der = maximo.izq;
            }
        }
        this.longitud--;
    }

    // aux de recursion
    private String toStringAux(Nodo node) {
        if (node == null) {
            return "";
        }

        String left = toStringAux(node.izq);
        String right = toStringAux(node.der);

        return left + node.elem + "," + right;
    }

    public String toString() {
        String stringDeseado = toStringAux(this.raiz);
        return "{" + stringDeseado.substring(0, stringDeseado.length() - 1) + "}";
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;

        public ABB_Iterador() {
            this.actual = raiz;
            if (this.actual != null) {
                while (this.actual.izq != null) {
                    this.actual = this.actual.izq;
                }
            }
        }

        public boolean haySiguiente() {
            return this.actual != null;
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException();
            }

            Nodo nodoActual = this.actual;

            if (this.actual.der != null) {
                this.actual = this.actual.der;
                while (this.actual.izq != null) {
                    this.actual = this.actual.izq;
                }
            } else {
                Nodo padre = this.actual.padre;
                while (padre != null && this.actual == padre.der) {
                    this.actual = padre;
                    padre = padre.padre;
                }
                this.actual = padre;
            }

            return nodoActual.elem;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
