package umg.programacionIII.estructuras.lista;

public class Nodo<T> {
    T dato;
    Nodo<T> enlace;

    public Nodo(T x) {
        dato = x;
        enlace = null;
    }

    public Nodo(T x, Nodo<T> n) {
        dato = x;
        enlace = n;
    }

    public T leerDato() {
        return dato;
    }

    public Nodo<T> siguiente() {
        return enlace;
    }

    @Override
    public String toString() {
        return dato + " => " + enlace;
    }
}
