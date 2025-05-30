package umg.programacionIII.estructuras.lista;

public class Lista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public Nodo<T> leerPrimero() {
        return primero;
    }

    public void insertarCabezaLista(T entrada) {
        Nodo<T> nuevo = new Nodo<>(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    public void insertarLista(Nodo<T> anterior, T entrada) {
        if (anterior == null) return;
        Nodo<T> nuevo = new Nodo<>(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }

    public void eliminar(T entrada) {
        Nodo<T> actual = primero;
        Nodo<T> anterior = null;

        while (actual != null && !actual.dato.equals(entrada)) {
            anterior = actual;
            actual = actual.enlace;
        }

        if (actual != null) {
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
        }
    }

    public Nodo<T> buscarLista(T destino) {
        Nodo<T> indice = primero;
        while (indice != null) {
            if (indice.dato.equals(destino)) {
                return indice;
            }
            indice = indice.enlace;
        }
        return null;
    }

    public void visualizar() {
        Nodo<T> n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
        System.out.println();
    }

    public void invertirLista() {
        Nodo<T> prev = null;
        Nodo<T> current = primero;
        Nodo<T> next;

        while (current != null) {
            next = current.enlace;
            current.enlace = prev;
            prev = current;
            current = next;
        }
        primero = prev;
    }

    public T obtenerDesdeFinal(int n) {
        Nodo<T> principal = primero;
        Nodo<T> referencia = primero;
        int count = 0;

        while (count < n) {
            if (referencia == null) return null;
            referencia = referencia.enlace;
            count++;
        }

        while (referencia != null) {
            principal = principal.enlace;
            referencia = referencia.enlace;
        }

        return principal != null ? principal.dato : null;
    }

    public void eliminarDuplicados() {
        Nodo<T> actual = primero;

        while (actual != null && actual.enlace != null) {
            Nodo<T> comparador = actual;

            while (comparador.enlace != null) {
                if (actual.dato.equals(comparador.enlace.dato)) {
                    comparador.enlace = comparador.enlace.enlace;
                } else {
                    comparador = comparador.enlace;
                }
            }
            actual = actual.enlace;
        }
    }

    public int obtenerTamanio() {
        int count = 0;
        Nodo<T> temp = primero;
        while (temp != null) {
            count++;
            temp = temp.enlace;
        }
        return count;
    }

    public void ordenarLista() {
        if (primero == null || primero.enlace == null) return;

        Nodo<T> actual, indice;
        for (actual = primero; actual != null; actual = actual.enlace) {
            for (indice = actual.enlace; indice != null; indice = indice.enlace) {
                if (((Comparable<T>) actual.dato).compareTo(indice.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = indice.dato;
                    indice.dato = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "=>" + primero;
    }
}

