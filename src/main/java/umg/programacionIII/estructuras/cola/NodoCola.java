package umg.programacionIII.estructuras.cola;

public class NodoCola<T> {

    T elemento;
    NodoCola<T> siguiente;

    public NodoCola(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "NodoCola{" + "elemento=" + elemento + '}';
    }
}
