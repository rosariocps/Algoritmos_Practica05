public class ListaEnlazada<T extends Comparable<T>> {
    private Nodo<T> first; // Primer nodo de la lista

    // Constructor
    public ListaEnlazada() {
        this.first = null; // Inicializamos la lista como vacía
    }

    // Getter para obtener el primer nodo
    public Nodo<T> getFirst() {
        return first;
    }

    // Setter para cambiar el primer nodo
    public void setFirst(Nodo<T> first) {
        this.first = first;
    }

    // Verifica si la lista está vacía *
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

    // Elimina todos los nodos de la lista*
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

    // Inserta un nuevo elemento al inicio de la lista*
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

        Nodo<T> nodoPrevio = first; // Empezamos desde el primer nodo
        Nodo<T> nodoCurrent = first.next; // Nodo siguiente al primero

        while (nodoCurrent != null) { // Mientras haya nodos
            if (nodoCurrent.data.equals(x)) { // Si encontramos el dato
                nodoPrevio.next = nodoCurrent.next; // Saltamos el nodo a eliminar
                return;
            }
            nodoPrevio = nodoCurrent; // Avanzamos el previo
            nodoCurrent = nodoCurrent.next; // Avanzamos el actual
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

    public void invertir() {
        ListaEnlazada<T> listaTemporal = new ListaEnlazada<>(); // Creamos una lista nueva
        Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo de la lista original
    
        while (nodoCurrent != null) {
            Nodo<T> nuevoNodo = new Nodo<>(nodoCurrent.data); // Creamos un nuevo nodo con el mismo dato
            nuevoNodo.next = listaTemporal.first; // Apuntamos el nuevo nodo al primero de la nueva lista
            listaTemporal.first = nuevoNodo; // Ahora este nuevo nodo es el primero de la lista temporal
            nodoCurrent = nodoCurrent.next; // Avanzamos en la lista original
        }
    
        first = listaTemporal.first; // Reemplazamos la lista original con la invertida
    }
    
    public void ordenar() { //Ordenamiento con Bubble Sort 
        if (first == null || first.next == null) {
            return; // La lista ya está ordenada si está vacía o tiene un solo nodo
        }
    
        boolean swapp; //Indica si hubo intercambios en una pasada
    
        do {
            swapp = false;
            Nodo<T> nodoCurrent = first; // Empezamos desde el primer nodo
    
            while (nodoCurrent.next != null) { // Mientras haya un siguiente nodo
                if (nodoCurrent.data.compareTo(nodoCurrent.next.data) > 0) {
                    // Intercambiamos los datos de los nodos si están en el orden incorrecto
                    T temp = nodoCurrent.data;
                    nodoCurrent.data = nodoCurrent.next.data;
                    nodoCurrent.next.data = temp;
    
                    swapp = true; // Se hizo un intercambio
                }
                nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
            }
        } while (swapp); // Repetimos mientras haya intercambios
    }
}
