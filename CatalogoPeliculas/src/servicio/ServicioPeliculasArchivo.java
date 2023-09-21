package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo () {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
//          Si ya existe el archivo no se vuelve a crear
            if(archivo.exists()) {
                System.out.println("El archivo ya existe!");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo creado");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo" + e.getMessage());
        }
    }
    @Override
    public void listarPeliculas() {
//        Volver a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Peliculas");
            var entrada = new BufferedReader(new FileReader(archivo));
//            Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();

//            Leemos todas las lineas disponibles
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar, se vuelve a leer
                linea = entrada.readLine();
            }

//            Cerramos el archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer el archivo + " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
//            Agregar pelicula
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego el archivo el nombre de la pelicula");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar pelicula: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo  = new File(NOMBRE_ARCHIVO);

        try {
            // Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null) {
                // Buscamos sin importar may o min
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            }

            if(encontrada)
                System.out.println("Pelicula " + lineaTexto + " encontrada - linea " + indice);
            else
                System.out.println("No se encontro la pelicula");

            entrada.close();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al buscar en el archivo: " + e.getMessage());
        }
    }
}
