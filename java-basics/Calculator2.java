import java.util.Scanner;
import java.lang.Math;

public class Calculator2 {
	public double op1, op2;

	public Calculator2(double x, double y) {  
		this.op1 = x;
		this.op2 = y;
	}

	public double add() {
		return this.op1 + this.op2;
	}

	public double sub() {
		return this.op1 - this.op2;
	}

	public double mul() {
		return this.op1 * this.op2;
	}

	public double div() {
		return this.op1 / this.op2;
	}

	public double exp() {
		return Math.pow(this.op1, this.op2);
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		Calculator2 calc;
		double x, y, res;
		char op;

		do {
			res = 0;
	
			System.out.print("Expressão: ");
			x = kbd.nextDouble();
			op = kbd.next().charAt(0);
			y = kbd.nextDouble();

			calc = new Calculator2(x, y);

			switch (op) {
				case '+':
					res = calc.add();
					break;

				case '-':
					res = calc.sub();
					break;

				case '*':
					res = calc.mul();
					break;

				case '/':
					res = calc.div();
					break;

				case '^':
					res = calc.exp();
					break;

				default:
					System.out.println("operação inválida!");
					op = ' ';
					break;
			}

		} while (op == ' ');

		System.out.printf("%.2f %c %.2f = %.2f\n", x, op, y, res);
		kbd.close();
   }  
}
