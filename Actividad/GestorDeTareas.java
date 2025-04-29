public class GestorDeTareas<T extends Comparable<T>> {
    private ListaEnlazada<T> tareas; // Lista enlazada para almacenar las tareas

    public GestorDeTareas() {
        this.tareas = new ListaEnlazada<>(); // Inicializamos la lista
    }

    // Agrega una tarea al final de la lista
    public void agregarTarea(T tarea) {
        tareas.insertLast(tarea); // Insertamos la tarea al final
    }

    // Elimina una tarea si existe en la lista
    public boolean eliminarTarea(T tarea) {
        if (tareas.search(tarea) != -1) { // Si la tarea existe (posición distinta de -1)
            tareas.removeNodo(tarea); // Eliminamos la tarea
            return true; // Indicamos que sí se eliminó
        }
        return false; // Indicamos que no se encontró la tarea
    }

    // Busca si una tarea existe en la lista
    public boolean contieneTarea(T tarea) {
        return tareas.search(tarea) != -1; // Retorna true si la tarea existe
    }

    // Imprime todas las tareas
    public void imprimirTareas() {
        tareas.recorrer(); // Recorremos e imprimimos cada tarea
    }

    // Cuenta el total de tareas
    public int contarTareas() {
        return tareas.length(); // Devolvemos la cantidad de tareas
    }

    // Devuelve la tarea con mayor prioridad (solo si T es de tipo Tarea)
    public T obtenerTareaMasPrioritaria() {
        if (tareas.isEmptyList()) {
            return null; // Si la lista está vacía, no hay tarea prioritaria
        }

        Nodo<T> nodoCurrent = tareas.getFirst(); // Accedemos al primer nodo
        T tareaMasPrioritaria = nodoCurrent.data; // Asumimos que el primero es el mayor
        nodoCurrent = nodoCurrent.next; // Avanzamos al segundo nodo

        while (nodoCurrent != null) { // Mientras queden nodos
            T tareaActual = nodoCurrent.data; // Tomamos el dato del nodo actual
            if (tareaActual instanceof Tarea) { // Verificamos que sea un objeto de la clase Tarea
                Tarea tareaC = (Tarea) tareaActual; // hacemos un Cast para que los objetos de tipo T se vuelvan tipo Tarea
                Tarea tareaMax = (Tarea) tareaMasPrioritaria; // hacemos un Cast para que los objetos de tipo T se vuelvan tipo Tarea

                if (tareaC.getPrioridad() > tareaMax.getPrioridad()) {
                    tareaMasPrioritaria = tareaActual; // Actualizamos la tarea más prioritaria
                }
            }
            nodoCurrent = nodoCurrent.next; // Avanzamos al siguiente nodo
        }

        return tareaMasPrioritaria; // Devolvemos la tarea con mayor prioridad
    }
   
    // Invierte la lista de tareas
    public void invertirTareas() {
        Nodo<T> nodoPrevio = null; // No hay nodo anterior al principio
        Nodo<T> nodoCurrent = tareas.getFirst(); // Empezamos desde el primer nodo
        Nodo<T> nodoSiguiente; // Variable para guardar el siguiente nodo
   
        while (nodoCurrent != null) {
            nodoSiguiente = nodoCurrent.next; // Guardamos el siguiente nodo
            nodoCurrent.next = nodoPrevio; // Invertimos el enlace
            nodoPrevio = nodoCurrent; // Movemos el previo hacia adelante
            nodoCurrent = nodoSiguiente; // Movemos el current al siguiente
        }
   
        tareas.setFirst(nodoPrevio); // El último nodo recorrido se vuelve el nuevo primero
    }
}
