package nota;

import java.util.Scanner;

public class Desenho implements Anotavel {
    public String titulo;
    public String conteudo;

    public Desenho() {
        cadastrar();
    }

    public void cadastrar() {
        editarTitulo();
        editarConteudo();
    }

    public void lerTitulo() {
        System.out.println("\"" + titulo + "\"" + " [Desenho]");
    }

    public void lerConteudo() {
        System.out.println("\"" + conteudo + "\"" + " [Link do desenho]");
    }

    public void editarTitulo() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Título do desenho: ");
        setTitulo(kbd.nextLine());
    }

    public void editarConteudo() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Link do desenho: ");
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
