import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        var salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);

            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

            System.out.println();

        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ########## Listado de Personas ###############
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Ingresa la opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingresa el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Ingresa el telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Ingresa el email: ");
                var email = consola.nextLine();

                var persona = new Persona(nombre, telefono, email);

                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }
            case 2 -> {
                System.out.println("Listado de personas: ");
                personas.forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }

        return salir;
    }
}