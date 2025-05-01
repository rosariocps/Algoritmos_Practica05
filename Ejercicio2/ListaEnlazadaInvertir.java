package Ejercicio2;

public class ListaEnlazadaInvertir<T> { // creamos una clase generica para manejar listas enlazadas, donde T es el tipo de dato
    public static class Node<T> { // clase interna y estatica que representa un nodo dentro de la lista
        T data; // la variable 'data' guarda el dato del nodo
        Node<T> next; // 'next' es una referencia al siguiente nodo en la lista

        public Node(T data) { // constructor de un nodo, recibe un dato para inicializar el nodo
            this.data = data; // asigna el valor recibido al nodo
            this.next = null; // al principio, el siguiente nodo es null
        }
    }
    private Node<T> head; // 'head' es la referencia al primer nodo de la lista

    public ListaEnlazadaInvertir() { // constructor de la lista enlazada
        this.head = null; // al principio, la lista esta vacía, por lo tanto 'head' es null
    }

    // getter para obtener la cabeza de la lista
    public Node<T> getHead() {
        return head; // devuelve el nodo cabeza de la lista
    }

    // metodo para insertar un nodo al final de la lista
    public void insertLast(T x) {
        Node<T> nuevoNodo = new Node<>(x); // crea un nuevo nodo con el valor recibido
        if (head == null) { // si la lista esta vacía
            head = nuevoNodo; // el nuevo nodo se convierte en el primer nodo
        } else {
            Node<T> actual = head; // comenzamos a recorrer la lista desde el primer nodo
            while (actual.next != null) { // mientras no lleguemos al ultimo nodo
                actual = actual.next; // avanzamos al siguiente nodo
            }
            actual.next = nuevoNodo; // al llegar al último nodo, añadimos el nuevo nodo al final
        }
    }

    // metodo para mostrar la lista
    public void mostrarLista() {
        Node<T> nodoActual = head; // comenzamos desde el primer nodo
        while (nodoActual != null) { // mientras haya nodos
            System.out.print(nodoActual.data + " -> "); // imprimimos el dato del nodo seguido de una flecha
            nodoActual = nodoActual.next; // avanzamos al siguiente nodo
        }
        System.out.println("null"); // al finalizar, imprimimos null para indicar el final de la lista
    }

    // funcion para invertir la lista y devolverla en orden inverso
    public static <T> ListaEnlazadaInvertir<T> invertirLista(Node<T> cabeza) {
        ListaEnlazadaInvertir<T> listaInvertida = new ListaEnlazadaInvertir<>(); // creamos una nueva lista vacía
        Nrrode<T> actual = cabeza; // comenzamos a recorrer la lista original desde la cabeza
        while (actual != null) { // mientras haya nodos en la lista original
            Node<T> nuevoNodo = new Node<>(actual.data); // creamos un nuevo nodo con el dato del nodo actual
            nuevoNodo.next = listaInvertida.head; // el siguiente nodo del nuevo nodo será la cabeza de la lista invertida
            listaInvertida.head = nuevoNodo; // actualizamos la cabeza de la lista invertida al nuevo nodo
            actual = actual.next; // avanzamos al siguiente nodo de la lista original
        }
        return listaInvertida; // devolvemos la lista invertida
    }

    // metodo principal para probar la inversion de listas
    public static void main(String[] args) {
        // creamos una lista de enteros
        ListaEnlazadaInvertir<Integer> lista = new ListaEnlazadaInvertir<>();
        // insertamos elementos en la lista
        lista.insertLast(10);
        lista.insertLast(20);
        lista.insertLast(30);
        lista.insertLast(40);
        // mostramos la lista original
        System.out.print("Lista Original: ");
        lista.mostrarLista();
        // invertimos la lista
        ListaEnlazadaInvertir<Integer> listaInvertida = invertirLista(lista.getHead());
        // mostramos la lista invertida
        System.out.print("Lista Invertida: ");
        listaInvertida.mostrarLista();
    }
}