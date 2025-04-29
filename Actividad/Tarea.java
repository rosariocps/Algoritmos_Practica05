public class Tarea implements Comparable<Tarea> {
    private String titulo; // Título o descripción de la tarea
    private int prioridad; // A mayor número, mayor importancia

    // Constructor
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo; // Asignamos el título recibido
        this.prioridad = prioridad; // Asignamos la prioridad recibida
    }

    // Getter para obtener el título
    public String getTitulo() {
        return titulo;
    }

    // Getter para obtener la prioridad
    public int getPrioridad() {
        return prioridad;
    }

    // Devuelve una representación en texto de la tarea
    @Override
    public String toString() {
        return "- " + titulo + " (Prioridad: " + prioridad + ")"; // Formato bonito para impresión
    }

    // Compara si dos tareas son iguales
    @Override
    public boolean equals(Object obj) { // Object, el tipo más general en Java.
        if (this == obj) return true; // this es el objeto actual y obj es el objeto con el que compararemos
        // Si es null o si son de diferente clase, retornamos null
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj; // casteo - convertimos el obj a tipo Tarea
        // aqui comparamos dos atributos del objeto actual (this) con los atributos del objeto tarea
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }

    // Compara dos tareas por prioridad para ordenar
    @Override
    //un parámetro tipo Tarea llamado otra que es el objeto con el que se va a comparar el objeto actual (this).
    //devolvera un entero: negativo si this es menor, 0 si son iguales, positivo si this es mayor
    public int compareTo(Tarea otra) {
        //devolvera un entero
        return Integer.compare(this.prioridad, otra.prioridad); // Comparamos prioridades (de menor a mayor)
    }
}