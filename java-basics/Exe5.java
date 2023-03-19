import java.util.Scanner;
import java.util.Random;

public class Exe5 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		Random seed = new Random();
		int number = seed.nextInt(100);

		int guess;

		do {
			System.out.print("digite um número: ");
			guess = kbd.nextInt();

			if (guess < number)
				System.out.println("MAIOR");
			if (guess > number)
				System.out.println("MENOR");

		} while (guess != number);

		System.out.println("acertou!");

		kbd.close();
	}
}
