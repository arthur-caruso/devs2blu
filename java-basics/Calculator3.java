import java.util.Scanner;

public class Calculator3 {
	private double n1, n2;

	public Calculator3() {}

	public Calculator3(double n1, double n2) {  
		this.n1 = n1;
		this.n2 = n2;
	}

	private void setN1(double n1) { this.n1 = n1; }
	private void setN2(double n2) { this.n2 = n2; }

	private double getN1() { return n1; }
	private double getN2() { return n2; }

	public double getAdd() { return n1 + n2; }
	public double getSub() { return n1 - n2; }
	public double getMul() { return n1 * n2; }
	public double getDiv() { return n1 / n2; }

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);

		Calculator3 calc = new Calculator3();
		double x, y, res;
		char exit, op;

		do {
			do {
				System.out.print("Expressão: ");
				x = kbd.nextDouble();
				op = kbd.next().charAt(0);
				y = kbd.nextDouble();

				res = 0;

				calc.setN1(x);
				calc.setN2(y);

				switch (op) {
					case '+':
						res = calc.getAdd();
						break;

					case '-':
						res = calc.getSub();
						break;

					case '*':
						res = calc.getMul();
						break;

					case '/':
						res = calc.getDiv();
						break;

					default:
						System.out.println("Operação inválida!");
						break;
				}

			} while (	op != '+' &&
						op != '-' &&
						op != '*' &&
						op != '/');

			System.out.printf("%.2f %c %.2f = %.2f\n", x, op, y, res);

			System.out.print("Sair? [s/n] ");
			exit = kbd.next().charAt(0);

		} while (exit != 's');

		kbd.close();
   }  
}
