package nota;

import java.util.Scanner;
import java.util.ArrayList;

public class Lista implements Anotavel, Listavel {
    public String titulo;
    public ArrayList<String> conteudo = new ArrayList<String>();

    public Lista() {
        cadastrar();
    }

    public void cadastrar() {
        editarTitulo();
        editarConteudo();
    }

    public void lerTitulo() {
        System.out.println("\"" + titulo + "\"" + " [Lista]");
    }

    public void lerConteudo() {
        if (conteudo.size() == 0)
            System.out.println("Nenhum item cadastrado!");
        else
            for (int i = 0; i < conteudo.size(); i++)
                System.out.println("item " + i + ": " + conteudo.get(i));
    }

    public void editarTitulo() {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Título da lista: ");
        setTitulo(kbd.nextLine());
    }

    public void editarConteudo() {
        Scanner kbd = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Opções:");
            System.out.println("\t0 - Cancelar operação");
            System.out.println("\t1 - Criar novo item");
            System.out.println("\t2 - Remover um item");
            System.out.println("\t3 - Editar um item");

            System.out.print("Opção: ");
            opcao = kbd.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Cancelando operação...");
                    break;

                case 1:
                    System.out.println("Cadastrando item...");
                    novoItem();
                    break;

                case 2:
                    System.out.println("Removendo item...");
                    removerItem();
                    break;

                case 3:
                    System.out.println("Editando item...");
                    editarItem();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (   opcao != 0 &&
                    opcao != 1 &&
                    opcao != 2 &&
                    opcao != 3);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setConteudo(String conteudo) {
        // this.conteudo = conteudo;
    }

    public String getConteudo() {
        // return conteudo;
        return "";
    }

    public void novoItem() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Novo item: ");
        String item = kbd.nextLine();

        conteudo.add(item);
    }

    public void removerItem() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Índice do item a ser removido: ");
        int indice = kbd.nextInt();

        conteudo.remove(indice);
    }

    public void editarItem() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Índice do item a ser editado: ");
        int indice = kbd.nextInt();

        System.out.print("Novo item: ");
        String item = kbd.nextLine();

        conteudo.set(indice, item);
    }
}
