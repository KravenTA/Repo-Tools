package umg.programacionIII.estructuras.arbol;

public class BST<T extends Comparable<T>> implements IBST<T> {

    private T valor;
    private BST<T> izdo, dcho;
    private BST<T> padre;

    @Override
    public void insertar(T dato) {
        if (valor == null) {
            this.valor = dato;
        } else {
            if (dato.compareTo(valor) < 0) {
                if (izdo == null) izdo = new BST<>();
                izdo.insertar(dato);
            } else if (dato.compareTo(valor) > 0) {
                if (dcho == null) dcho = new BST<>();
                dcho.insertar(dato);
            } else {
                throw new RuntimeException("Insertando elemento duplicado");
            }
        }
    }

    @Override
    public boolean existe(int id) {
        if (valor != null) {
            if (getId(valor) == id) {
                return true;
            } else if (izdo != null && id < getId(valor)) {
                return izdo.existe(id);
            } else if (dcho != null && id > getId(valor)) {
                return dcho.existe(id);
            }
        }
        return false;
    }

    @Override
    public T obtener(int id) {
        if (valor != null) {
            if (getId(valor) == id) {
                return valor;
            } else if (izdo != null && id < getId(valor)) {
                return izdo.obtener(id);
            } else if (dcho != null && id > getId(valor)) {
                return dcho.obtener(id);
            }
        }
        return null;
    }

    @Override
    public boolean esHoja() {
        return valor != null && izdo == null && dcho == null;
    }

    @Override
    public boolean esVacio() {
        return valor == null;
    }

    @Override
    public void preOrden() {
        preordenImpl("");
    }

    @Override
    public void postOrden() {
        postordenImpl("");
    }

    @Override
    public void inOrden() {
        inordenImpl("");
    }

    private void inordenImpl(String prefijo) {
        if (izdo != null) izdo.inordenImpl(prefijo + "  ");
        System.out.println(" " + prefijo + valor);
        if (dcho != null) dcho.inordenImpl(prefijo + "  ");
    }

    private void postordenImpl(String prefijo) {
        if (izdo != null) izdo.postordenImpl(prefijo + "  ");
        if (dcho != null) dcho.postordenImpl(prefijo + "  ");
        System.out.println(" " + prefijo + valor);
    }

    private void preordenImpl(String prefijo) {
        if (valor != null) {
            System.out.println(" " + prefijo + valor);
            if (izdo != null) izdo.preordenImpl(prefijo + "  ");
            if (dcho != null) dcho.preordenImpl(prefijo + "  ");
        }
    }

    private void eliminarImpl(int id) {
        if (izdo != null && dcho != null) {
            BST<T> sucesor = dcho;
            while (sucesor.izdo != null) {
                sucesor = sucesor.izdo;
            }
            this.valor = sucesor.valor;
            dcho.eliminar(getId(sucesor.valor));
        } else if (izdo != null || dcho != null) {
            BST<T> hijo = (izdo != null) ? izdo : dcho;
            this.valor = hijo.valor;
            this.izdo = hijo.izdo;
            this.dcho = hijo.dcho;
        } else {
            if (padre != null) {
                if (this == padre.izdo) padre.izdo = null;
                else if (this == padre.dcho) padre.dcho = null;
                padre = null;
            }
            valor = null;
        }
    }

    @Override
    public void eliminar(int id) {
        if (valor != null) {
            if (getId(valor) == id) {
                eliminarImpl(id);
            } else if (izdo != null && id < getId(valor)) {
                izdo.eliminar(id);
            } else if (dcho != null && id > getId(valor)) {
                dcho.eliminar(id);
            }
        }
    }

    public int altura() {
        if (valor == null) return 0;
        int altI = (izdo != null) ? izdo.altura() : 0;
        int altD = (dcho != null) ? dcho.altura() : 0;
        return Math.max(altI, altD) + 1;
    }

    public int contarNodos() {
        if (valor == null) return 0;
        int ni = (izdo != null) ? izdo.contarNodos() : 0;
        int nd = (dcho != null) ? dcho.contarNodos() : 0;
        return ni + nd + 1;
    }

    public T obtenerMinimo() {
        if (valor == null) return null;
        return (izdo == null) ? valor : izdo.obtenerMinimo();
    }

    public T obtenerMaximo() {
        if (valor == null) return null;
        return (dcho == null) ? valor : dcho.obtenerMaximo();
    }

    public void imprimirEnNiveles() {
        int h = altura();
        for (int i = 1; i <= h; i++) {
            imprimirNivel(this, i);
            System.out.println();
        }
    }

    private void imprimirNivel(BST<T> nodo, int nivel) {
        if (nodo == null || nodo.valor == null) return;
        if (nivel == 1) {
            System.out.print(nodo.valor + " ");
        } else if (nivel > 1) {
            imprimirNivel(nodo.izdo, nivel - 1);
            imprimirNivel(nodo.dcho, nivel - 1);
        }
    }

    // 👇 Esto se asume para poder hacer búsquedas por ID, si T tiene getId()
    private int getId(T obj) {
        try {
            return (int) obj.getClass().getMethod("getId").invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("La clase " + obj.getClass() + " debe tener un método getId()", e);
        }
    }
}
