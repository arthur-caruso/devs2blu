package cardapio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner kbd = new Scanner(System.in);
    private static ArrayList<ItemCardapio> cardapio = new ArrayList<ItemCardapio>();
    private static ItemCardapio prato;
    private static String nome;
    private static int opcao;

    public static void main(String[] args) {


        while (true) {
            System.out.println("opções:");
            System.out.println("\t0 - sair do programa");
            System.out.println("\t1 - criar novo prato");
            System.out.println("\t2 - ler ingredientes de um prato");
            System.out.println("\t3 - editar um prato");
            System.out.println("\t4 - deletar um prato");
            System.out.println("\t5 - listar pratos");

            System.out.print("Opção: ");
            opcao = kbd.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("saindo do programa...");
                    break;

                case 1:
                    System.out.println("criando prato...");
                    cardapio.add(new Prato());
                    break;

                case 2:
                    System.out.println("lendo ingredientes de um prato existente...");
                    kbd.nextLine();
                    System.out.print("\tprocurar por nome: ");
                    nome = kbd.nextLine();

                    prato = null;
                    for(int i = 0; i < cardapio.size(); i++)
                        if (cardapio.get(i).getNome().equals(nome))
                            prato = cardapio.get(i);

                    if (prato != null)
                        prato.lerIngredientes();
                    else
                        System.out.println("prato não encontrado!");

                    break;

                case 3:
                    System.out.println("editando prato existente...");

                    kbd.nextLine();
                    System.out.print("\tprocurar por nome: ");
                    nome = kbd.nextLine();

                    prato = null;
                    for(int i = 0; i < cardapio.size(); i++)
                        if (cardapio.get(i).getNome().equals(nome))
                            prato = cardapio.get(i);

                    if (prato != null) {
                        prato.editarNome();
                        prato.editarIngredientes();
                        prato.editarPreco();
                    } else
                        System.out.println("prato não encontrado!");

                    break;

                case 4:
                    System.out.println("deletando prato existente...");

                    kbd.nextLine();
                    System.out.print("\tProcurar por título: ");
                    nome = kbd.nextLine();

                    prato = null;
                    for (int i = 0; i < cardapio.size(); i++)
                        if (cardapio.get(i).getNome().equals(nome)) {
                            prato = cardapio.get(i);
                            cardapio.remove(i);
                        }

                    if (prato == null)
                        System.out.println("prato não encontrado!");

                    break;
                
                case 5:
                    System.out.println("listando pratos existentes...");

                    if (cardapio.size() == 0)
                        System.out.println("nenhum prato cadastrado!");
                    else
                        for(int i = 0; i < cardapio.size(); i++)
                            cardapio.get(i).lerNome();

                    break;

                default:
                    System.out.println("opção inválida!");
                    break;
            }

            if (opcao == 0) break;
        }
    }
}
