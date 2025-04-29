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
    public boolean equals(Object obj) {
        if (this == obj) return true; // Si es el mismo objeto, son iguales
        if (obj == null || getClass() != obj.getClass()) return false; // Si es null o diferente clase, no son iguales
        Tarea tarea = (Tarea) obj; // Convertimos el objeto a tipo Tarea
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo); // Comparamos prioridad y título
    }

    // Compara dos tareas por prioridad para ordenar
    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad); // Comparamos prioridades (de menor a mayor)
    }
}