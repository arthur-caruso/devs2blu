package mecanica;

public class Veiculo {
    public int rodas;
    public String cor;
    public double quilometragem;

    public Veiculo() {}

    public Veiculo(String cor, double quilometragem) {
        this.cor = cor;
        this.quilometragem = quilometragem;
    }

    public Veiculo(int rodas, String cor, double quilometragem) {
        this.rodas = rodas;
        this.cor = cor;
        this.quilometragem = quilometragem;
    }

    public String toString() {
        return  "{\"rodas\": " + Integer.toString(rodas) +
                ", \"cor\": " + cor +
                ", \"quilometragem\": " + Double.toString(quilometragem) + "}";
    }
}