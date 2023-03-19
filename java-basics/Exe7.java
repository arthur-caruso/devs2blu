package desafio1;

import java.lang.Math;
import java.util.Scanner;

public class Exe7 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.print("coeficientes: ");
        double a = kbd.nextDouble();
        double b = kbd.nextDouble();
        double c = kbd.nextDouble();
        double d = Math.sqrt(b * b - 4 * a * c);

        if (d > 0)
            System.out.printf("raiz 1: %.2f\nraiz 2: %.2f\n", (d - b) / (2 * a), (- d - b) / (2 * a));
        else if (d == 0)
            System.out.printf("raiz: %.2f\n", - b / (2 * a));
        else
            System.out.println("raízes imaginárias");

        kbd.close();
    }
}
