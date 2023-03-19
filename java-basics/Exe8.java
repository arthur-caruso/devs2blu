package converter;

import java.util.Scanner;

public class Exe8 {
    public static double celsius;
    public static double fahrenheit;
    public static int option;

    public static void celsiusToFahrenheit() {
        fahrenheit = celsius * 5.0 / 9.0 + 32;
    }

    public static void fahrenheitToCelsius() {
        celsius = (fahrenheit - 32) * 9.0 / 5.0;
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        do {
            System.out.println("Options:");
            System.out.println("\t0 - Exit");
            System.out.println("\t1 - Convert Cº to Fº");
            System.out.println("\t2 - Convert Fº to Cº");

            System.out.print("Option: ");
            option = kbd.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;

                case 1:
                    System.out.println("Converting Cº to Fº...");

                    System.out.print("\tTemperature (Cº): ");
                    celsius = kbd.nextDouble();

                    celsiusToFahrenheit();
                    System.out.printf("\t%.2f Cº = %.2f Fº\n", celsius, fahrenheit);

                    break;

                case 2:
                    System.out.println("Converting Fº to Cº...");

                    System.out.print("\tTemperature (Fº): ");
                    fahrenheit = kbd.nextDouble();

                    fahrenheitToCelsius();
                    System.out.printf("\t%.2f Fº = %.2f Cº\n", fahrenheit, celsius);

                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 0);

        kbd.close();
    }
}
