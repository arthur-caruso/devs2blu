package automovel;

public class Navio implements Automovel {
    public int cavalos;
    public double velocidade;
    public String cor;
    public int passageiros;

    public Navio(int cavalos, double velocidade, String cor, int passageiros) {
        this.cavalos = cavalos;
        this.velocidade = velocidade;
        this.cor = cor;
        this.passageiros = passageiros;
    }

    public void acelerar() {
        System.out.println("HOOOONK!!!");
        velocidade++;
    };

    public void desacelerar() {
        System.out.println("HOOOONK!!!");
        velocidade--;
    };

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