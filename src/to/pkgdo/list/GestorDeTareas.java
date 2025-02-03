
package to.pkgdo.list;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas {
    private List<Tarea> tareas;

    public GestorDeTareas() {
        tareas = new ArrayList<>();
    }

    // Agregar una tarea
    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    // Eliminar una tarea
    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        }
    }

    // Marcar una tarea como hecha
    public void marcarComoHecha(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).marcarComoHecha();
        }
    }

    // Marcar una tarea como por hacer
    public void marcarComoPorHacer(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).marcarComoPorHacer();
        }
    }

    // Mostrar todas las tareas
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }

    // Guardar tareas en un archivo
    public void guardarTareas(String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Tarea tarea : tareas) {
                writer.write(tarea.getDescripcion() + "," + tarea.isHecha());
                writer.newLine();
            }
        }
    }

    // Cargar tareas desde un archivo
    public void cargarTareas(String archivo) throws IOException {
        tareas.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                Tarea tarea = new Tarea(partes[0]);
                if (partes[1].equals("true")) {
                    tarea.marcarComoHecha();
                }
                tareas.add(tarea);
            }
        }
    }
}

