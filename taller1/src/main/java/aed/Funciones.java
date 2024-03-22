package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(((x*x) + (y*y)));
    }

    boolean esPar(int n) {
        return (n%2 == 0);
    }

    boolean esBisiesto(int n) {
        return ((n%400 == 0) || ((n%4 == 0) && (n%100 != 0)));
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 0; i<n; i++){
            res *= i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        while (n > 0) {
            res *= res;
            n=n-1;
        }
        return res;
    }

    boolean esPrimo(int n) {
       for (int i = 2; i < n; i++){
        if (n%i == 0){
            return false;
        }
       }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int numero : numeros) {
            res += numero;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int numero : numeros) {
            if (esPrimo(numero) == true){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int numero : numeros){
            if (!esPar(numero)){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        for (int i = s2.length()-1; i > s2.length() - s1.length(); i--){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
