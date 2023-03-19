import java.util.Scanner;
import java.lang.Math;

public class Exe3 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.print("digite o operando 1: ");
		double operando1 = kbd.nextDouble();

		System.out.print("digite o operando 2: ");
		double operando2 = kbd.nextDouble();

		char op;

		double resultado = 0;

		do {
			System.out.print("digite a operação [+|-|*|/|^]: ");
			kbd.nextLine();
			op = kbd.nextLine().toUpperCase().charAt(0);

			switch (op) {
				case '+':
					resultado = operando1 + operando2;
					break;

				case '-':
					resultado = operando1 - operando2;
					break;

				case 'x':
					resultado = operando1 * operando2;
					break;

				case '/':
					resultado = operando1 / operando2;
					break;

				case '^':
					resultado = Math.pow(operando1, operando2);
					break;

				default:
					System.out.println("operação inválida!");
					op = ' ';
					break;
			}

		} while (op == ' ');

		System.out.printf("resultado: %.6f\n", resultado);

		kbd.close();
	}
}
