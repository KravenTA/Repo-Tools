package umg.programacionIII.estructuras.pila;

public class PilaLista<T> {

    private NodoPila<T> cima;

    public PilaLista() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void insertar(T elemento) {
        NodoPila<T> nuevo = new NodoPila<>(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public T quitar() {
        if (estaVacia()) {
            return null; // puedes lanzar excepción si prefieres
        }
        T aux = cima.elemento;
        cima = cima.siguiente;
        return aux;
    }

    public void limpiarPila() {
        while (!estaVacia()) {
            NodoPila<T> temp = cima;
            cima = cima.siguiente;
            temp.siguiente = null;
        }
    }

    public T cima() {
        return estaVacia() ? null : cima.elemento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cima -> ");
        NodoPila<T> actual = cima;
        while (actual != null) {
            sb.append(actual.elemento).append(" -> ");
            actual = actual.siguiente;
        }
        sb.append("null");
        return sb.toString();
    }
}
