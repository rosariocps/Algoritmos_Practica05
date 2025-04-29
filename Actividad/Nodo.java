public class Nodo<T> {
    T data; // Dato almacenado en el nodo
    Nodo<T> next; // Referencia al siguiente nodo en la lista

    // Constructor
    public Nodo(T data) {
        this.data = data; // Asignamos el dato al nodo
        this.next = null; // Inicialmente no apunta a ningún nodo (es el último)
    }
}
