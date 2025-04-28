public class ListaEnlazada<T extends Comparable<T>> {
    private Nodo<T> first; // Primer nodo de la lista


    // Getter para obtener el primer nodo
    public Nodo<T> getFirst() {
        return first;
    }


    // Setter para cambiar el primer nodo
    public void setFirst(Nodo<T> first) {
        this.first = first;
    }


    // Constructor
    public ListaEnlazada() {
        this.first = null; // Inicializamos la lista como vacía
    }


    // Verifica si la lista está vacía
    public boolean isEmptyList() {
        return first == null; // Retorna true si no hay nodos
    }


    // Cuenta la cantidad de nodos en la lista
    public int length() {
        int contador = 0; // Inicializamos el contador
        Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
        while (nodoCurrent != null) { // Mientras haya nodos
            contador++; // Aumentamos el contador
            nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
        }
        return contador; // Retornamos la cantidad de nodos
    }


    // Elimina todos los nodos de la lista
    public void destroyList() {
        first = null; // Simplemente rompemos la referencia al primer nodo
    }


    // Busca un elemento y retorna su posición (o -1 si no existe)
    public int search(T x) {
        Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
        int posicion = 0; // Posición inicial
        while (nodoCurrent != null) { // Mientras haya nodos
            if (nodoCurrent.data.equals(x)) { // Si encontramos el dato
                return posicion; // Retornamos su posición
            }
            nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
            posicion++; // Aumentamos la posición
        }
        return -1; // Si no encontramos, retornamos -1
    }


    // Inserta un nuevo elemento al inicio de la lista
    public void insertFirst(T x) {
        Nodo<T> nodoNuevo = new Nodo<>(x); // Creamos el nuevo nodo
        nodoNuevo.next = first; // El nuevo nodo apunta al primer nodo actual
        first = nodoNuevo; // Actualizamos first para que sea el nuevo nodo
    }


    // Inserta un nuevo elemento al final de la lista
    public void insertLast(T x) {
        if (first == null) { // Si la lista está vacía
            Nodo<T> nodoNuevo = new Nodo<>(x); // Creamos el nuevo nodo
            first = nodoNuevo; // Lo ponemos como primer nodo
        } else {
            Nodo<T> nodoNuevo = new Nodo<>(x); // Creamos el nuevo nodo
            Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
            while (nodoCurrent.next != null) { // Avanzamos hasta el último nodo
                nodoCurrent = nodoCurrent.next;
            }
            nodoCurrent.next = nodoNuevo; // Enlazamos el último nodo al nuevo
        }
    }


    // Elimina el primer nodo que contenga el dato x
    public void removeNodo(T x) {
        if (first == null) { // Si la lista está vacía
            return; // No hay nada que eliminar
        }


        if (first.data.equals(x)) { // Si el primer nodo contiene el dato
            first = first.next; // Eliminamos el primer nodo
            return;
        }


        Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
        Nodo<T> nodoSiguiente = first.next; // Nodo siguiente al primero


        while (nodoSiguiente != null) { // Mientras haya nodos
            if (nodoSiguiente.data.equals(x)) { // Si encontramos el dato
                nodoCurrent.next = nodoSiguiente.next; // Saltamos el nodo a eliminar
                return;
            }
            nodoCurrent = nodoSiguiente; // Avanzamos el actual
            nodoSiguiente = nodoSiguiente.next; // Avanzamos el siguiente
        }
    }


    // Recorre y muestra todos los datos de la lista
    public void recorrer() {
        Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
        while (nodoCurrent != null) { // Mientras haya nodos
            System.out.println(nodoCurrent.data); // Imprimimos el dato
            nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
        }
    }


    // Ordena los elementos de la lista usando Bubble Sort
    public void ordenar() {
        if (first == null || first.next == null) { // Si hay 0 o 1 elementos
            return; // Ya está ordenado
        }


        boolean swapped; // Variable para saber si hubo intercambio


        do {
            swapped = false; // Reiniciamos swapped al empezar cada pasada
            Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo


            while (nodoCurrent.next != null) { // Mientras haya un siguiente nodo
                if (nodoCurrent.data.compareTo(nodoCurrent.next.data) > 0) { // Si el actual es mayor que el siguiente
                    T temp = nodoCurrent.data; // Guardamos temporalmente el dato actual
                    nodoCurrent.data = nodoCurrent.next.data; // Intercambiamos los datos
                    nodoCurrent.next.data = temp;
                    swapped = true; // Hubo un intercambio
                }
                nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
            }


        } while (swapped); // Seguimos mientras haya intercambios
    }
}
