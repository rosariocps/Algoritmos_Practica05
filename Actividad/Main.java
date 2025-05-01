import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        // Agregar tareas
        gestor.agregarTarea(new Tarea("Limpiar mi habitación", 3));
        gestor.agregarTarea(new Tarea("Ordenar la ropa en el armario", 2));
        gestor.agregarTarea(new Tarea("Cocinar el almuerzo", 4));
        gestor.agregarTarea(new Tarea("Lavar los platos", 1));
        gestor.agregarTarea(new Tarea("Sacar la basura", 4));
        gestor.agregarTarea(new Tarea("Barrer y trapear el piso", 6));

        // Imprimir todas las tareas actuales
        System.out.println("Tareas actuales:");
        gestor.imprimirTareas();

        // Contar tareas
        System.out.println("\nCantidad de tareas: " + gestor.contarTareas());

        // Buscar si existe una tarea específica
        boolean existe = gestor.contieneTarea(new Tarea("Cocinar el almuerzo", 4));
        System.out.println("\n¿Existe 'Cocinar el almuerzo'? " + existe);

        // Eliminar una tarea
        gestor.eliminarTarea(new Tarea("Ordenar la ropa en el armario", 2));

        // Imprimir tareas después de eliminar
        System.out.println("\nTareas después de eliminar 'Ordenar la ropa en el armario':");
        gestor.imprimirTareas();

        // Invertir la lista
        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

        // Ordenar la lista
        gestor.ordenarTareas();
        System.out.println("\nTareas ordenadas por prioridad:");
        gestor.imprimirTareas();

        // Obtener la tarea de mayor prioridad
        Tarea tareaMayorPrioridad = (Tarea) gestor.obtenerTareaMasPrioritaria();
        if (tareaMayorPrioridad != null) {
            System.out.println("\nTarea de mayor prioridad:");
            System.out.println(tareaMayorPrioridad);
        } else {
            System.out.println("\nNo hay tareas para obtener la mayor prioridad.");
        }

        // Transferir una tarea a la lista de tareas completadas
        List<Tarea> tareasCompletadas = new ArrayList<>();
        Tarea tareaCompletada = new Tarea("Sacar la basura", 5);

        if (gestor.eliminarTarea(tareaCompletada)) {
            tareasCompletadas.add(tareaCompletada);
        }

        // Mostrar ambas listas
        System.out.println("\nTareas pendientes:");
        gestor.imprimirTareas();

        System.out.println("\nTareas completadas:");
        for (Tarea t : tareasCompletadas) {
            System.out.println(t);
        }
    }
}

