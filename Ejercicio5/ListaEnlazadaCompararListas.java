package Ejercicio5;

public class ListaEnlazadaCompararListas<T> { // clase generica
    public static class Node<T> { // clase interna estatica que representa un nodo
        T data; // dato del nodo
        Node<T> next; // referencia al siguiente nodo

        public Node(T data) { // constructor del nodo
            this.data = data; // asigna el valor recibido
            this.next = null; // siguiente nodo es null al inicio
        }
    }
    private Node<T> head; // referencia al primer nodo
    public ListaEnlazadaCompararListas() { // constructor de la lista
        this.head = null; // la lista empieza vacía
    }
    // getter para la cabeza
    public Node<T> getHead() {
        return head;
    }
    // metodo para insertar un nodo al final de la lista
    public void insertLast(T x) {
        Node<T> nuevoNodo = new Node<>(x); // crea un nuevo nodo
        if (head == null) { // si la lista esta vacia
            head = nuevoNodo; // el nuevo nodo es el primero
        } else {
            Node<T> actual = head;
            while (actual.next != null) { // recorre hasta el ultimo nodo
                actual = actual.next;
            }
            actual.next = nuevoNodo; // agrega el nuevo nodo al final
        }
    }
    // metodo estatico para comparar dos listas
    public static <T> boolean sonIguales(Node<T> cabeza1, Node<T> cabeza2) {
        Node<T> actual1 = cabeza1; //creamos 2 referencias para lso primeros nodos de las listas
        Node<T> actual2 = cabeza2;
        while (actual1 != null && actual2 != null) { // mientras ambas listas tengan nodos
            if (!actual1.data.equals(actual2.data)) { // si los datos no son iguales
                return false; // las listas no son iguales
            }
            actual1 = actual1.next; // avanzar en la primera lista
            actual2 = actual2.next; // avanzar en la segunda lista
        }
        // si ambas listas llegaron al final al mismo tiempo, son iguales
        return actual1 == null && actual2 == null;
    }
    //metodo para comparar dos listas
    public static <T> void probarListas(ListaEnlazadaCompararListas<T> l1, ListaEnlazadaCompararListas<T> l2, String nombrePrueba) {
        boolean iguales = sonIguales(l1.getHead(), l2.getHead()); //llamamos al metodo para ver si son iguales
        if (iguales) {
            System.out.println(nombrePrueba + ": Las listas son iguales :]");
        } else {
            System.out.println(nombrePrueba + ": Las listas son diferentes :(");
        }
    }

    // metodo main para probar
    public static void main(String[] args) {
        ListaEnlazadaCompararListas<Integer> lista1 = new ListaEnlazadaCompararListas<>();
        ListaEnlazadaCompararListas<Integer> lista2 = new ListaEnlazadaCompararListas<>();
        ListaEnlazadaCompararListas<String> lista3 = new ListaEnlazadaCompararListas<>();
        ListaEnlazadaCompararListas<String> lista4 = new ListaEnlazadaCompararListas<>();
        lista1.insertLast(40);
        lista1.insertLast(70);
        lista1.insertLast(90);
        lista2.insertLast(40);
        lista2.insertLast(70);
        lista2.insertLast(90);

        lista3.insertLast("hola como estas");
        lista3.insertLast("jani");
        lista3.insertLast("a");
        lista4.insertLast("hola como esta");
        lista4.insertLast("jani");
        lista4.insertLast("a");
        lista4.insertLast("AED");

        probarListas(lista1, lista2, "Prueba 1");
        probarListas(lista3, lista4, "Prueba 2");
    }
}
