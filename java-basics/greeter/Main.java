package greeter;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ArrayList<String> pessoas = new ArrayList<String>();
        String pessoa1, pessoa2, pessoa3;
        Greeter hello = new Greeter();
        int opcao;

        do {
            System.out.println("Opções:");
            System.out.println("\t0 - Sair do programa (não cumprimentar ninguém)");
            System.out.println("\t1 - Cumprimentar uma pessoa");
            System.out.println("\t2 - Cumprimentar duas pessoas");
            System.out.println("\t3 - Cumprimentar três pessoas");
            System.out.println("\t4 - Cumprimentar uma lista de pessoas");
            System.out.println("\t5 - Cumprimentar");

            System.out.print("Opção: ");
            opcao = kbd.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                case 1:
                    System.out.println("Cumprimentando uma pessoa...");
                    kbd.nextLine();

                    System.out.print("Digite o nome da primeira pessoa: ");
                    pessoa1 = kbd.nextLine();
                    
                    hello.greet(pessoa1);
                    break;

                case 2:
                    System.out.println("Cumprimentando duas pessoas...");
                    kbd.nextLine();

                    System.out.print("Digite o nome da primeira pessoa: ");
                    pessoa1 = kbd.nextLine();
                    System.out.print("Digite o nome da segunda pessoa: ");
                    pessoa2 = kbd.nextLine();

                    hello.greet(pessoa1, pessoa2);
                    break;

                case 3:
                    System.out.println("Cumprimentando três pessoas...");
                    kbd.nextLine();

                    System.out.print("Digite o nome da primeira pessoa: ");
                    pessoa1 = kbd.nextLine();
                    System.out.print("Digite o nome da segunda pessoa: ");
                    pessoa2 = kbd.nextLine();
                    System.out.print("Digite o nome da terceira pessoa: ");
                    pessoa3 = kbd.nextLine();

                    hello.greet(pessoa1, pessoa2, pessoa3);
                    break;

                case 4:
                    System.out.println("Cumprimentando uma lista de pessoas...");
                    kbd.nextLine();

                    while (true) {
                        System.out.print("Digite um nome: ");
                        pessoa1 = kbd.nextLine();

                        if (pessoa1.equals(""))
                            break;
                        else
                            pessoas.add(pessoa1);
                    }

                    hello.greet(pessoas);
                    break;

                case 5:
                    hello.greet();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}