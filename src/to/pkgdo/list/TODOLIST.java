/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package to.pkgdo.list;

import java.io.IOException;
import java.util.Scanner;


public class TODOLIST {

    public static void main(String[] args) {
        GestorDeTareas gestor = new GestorDeTareas();
        Scanner scanner = new Scanner(System.in);
        String archivo = "tareas.txt";

        // Cargar tareas al iniciar
        try {
            gestor.cargarTareas(archivo);
        } catch (IOException e) {
            System.out.println("No se pudo cargar las tareas. Se creará una nueva lista.");
        }

        while (true) {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como hecha");
            System.out.println("3. Marcar tarea como por hacer");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Mostrar tareas");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(descripcion);
                }
                case 2 -> {
                    System.out.print("Ingresa el número de la tarea a marcar como hecha: ");
                    int indiceHecha = scanner.nextInt() - 1;
                    gestor.marcarComoHecha(indiceHecha);
                }
                case 3 -> {
                    System.out.print("Ingresa el número de la tarea a marcar como por hacer: ");
                    int indicePorHacer = scanner.nextInt() - 1;
                    gestor.marcarComoPorHacer(indicePorHacer);
                }
                case 4 -> {
                    System.out.print("Ingresa el número de la tarea a eliminar: ");
                    int indiceEliminar = scanner.nextInt() - 1;
                    gestor.eliminarTarea(indiceEliminar);
                }
                case 5 -> gestor.mostrarTareas();
                case 6 -> {
                    try {
                        gestor.guardarTareas(archivo);
                        System.out.println("Tareas guardadas. ¡Hasta luego!");
                    } catch (IOException e) {
                        System.out.println("Error al guardar las tareas.");
                    }
                    return;
                }
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
