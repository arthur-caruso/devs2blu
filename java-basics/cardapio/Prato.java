package cardapio;

import java.util.Scanner;
import java.util.ArrayList;

public class Prato implements ItemCardapio {
    private Scanner kbd = new Scanner(System.in);
    private String nome;
    private ArrayList<String> ingredientes = new ArrayList<String>();
    private double preco;

    public Prato() {
        cadastrar();
    }

    public void cadastrar() {
        editarNome();
        editarIngredientes();
        editarPreco();
    }

    public void lerNome() {
        System.out.println("\"" + nome + "\"");
    }

    public void lerIngredientes() {
        if (ingredientes.size() == 0)
            System.out.println("nenhum ingrediente cadastrado!");
        else
            for (int i = 0; i < ingredientes.size(); i++)
                System.out.println("ingrediente " + i + ": " + ingredientes.get(i));
    }

    public void lerPreco() {
        System.out.println("\"" + preco + "\"" + " [preço]");
    }

    public void editarNome() {
        System.out.print("nome do prato: ");
        nome = kbd.nextLine();
    }

    public void editarIngredientes() {
        int opcao;

        while (true) {
            System.out.println("Opções:");
            System.out.println("\t0 - cancelar operação");
            System.out.println("\t1 - criar ingrediente");
            System.out.println("\t2 - remover um ingrediente");
            System.out.println("\t3 - editar um ingrediente");

            System.out.print("opção: ");
            opcao = kbd.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("cancelando operação...");
                    break;

                case 1:
                    System.out.println("criando ingrediente...");
                    criarIngrediente();
                    break;

                case 2:
                    System.out.println("removendo ingrediente...");
                    removerIngrediente();
                    break;

                case 3:
                    System.out.println("editando ingrediente...");
                    editarIngrediente();
                    break;

                default:
                    System.out.println("opção inválida!");
                    break;
            }

            if (opcao == 0 || opcao == 1 || opcao == 2 || opcao == 3)
                break;
        }
    }

    public void editarPreco() {
        System.out.print("preço do prato: ");
        preco = kbd.nextDouble();
    }

    public void criarIngrediente() {
            System.out.print("criar ingrediente: ");
            ingredientes.add(kbd.nextLine());
        }

    public void removerIngrediente() {
        System.out.print("índice do ingrediente a ser removido: ");
        ingredientes.remove(kbd.nextInt());
    }

    public void editarIngrediente() {
        System.out.print("índice do ingrediente a ser editado: ");
        int indice = kbd.nextInt();

        System.out.print("novo item: ");
        ingredientes.set(indice, kbd.nextLine());
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setIngredientes(ArrayList<String> ingredientes) { this.ingredientes = ingredientes; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getNome() { return nome; }
    public ArrayList<String> getIngredientes() { return ingredientes; }
    public double getPreco() { return preco; }
}
