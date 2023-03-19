package pessoa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        String nome;
        int anoNascimento;
        double peso;
        double altura;

        Pessoa p1 = new Pessoa();

        System.out.println("[Cadastrar Pessoa]");
		System.out.print("\tDigite o nome: ");
		nome = kbd.nextLine();
		System.out.print("\tDigite o ano de nascimento: ");
		anoNascimento = kbd.nextInt();
        System.out.print("\tDigite peso: ");
		peso = kbd.nextDouble();
        System.out.print("\tDigite a altura: ");
		altura = kbd.nextDouble();

        p1.cadastrarPessoa(nome, anoNascimento, peso, altura);

        System.out.println("[Mostrar Dados]");
		System.out.printf("\tNome: %s\n", p1.nome);
        System.out.printf("\tAno de nascimento: %d\n", p1.anoNascimento);
        System.out.printf("\tPeso: %.2f\n", p1.peso);
        System.out.printf("\tAltura: %.2f\n", p1.altura);
        System.out.printf("\tIdade: %d\n", p1.idade);

        kbd.close();
    }

}
