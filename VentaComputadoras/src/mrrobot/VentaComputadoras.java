package mrrobot;

import mrrobot.modelo.Computadora;
import mrrobot.modelo.Monitor;
import mrrobot.modelo.Raton;
import mrrobot.modelo.Teclado;
import mrrobot.servicio.Orden;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class VentaComputadoras {
    public static void main(String[] args) {

        Raton ratonLenovo = new Raton("USB", "Lenovo");
//        System.out.println(ratonLenovo);

        Teclado tecladoLenovo = new Teclado("USB", "Lenovo");
//        System.out.println(tecladoLenovo);

        Monitor monitorLenovo = new Monitor("Lenovo", 27);
//        System.out.println(monitorLenovo);


        Computadora computadoraLenovo = new Computadora("Comp Lenovo", monitorLenovo, tecladoLenovo, ratonLenovo);
//        System.out.println(computadoraLenovo);


        Monitor monitorAsus = new Monitor("ASUS", 24);
        Teclado tecladoAsus = new Teclado("BT", "ASUS");
        Raton ratonAsus = new Raton("BT", "ASUS");

        Computadora computadoraAsus = new Computadora("ASUS VivoBook 15", monitorAsus, tecladoAsus, ratonAsus);
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraAsus);
        orden1.mostrarOrden();

    }
}