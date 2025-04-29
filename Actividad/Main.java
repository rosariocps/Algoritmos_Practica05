import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        // Agregar tareas
        gestor.agregarTarea(new Tarea("Limpiar mi habitación", 3));
        gestor.agregarTarea(new Tarea("Ordenar la ropa en el armario", 2));
        gestor.agregarTarea(new Tarea("Cocinar el almuerzo", 4));
        gestor.agregarTarea(new Tarea("Lavar los platos", 3));
        gestor.agregarTarea(new Tarea("Sacar la basura", 5));
        gestor.agregarTarea(new Tarea("Barrer y trapear el piso", 4));

        // Eliminar una tarea
        gestor.eliminarTarea(new Tarea("Ordenar la ropa en el armario", 2));

        // Imprimir todas las tareas actuales
        System.out.println("Tareas actuales:");
        gestor.imprimirTareas();

        // Verificar si cierta tarea existe
        boolean existe = gestor.contieneTarea(new Tarea("Cocinar el almuerzo", 4));
        System.out.println("\n¿Existe 'Cocinar el almuerzo'? " + existe);

        // Invertir la lista
        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

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

