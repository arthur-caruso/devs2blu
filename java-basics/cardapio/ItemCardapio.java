package cardapio;

import java.util.ArrayList;

public interface ItemCardapio {
    void cadastrar();

    void lerNome();
    void lerIngredientes();
    void lerPreco();

    void editarNome();
    void editarIngredientes();
    void editarPreco();

    void criarIngrediente();
    void removerIngrediente();
    void editarIngrediente();

    String getNome();
    ArrayList<String> getIngredientes();
    double getPreco();

    void setNome(String nome);
    void setIngredientes(ArrayList<String> ingredientes);
    void setPreco(double preco);
}
