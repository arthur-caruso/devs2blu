package nota;

public interface Anotavel {
    void cadastrar();

    void lerTitulo();
    void editarTitulo();

    void setTitulo(String titulo);
    String getTitulo();

    void lerConteudo();
    void editarConteudo();

    void setConteudo(String conteudo);
    String getConteudo();
}
