package Ejercicio1;


public class ListaEnlazadaBuscarElemento<T> { // clase generica


    public class Node<T> { // clase interna que define un nodo
        T data; // guarda el dato del nodo
        Node<T> next; // guarda la referencia al siguiente nodo


        public Node(T data) { // constructor del nodo
            this.data = data; // asigna el valor recibido al dato
            this.next = null; // el siguiente nodo empieza como nulo
        }
    }
    private Node<T> first; // referencia al primer nodo de la lista
    public ListaEnlazadaBuscarElemento() { // constructor de la lista
        this.first = null; // la lista empieza vacia
    }
    // metodo para insertar un nodo al inicio
    public void insertFirst(T x) {
        Node<T> nuevoNodo = new Node<>(x); // crea un nuevo nodo con el valor recibido
        nuevoNodo.next = first; // el siguiente del nuevo nodo es el primer nodo actual
        first = nuevoNodo; // el nuevo nodo se convierte en el primer nodo de la lista
    }
    // metodo para buscar un nodo y devolver su indice
    public int search(T x) {
        Node<T> nodoCurrent = first; // empieza desde el primer nodo
        int indice = 0; // el indice inicial es 0
        while (nodoCurrent != null) { // mientras haya nodos en la lista
            if (nodoCurrent.data.equals(x)) { // si el dato del nodo actual es igual al que buscamos
                System.out.println("Elemento " + x + " encontrado en el índice: " + indice); // muestra el indice
                return indice; // devuelve el indice donde se encuentra el nodo
            }
            nodoCurrent = nodoCurrent.next; // avanza al siguiente nodo
            indice++; // incrementa el indice
        }
        System.out.println("No está el nodo en la lista"); // si no se encuentra el nodo
        return -1; // devuelve -1 si no se encuentra el nodo
    }
    // metodo para buscar un nodo y devolver true o false si existe
    public boolean buscarElemento(T x) {
        Node<T> nodoActual = first; // empieza desde el primer nodo
        while (nodoActual != null) { // mientras haya nodos en la lista
            if (nodoActual.data.equals(x)) { // si el dato del nodo actual es igual al que buscamos
                System.out.println("El elemento " + x + " está en la lista"); // muestra que el elemento está
                return true; // devuelve true si encuentra el elemento
            }
            nodoActual = nodoActual.next; // avanza al siguiente nodo
        }
        System.out.println("No está el nodo en la lista"); // si no se encuentra el nodo
        return false; // devuelve false si no se encuentra el nodo
    }
    // metodo main para probar la clase
    public static void main(String[] args) {
        ListaEnlazadaBuscarElemento<Integer> lista = new ListaEnlazadaBuscarElemento<>(); // crea una lista de enteros
        lista.insertFirst(10); // inserta el numero 10 al inicio de la lista
        lista.insertFirst(20);
        lista.insertFirst(30);
        lista.search(20); // busca el numero 20 en la lista y muestra su indice
        lista.buscarElemento(10); // busca el numero 10 en la lista y muestra si esta
        lista.buscarElemento(40); // busca el numero 40 en la lista (no esta)
    }
}

