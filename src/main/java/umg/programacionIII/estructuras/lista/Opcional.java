package umg.programacionIII.estructuras.lista;

public class Opcional<T> {
    private final T valor;
    private final boolean presente;

    private Opcional(T valor, boolean presente) {
        this.valor = valor;
        this.presente = presente;
    }

    public static <T> Opcional<T> vacio() {
        return new Opcional<>(null, false);
    }

    public static <T> Opcional<T> de(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("Valor no puede ser nulo");
        }
        return new Opcional<>(valor, true);
    }

    public static <T> Opcional<T> deNulable(T valor) {
        return valor == null ? vacio() : de(valor);
    }

    public boolean estaPresente() {
        return presente;
    }

    public T obtener() {
        if (!presente) {
            throw new IllegalStateException("No hay valor presente");
        }
        return valor;
    }

    public T orElse(T otro) {
        return presente ? valor : otro;
    }
}
