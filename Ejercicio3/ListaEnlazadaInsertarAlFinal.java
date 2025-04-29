package Ejercicio3;

public class ListaEnlazadaInsertarAlFinal<T> { // clase generica

    public class Node<T> { // clase interna que define un nodo
        T data; // guarda el dato del nodo
        Node<T> next; // guarda la referencia al siguiente nodo

        public Node(T data) { // constructor del nodo
            this.data = data; // asigna el valor recibido al dato
            this.next = null; // el siguiente nodo empieza como nulo
        }
    }
    private Node<T> head; // referencia al primer nodo de la lista
    public ListaEnlazadaInsertarAlFinal() { // constructor de la lista
        this.head = null; // la lista empieza vacia
    }
    // metodo para insertar un nodo al final
    public void insertarAlFinal(T x) {
        Node<T> nuevoNodo = new Node<>(x); // crea un nuevo nodo con el valor recibido
        if (head == null) { // si la lista esta vacia
            head = nuevoNodo; // el nuevo nodo se convierte en el primero
        } else { // si la lista no esta vacia
            Node<T> nodoActual = head; // empieza desde el primer nodo
            while (nodoActual.next != null) { // recorre hasta encontrar el ultimo nodo
                nodoActual = nodoActual.next; // avanza al siguiente nodo
            }
            nodoActual.next = nuevoNodo; // conecta el ultimo nodo al nuevo nodo
        }
    }
    // metodo para mostrar la lista
    public void mostrarLista() {
        Node<T> nodoActual = head; // empieza desde el primer nodo
        while (nodoActual != null) { // mientras haya nodos en la lista
            System.out.print(nodoActual.data + " -> "); // imprime el dato seguido de una flecha
            nodoActual = nodoActual.next; // avanza al siguiente nodo
        }
        System.out.println("null"); // al final imprime null
    }
    // metodo main para probar
    public static void main(String[] args) {
        ListaEnlazadaInsertarAlFinal<Integer> lista = new ListaEnlazadaInsertarAlFinal<>(); // crea una lista de enteros
        lista.insertarAlFinal(10); // inserta el numero 10
        lista.insertarAlFinal(20); // inserta el numero 20
        lista.insertarAlFinal(30); // inserta el numero 30
        lista.mostrarLista(); // muestra la lista completa
    }
}
