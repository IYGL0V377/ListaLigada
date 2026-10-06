package mx.unam.aragon.ico.edd.listas;

public class DemoListaLigada {
    public static void main(String[] args) {

        ListaLigadaADT<Perro> lista = new ListaLigadaADT<>();

        Perro max = new Perro("Max", "Labrador", 3);
        Perro luna = new Perro("Luna", "Husky", 2);
        Perro rocky = new Perro("Rocky", "Chihuahua", 5);
        Perro bella = new Perro("Bella", "Poodle", 4);
        Perro coco = new Perro("Coco", "Beagle", 1);

        System.out.println("===== PRUEBAS DE LISTA SIMPLEMENTE LIGADA =====");

        System.out.println("\n1. ¿La lista está vacía?");
        System.out.println(lista.estaVacia());

        System.out.println("\n2. Agregar al final");
        lista.agregar(max);
        lista.agregarAlFinal(luna);
        lista.agregarAlFinal(rocky);
        lista.transversal();

        System.out.println("\n3. Agregar al inicio");
        lista.agregarAlInicio(bella);
        lista.transversal();

        System.out.println("\n4. Agregar después de una referencia");
        lista.agregarDespuesDe(luna, coco);
        lista.transversal();

        System.out.println("\n5. Tamaño");
        System.out.println("Tamaño: " + lista.getTamanio());

        System.out.println("\n6. Buscar");
        System.out.println("Posición de Rocky: " + lista.buscar(rocky));
        System.out.println("Posición de Coco: " + lista.buscar(coco));

        System.out.println("\n7. Actualizar");
        Perro rockyNuevo = new Perro("Rocky", "Pastor", 6);
        lista.actualizar(rocky, rockyNuevo);
        lista.transversal();

        System.out.println("\n8. Eliminar el primero");
        System.out.println("Eliminado: " + lista.eliminarElPrimero());
        lista.transversal();

        System.out.println("\n9. Eliminar el final");
        System.out.println("Eliminado: " + lista.eliminarElFinal());
        lista.transversal();

        System.out.println("\n10. Estado final");
        System.out.println("Tamaño: " + lista.getTamanio());
        System.out.println("¿Está vacía? " + lista.estaVacia());
        lista.transversal();
    }
}
