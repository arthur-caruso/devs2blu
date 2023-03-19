package agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ArrayList<Contato> contatos = new ArrayList<Contato>();

		Contato c1 =  new Contato("Sheila","(47) 9 9183-7264");
		c1.addEndereco(new Endereco("SC","Blumenau","Centro","XV de Novembro",1250,89074548));
        contatos.add(c1);

        char option;
        do {
            System.out.print("Opções: \n\tl - Listar contatos\n\ts - Sair\n");
            System.out.print("Opção: ");
            option = kbd.nextLine().charAt(0);

            switch (option) {
                case 'l':
                    for(int i = 0; i < contatos.size(); i++)
                        System.out.printf("{Contato %d: %s}\n", i, contatos.get(i).toString());
                    break;

                case 's':
                    System.out.println("Saindo do programa...");
		            break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (option != 's');

        kbd.close();
    }
}
