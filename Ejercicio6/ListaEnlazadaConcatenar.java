package Ejercicio6; // declaramos que este código está en el paquete Ejercicio6

public class ListaEnlazadaConcatenar<T> { // creamos una clase genérica llamada ListaEnlazadaConcatenar que puede manejar cualquier tipo de dato (T)
    public static class Node<T> { // dentro de la clase, creamos una clase interna llamada Node que representa un nodo de la lista
        T data; // el nodo guarda un dato de tipo T
        Node<T> next; // cada nodo tiene una referencia al siguiente nodo

        public Node(T data) { // constructor del nodo
            this.data = data; // asignamos el valor recibido como dato del nodo
            this.next = null; // al inicio, el siguiente nodo es null, ya que no apunta a ningún nodo
        }
    }
    private Node<T> head; // esta es la referencia al primer nodo de la lista, inicialmente está vacía
    public ListaEnlazadaConcatenar() { // constructor de la lista enlazada
        this.head = null; // cuando se crea la lista, está vacía, por lo que la cabeza es null
    }
    // este método obtiene la cabeza de la lista
    public Node<T> getHead() {
        return head; // devuelve la referencia al primer nodo
    }
    // método para insertar un nodo al final de la lista
    public void insertLast(T x) {
        Node<T> nuevoNodo = new Node<>(x); // creamos un nuevo nodo con el valor recibido
        if (head == null) { // si la lista está vacía (no hay ningún nodo)
            head = nuevoNodo; // el nuevo nodo se convierte en el primer nodo (la cabeza)
        } else {
            Node<T> actual = head; // empezamos desde la cabeza de la lista
            while (actual.next != null) { // recorremos la lista hasta llegar al último nodo
                actual = actual.next; // avanzamos al siguiente nodo
            }
            actual.next = nuevoNodo; // cuando llegamos al último nodo, le asignamos el nuevo nodo como el siguiente
        }
    }
    // método para mostrar todos los nodos de la lista
    public void mostrarLista() {
        Node<T> nodoActual = head; // empezamos desde el primer nodo
        while (nodoActual != null) { // mientras haya nodos en la lista
            System.out.print(nodoActual.data + " -> "); // mostramos el dato del nodo seguido de una flecha
            nodoActual = nodoActual.next; // avanzamos al siguiente nodo
        }
        System.out.println("null"); // cuando llegamos al final de la lista, imprimimos "null"
    }
    // este método concatena dos listas enlazadas y devuelve una nueva lista
    public static <T> ListaEnlazadaConcatenar<T> concatenarListas(Node<T> cabeza1, Node<T> cabeza2) {
        ListaEnlazadaConcatenar<T> listaConcatenada = new ListaEnlazadaConcatenar<>(); // creamos una nueva lista vacía
        Node<T> actual = cabeza1; // empezamos con la cabeza de la primera lista
        while (actual != null) { // mientras haya nodos en la primera lista
            listaConcatenada.insertLast(actual.data); // insertamos el dato en la nueva lista concatenada
            actual = actual.next; // avanzamos al siguiente nodo de la primera lista
        }
        actual = cabeza2; // ahora empezamos con la cabeza de la segunda lista
        while (actual != null) { // mientras haya nodos en la segunda lista
            listaConcatenada.insertLast(actual.data); // insertamos el dato en la nueva lista concatenada
            actual = actual.next; // avanzamos al siguiente nodo de la segunda lista
        }
        return listaConcatenada; // devolvemos la lista concatenada
    }
    // método principal para probar la concatenación de listas
    public static void main(String[] args) {
        // creamos dos listas de enteros
        ListaEnlazadaConcatenar<Integer> lista1 = new ListaEnlazadaConcatenar<>();
        ListaEnlazadaConcatenar<Integer> lista2 = new ListaEnlazadaConcatenar<>();
        // insertamos elementos en la primera lista
        lista1.insertLast(10);
        lista1.insertLast(20);
        lista1.insertLast(30);
        // insertamos elementos en la segunda lista
        lista2.insertLast(40);
        lista2.insertLast(50);
        // mostramos la primera lista
        System.out.print("Lista 1: ");
        lista1.mostrarLista();
        // mostramos la segunda lista
        System.out.print("Lista 2: ");
        lista2.mostrarLista();
        // concatenamos las dos listas
        ListaEnlazadaConcatenar<Integer> listaConcatenada = concatenarListas(lista1.getHead(), lista2.getHead());
        // mostramos la lista concatenada
        System.out.print("Lista Concatenada: ");
        listaConcatenada.mostrarLista();
    }
}
