package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculaLista;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CatalogoPeliculas {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

//        IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                ######## Catalogo de Peliculas ########
                1. Agregar Pelicula
                2. Listar Pelicula
                3. Buscar Pelicula
                4. Salir
                """);

        System.out.println("Ingresa una opcion: ");
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas) {

        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.println("Ingresa el nombre de la pelicula: ");
                var buscar = consola.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida." + opcion);
        }

        return salir;
    }
}