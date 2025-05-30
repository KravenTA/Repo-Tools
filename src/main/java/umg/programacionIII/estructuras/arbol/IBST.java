package umg.programacionIII.estructuras.arbol;

public interface IBST<T extends Comparable<T>> {
    void insertar(T valor);
    boolean existe(int id);
    T obtener(int id);
    boolean esHoja();
    boolean esVacio();
    void preOrden();
    void inOrden();
    void postOrden();
    void eliminar(int id);
}

