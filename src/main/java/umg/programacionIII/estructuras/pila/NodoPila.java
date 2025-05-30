package umg.programacionIII.estructuras.pila;

public class NodoPila<T> {

    T elemento;
    NodoPila<T> siguiente;

    public NodoPila(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "NodoPila{" + "elemento=" + elemento + '}';
    }
}
