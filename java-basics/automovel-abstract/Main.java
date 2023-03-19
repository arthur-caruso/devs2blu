package automovel;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro(300, 0, "azul", true);
        Moto moto = new Moto(200, 25, "vermelho");
        Navio navio = new Navio(1000, 37.0, "preto", 0);

        carro.acelerar();
        carro.desacelerar();
        carro.estacionar();

        moto.acelerar();
        moto.desacelerar();
        moto.estacionar();
        moto.empinar();

        navio.embarcar(10);
        navio.acelerar();
        navio.desacelerar();
        navio.estacionar();
        navio.desembarcar(10);
    }
}