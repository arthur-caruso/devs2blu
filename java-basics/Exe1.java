import java.util.Scanner;

public class Exe1 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.print("digite o primeiro número: ");
		double num1 = kbd.nextDouble();

		System.out.print("digite o segundo número: ");
		double num2 = kbd.nextDouble();

		System.out.print("digite o terceiro número: ");
		double num3 = kbd.nextDouble();

		if (num2 + num3 > 0) {
			System.out.println("não");
		} else {
			System.out.println("sim");
		}

		kbd.close();
	}
}
