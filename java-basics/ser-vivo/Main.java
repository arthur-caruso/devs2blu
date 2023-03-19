package servivo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ArrayList<SerVivo> animais = new ArrayList<SerVivo>();
        ArrayList<SerVivo> plantas = new ArrayList<SerVivo>();
        ArrayList<SerVivo> fungos = new ArrayList<SerVivo>();

        SerVivo serVivo;

        String reino, filo, classe, ordem, familia, genero, especie;
        char option;

        do {
            System.out.println("Opções:");
            System.out.println("\t0 - Sair");
            System.out.println("\t1 - Cadastrar ser vivo");
            System.out.println("\t2 - Listar animais");
            System.out.println("\t3 - Listar plantas");
            System.out.println("\t4 - Listar fungos");

            System.out.print("Opção: ");
            option = kbd.nextLine().charAt(0);

            switch (option) {
                case '0':
                    System.out.println("Saindo do programa...");
                    break;

                case '1':
                    System.out.println("Cadastrando ser vivo...");

                    System.out.print("\tReino: ");
                    reino = kbd.nextLine();

                    System.out.print("\tFilo: ");
                    filo = kbd.nextLine();

                    System.out.print("\tClasse: ");
                    classe = kbd.nextLine();

                    System.out.print("\tOrdem: ");
                    ordem = kbd.nextLine();

                    System.out.print("\tFamilia: ");
                    familia = kbd.nextLine();

                    System.out.print("\tGenero: ");
                    genero = kbd.nextLine();

                    System.out.print("\tEspecie: ");
                    especie = kbd.nextLine();

                    serVivo = new SerVivo(reino, filo, classe, ordem, familia, genero, especie);

                    if (reino.equalsIgnoreCase("animalia")) animais.add(serVivo);
                    if (reino.equalsIgnoreCase("plantae"))  plantas.add(serVivo);
                    if (reino.equalsIgnoreCase("fungi"))    fungos.add(serVivo);

                    break;

                case '2':
                    System.out.println("Listando animais...");
                    for(int i = 0; i < animais.size(); i++)
                        System.out.printf("%d - {%s}\n", i, animais.get(i).toString());
                    break;

                case '3':
                    System.out.println("Listando plantas...");
                    for(int i = 0; i < plantas.size(); i++)
                        System.out.printf("%d - {%s}\n", i, plantas.get(i).toString());
                    break;
                
                case '4':
                    System.out.println("Listando fungos...");
                    for(int i = 0; i < fungos.size(); i++)
                        System.out.printf("%d - {%s}\n", i, fungos.get(i).toString());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (option != '0');

        kbd.close();
    }
}
