package automovel;

public class Navio extends Automovel {

    public int passageiros;

    public Navio(int cavalos, double velocidade, String cor, int passageiros) {
        super(cavalos, velocidade, cor);
        this.passageiros = passageiros;
    }

    @Override
    public void acelerar() {
        System.out.println("HOOOONK!!!");
        velocidade++;
    };

    @Override
    public void desacelerar() {
        System.out.println("HOOOONK!!!");
        velocidade--;
    };

    @Override
    public void estacionar() {
        System.out.println("HOOOONK!!! (parou)");
        velocidade = 0;
    };

    public void embarcar(int passageiros) {
        this.passageiros += passageiros;
    };

    public void desembarcar(int passageiros) {
        this.passageiros -= passageiros;
    };
}