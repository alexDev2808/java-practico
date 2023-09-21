import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        while (true) {
            System.out.println("########### Calculadora #############");
            mostrarMenu();
            System.out.println("Ingresa una opcion:  ");

            try {
                var operacion = Integer.parseInt(consola.nextLine());

                if (operacion >= 1 && operacion <= 4) {
                    realizarOperacion(operacion, consola);
                } else if (operacion == 5) {
                    System.out.println("Hasta pronto...");
                    break;
                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }

                System.out.println();

            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                """);
    }

    private static void realizarOperacion(int operacion, Scanner consola) {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Ingresa el primer valor: ");
        var valor1 = Double.parseDouble(consola.nextLine());
        System.out.println("Ingresa el segundo valor: ");
        var valor2 = Double.parseDouble(consola.nextLine());
        double resultado = 0.0;

        switch (operacion) {
            case 1 -> {
                resultado = valor1 + valor2;
                System.out.print("Resultado de la suma: ");
            }
            case 2 -> {
                resultado = valor1 - valor2;
                System.out.print("Resultado de la resta: ");
            }
            case 3 -> {
                resultado = valor1 * valor2;
                System.out.print("Resultado de la multiplicacion: ");
            }
            case 4 -> {
                resultado = valor1 / valor2;
                System.out.print("Resultado de la division: ");
            }
            default -> System.out.println("Opcion incorrecta!!");
        }

        System.out.print(df.format(resultado));
    }
}
