package mx.unam.aragon.ico.edd.listas;

public class ListaLigadaADT<T> {
    private Nodo<T> head;

    public ListaLigadaADT() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getTamanio() {
        int contador = 0;
        Nodo<T> actual = head;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

    // Agrega al final de la lista.
    public void agregar(T dato) {
        agregarAlFinal(dato);
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (head == null) {
            head = nuevo;
            return;
        }

        Nodo<T> actual = head;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
    }

    public void agregarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato, head);
        head = nuevo;
    }

    public void agregarDespuesDe(T referencia, T valor) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = head;

        while (actual != null && !actual.getDato().equals(referencia)) {
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("No se encontró la referencia.");
            return;
        }

        Nodo<T> nuevo = new Nodo<>(valor, actual.getSiguiente());
        actual.setSiguiente(nuevo);
    }

    public T eliminarElPrimero() {
        if (estaVacia()) {
            return null;
        }

        T eliminado = head.getDato();
        head = head.getSiguiente();
        return eliminado;
    }

    public T eliminarElFinal() {
        if (estaVacia()) {
            return null;
        }

        if (head.getSiguiente() == null) {
            T eliminado = head.getDato();
            head = null;
            return eliminado;
        }

        Nodo<T> actual = head;

        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        T eliminado = actual.getSiguiente().getDato();
        actual.setSiguiente(null);
        return eliminado;
    }

    public int buscar(T valor) {
        int posicion = 0;
        Nodo<T> actual = head;

        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return posicion;
            }

            actual = actual.getSiguiente();
            posicion++;
        }

        return -1;
    }

    public void actualizar(T aBuscar, T nuevoValor) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = head;

        while (actual != null) {
            if (actual.getDato().equals(aBuscar)) {
                actual.setDato(nuevoValor);
                return;
            }

            actual = actual.getSiguiente();
        }

        System.out.println("No se encontró el elemento a actualizar.");
    }

    public void transversal() {
        if (estaVacia()) {
            System.out.println("Vacia");
            return;
        }

        Nodo<T> actual = head;

        while (actual != null) {
            System.out.print("| " + actual.getDato() + " ");
            actual = actual.getSiguiente();
        }

        System.out.println("|");
    }
}
