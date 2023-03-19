import java.util.Scanner;

public class Computer {
	int tamMem;
	int numInstr;
	int numReg;
	int numCores;
	int instrReg;
	int instrAddrReg;

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		Computer comp1 = new Computer();

		System.out.print("digite o tamanho da memória em bytes: ");
		comp1.tamMem = kbd.nextInt();

		System.out.print("digite o número de instruções: ");
		comp1.numInstr = kbd.nextInt();

		System.out.print("digite o número de registradores: ");
		comp1.numReg = kbd.nextInt();

		System.out.print("digite o número de cores: ");
		comp1.numCores = kbd.nextInt();

		System.out.print("digite o número da instrução atual: ");
		comp1.instrReg = kbd.nextInt();

		System.out.print("digite o endereço de memória da próxima instrução: ");
		comp1.instrAddrReg = kbd.nextInt();

		kbd.close();
	}
}
