package nota;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ArrayList<Nota> notas = new ArrayList<Nota>();
        Nota nota;
        String titulo;
        int opcao, tipoNota;

        do {
            System.out.println("Opções:");
            System.out.println("\t0 - Sair do programa");
            System.out.println("\t1 - Criar nova nota");
            System.out.println("\t2 - Ler uma nota");
            System.out.println("\t3 - Editar uma nota");
            System.out.println("\t4 - Deletar uma nota");
            System.out.println("\t5 - Listar notas");

            System.out.print("Opção: ");
            opcao = kbd.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                case 1:
                    do {
                        System.out.println("Criando nova nota...");
                        System.out.println("Escolha o tipo de nota:");
                        System.out.println("\t0 - Cancelar operação");
                        System.out.println("\t1 - Lista");
                        System.out.println("\t2 - Resenha");
                        System.out.println("\t3 - Desenho");

                        System.out.print("Tipo de nota: ");
                        tipoNota = kbd.nextInt();

                        switch (tipoNota) {
                            case 0:
                                System.out.println("Cancelando operação...");
                                break;

                            case 1:
                                notas.add(new Lista());
                                break;

                            case 2:
                                notas.add(new Resenha());
                                break;

                            case 3:
                                notas.add(new Desenho());
                                break;

                            default:
                                System.out.println("Tipo inválido!");
                                break;
                        }
                    } while (   tipoNota != 0 &&
                                tipoNota != 1 &&
                                tipoNota != 2 &&
                                tipoNota != 3);
                    break;

                case 2:
                    System.out.println("Lendo nota existente...");

                    kbd.nextLine();
                    System.out.print("\tProcurar por título: ");
                    titulo = kbd.nextLine();

                    nota = null;
                    for(int i = 0; i < notas.size(); i++)
                        if (notas.get(i).getTitulo().equals(titulo))
                            nota = notas.get(i);

                    if (nota != null)
                        nota.lerConteudo();
                    else
                        System.out.println("Nota não encontrada!");

                    break;

                case 3:
                    System.out.println("Editando nota existente...");

                    kbd.nextLine();
                    System.out.print("\tProcurar por título: ");
                    titulo = kbd.nextLine();

                    nota = null;
                    for(int i = 0; i < notas.size(); i++)
                        if (notas.get(i).getTitulo().equals(titulo))
                            nota = notas.get(i);

                    if (nota != null) {
                        // editar título | conteúdo
                        nota.editarConteudo();
                    } else
                        System.out.println("Nota não encontrada!");

                    break;

                case 4:
                    System.out.println("Deletando nota existente...");

                    kbd.nextLine();
                    System.out.print("\tProcurar por título: ");
                    titulo = kbd.nextLine();

                    nota = null;
                    for(int i = 0; i < notas.size(); i++)
                        if (notas.get(i).getTitulo().equals(titulo)) {
                            nota = notas.get(i);
                            notas.remove(i);
                        }

                    if (nota == null)
                        System.out.println("Nota não encontrada!");

                    break;
                
                case 5:
                    System.out.println("Listando notas existentes...");

                    if (notas.size() == 0)
                        System.out.println("Nenhuma nota cadastrada!");
                    else
                        for(int i = 0; i < notas.size(); i++)
                            notas.get(i).lerTitulo();

                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }
}
