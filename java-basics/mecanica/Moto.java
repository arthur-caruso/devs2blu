package mecanica;

public class Moto extends Veiculo {
    public Moto() {
        super();
    }

    public Moto(String cor, double quilometragem) {
        super(cor, quilometragem);
    }

    @Override
    public String toString() {
        return  "{\"rodas\": 2" +
                ", \"cor\": " + cor +
                ", \"quilometragem\": " + Double.toString(quilometragem) + "}";
    }
}