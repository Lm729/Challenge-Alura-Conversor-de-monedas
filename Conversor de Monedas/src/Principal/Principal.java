package Principal;

import Datos.DatosMoneda;
import Servicios.ConsultaAPI;
import com.google.gson.Gson;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ConsultaAPI consulta = new ConsultaAPI();
        Scanner usuario = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.println("Bienvenido al Convertidor de Monedas");
        menuPrincipal:
        while (true) {
            System.out.println("\n1. Convartir Monedas\n" + "2. Ver las 5 Monedas más relevantes\n" + "3. Ver todas las Monedas disponibles\n" + "4. Ver historial de Operaciones\n" + "5. Eliminar hisrotial de Operaciones\n" + "0. Salir\n" + "Elija una opción: ");

            int entrada = usuario.nextInt();
            usuario.nextLine();

            switch (entrada) {
                case 1:
                    System.out.println("Elija la moneda base que desea convertir, escriba el código. EJ: USD");
                    String monedaBase = usuario.nextLine();
                    System.out.println("Elija la moneda final que desea, escriba el código. EJ: EUR");
                    String monedaFinal = usuario.nextLine().toUpperCase();
                    System.out.println("Ingrese el Monto que quiere convertir: ");
                    double monto = usuario.nextDouble();

                    String Json = consulta.obtenerTasas(monedaBase, monedaFinal, monto);
                    DatosMoneda monedas = gson.fromJson(Json, DatosMoneda.class);

                    System.out.printf("La moneda que desea convertir es: " + monedaBase + ": " + monto + " a la moneda: " + monedaFinal + "\nLa tasa es: " + monedas.conversion_rate() + "\nLa conversión es: " + monedas.conversion_result());
                    break;

                case 2:
                    System.out.println("Las 5 Monedas más relevantes son: ");
                    break;

                case 3:
                    System.out.println("Listado de Monedas disponibles");
                    break;

                case 4:
                    System.out.println("Listado de Operaciones");
                    break;

                case 5:
                    System.out.println("Historial de Operaciones borrado");
                    break;

                case 0:
                    System.out.println("Muchas gracias por utilizar nuestro Conversor");
                    break menuPrincipal;

            }
        }
    }
}