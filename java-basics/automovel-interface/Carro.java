package automovel;

public class Carro implements Automovel {
    public int cavalos;
    public double velocidade;
    public String cor;
    public boolean conversivel;

    public Carro(int cavalos, double velocidade, String cor, boolean conversivel) {
        this.cavalos = cavalos;
        this.velocidade = velocidade;
        this.cor = cor;
        this.conversivel = conversivel;
    }

    public void acelerar() {
        System.out.println("vrooooOOOOM!!!");
        velocidade += 10;
    };

    public void desacelerar() {
        System.out.println("VROOOOoooom...");
        velocidade -= 10;
    };

    public void estacionar() {
        System.out.println("vroooom... *beep beep*");
        velocidade = 0;
    };
}