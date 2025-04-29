package Ejercicio4; 

public class ListaEnlazadaContarNodos<T> { // clase generica
    public class Node<T> { // clase interna que representa un nodo
        T data; // guarda el dato del nodo
        Node<T> next; // referencia al siguiente nodo

        public Node(T data) { // constructor del nodo
            this.data = data; // asigna el valor recibido al dato
            this.next = null; // el siguiente nodo empieza como nulo
        }
    }
    private Node<T> head; // referencia al primer nodo de la lista
    public ListaEnlazadaContarNodos() { // constructor de la lista
        this.head = null; // la lista empieza vacia
    }
    // metodo para insertar un nodo al inicio
    public void insertFirst(T x) {
        Node<T> nuevoNodo = new Node<>(x); // crea un nuevo nodo con el valor recibido
        nuevoNodo.next = head; // el siguiente del nuevo nodo es el primer nodo actual
        head = nuevoNodo; // el nuevo nodo se convierte en el primer nodo de la lista
    }
    // metodo para contar el numero de nodos en la lista
    public int contarNodos() {
        int contador = 0; // inicializa el contador en 0
        Node<T> nodoActual = head; // empieza desde el primer nodo
        while (nodoActual != null) { // mientras haya nodos en la lista
            contador++; // incrementa el contador por cada nodo encontrado
            nodoActual = nodoActual.next; // avanza al siguiente nodo
        }
        return contador; // devuelve el numero total de nodos
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
        ListaEnlazadaContarNodos<Integer> lista = new ListaEnlazadaContarNodos<>(); // crea una lista de enteros
         // insertamos elementos al inicio cada uno
        lista.insertFirst(10);
        lista.insertFirst(20);
        lista.insertFirst(30);
        int totalNodos = lista.contarNodos(); // cuenta el numero de nodos
        System.out.println("Numero total de nodos: " + totalNodos); // resultado
        lista.mostrarLista(); // imprimimos la lista
    }
}
