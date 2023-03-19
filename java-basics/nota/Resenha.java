package nota;

import java.util.Scanner;

public class Resenha implements Anotavel {
    public String titulo;
    public String referencia;
    public String conteudo;

    public Resenha() {
        cadastrar();
    }

    public void cadastrar() {
        editarTitulo();
        editarConteudo();
    }

    public void lerTitulo() {
        System.out.println("\"" + titulo + "\"" + " [Resenha]");
    }

    public void lerConteudo() {
        System.out.println(conteudo);
    }

    public void editarTitulo() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Título da resenha: ");
        setTitulo(kbd.nextLine());
    }

    public void editarConteudo() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Conteúdo da resenha: ");
        setConteudo(kbd.nextLine());
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
