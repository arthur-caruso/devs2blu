import java.util.Scanner;

public class Exe2 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		System.out.print("digite a velocidade do carro [km/h]: ");
		double velCarro = kbd.nextDouble();

		System.out.print("digite a velocidade máxima [km/h]: ");
		double velMax = kbd.nextDouble();

		double excesso = velCarro - velMax;

		if (excesso > 0) {
			if (excesso <= 10)
				System.out.println("50 reais");
			else if (excesso <= 30)
				System.out.println("100 reais");
			else
				System.out.println("300 reais");
		}

		kbd.close();
	}
}
