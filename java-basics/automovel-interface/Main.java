package automovel;

public class Main {
    public static void main(String[] args) {
        Automovel carro = new Carro(300, 0, "azul", true);
        Automovel moto = new Moto(200, 25, "vermelho");
        Automovel navio = new Navio(1000, 37.0, "preto", 0);

        carro.acelerar();
        carro.desacelerar();
        carro.estacionar();

        moto.acelerar();
        moto.desacelerar();
        moto.estacionar();

        navio.acelerar();
        navio.desacelerar();
        navio.estacionar();
    }
}