package umg.programacionIII.estructuras.cola;

public class ColaLista<T> {

    protected NodoCola<T> frente;
    protected NodoCola<T> fin;

    public ColaLista() {
        frente = fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void insertar(T elemento) {
        NodoCola<T> nuevo = new NodoCola<>(elemento);

        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
    }

    public T quitar() {
        if (estaVacia()) {
            return null; // puedes lanzar excepción si prefieres
        }

        T aux = frente.elemento;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return aux;
    }

    public void limpiarCola() {
        while (!estaVacia()) {
            NodoCola<T> temp = frente;
            frente = frente.siguiente;
            temp.siguiente = null;
        }
        fin = null;
    }

    public T frente() {
        return estaVacia() ? null : frente.elemento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Frente -> ");
        NodoCola<T> actual = frente;
        while (actual != null) {
            sb.append(actual.elemento).append(" -> ");
            actual = actual.siguiente;
        }
        sb.append("null");
        return sb.toString();
    }
}
