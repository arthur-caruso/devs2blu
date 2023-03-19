import java.util.Scanner;

public class Exe6 {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

        System.out.print("Tempo de serviço: "); 
        double tempoDeServico = kbd.nextDouble();

        System.out.print("Valor por hora: "); 
        double valorHora = kbd.nextDouble();

        System.out.print("Horas trabalhadas: "); 
        double horasTrabalhadas = kbd.nextDouble();

        double salarioBase;

        if (tempoDeServico < 1)
            salarioBase = 1500;
        else if (tempoDeServico < 3)
            salarioBase = 2000;
        else
            salarioBase = 3000;

        double adicional = horasTrabalhadas * valorHora;

        System.out.printf("Salário base: R$ %.2f\n", salarioBase); 
        System.out.printf("Salário total: R$ %.2f\n", salarioBase + adicional); 
        System.out.printf("Adicional no salário: R$ %.2f\n", adicional); 

        kbd.close();
	}
}
