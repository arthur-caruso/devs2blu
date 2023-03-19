package mecanica;

public class Carro extends Veiculo {
    public Carro() {
        super();
    }

    public Carro(String cor, double quilometragem) {
        super(cor, quilometragem);
    }

    @Override
    public String toString() {
        return  "{\"rodas\": 4" +
                ", \"cor\": " + cor +
                ", \"quilometragem\": " + Double.toString(quilometragem) + "}";
    }
}