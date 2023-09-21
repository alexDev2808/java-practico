package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculaLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculaLista() {
        this.peliculas = new ArrayList<>();
    }
    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
//        Regresa el indice de la pelicula
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontro la pelicula: " + pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }

    public static void main(String[] args) {
        var pelicula = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

//        Patron de diseno service
        IServicioPeliculas servicioPeliculas = new ServicioPeliculaLista();

        servicioPeliculas.agregarPelicula(pelicula);
        servicioPeliculas.agregarPelicula(pelicula2);

        servicioPeliculas.listarPeliculas();

        servicioPeliculas.buscarPelicula(pelicula2);
        servicioPeliculas.buscarPelicula(new Pelicula("Joker"));
    }
}
