package automovel;

public class Carro extends Automovel {
    public boolean conversivel;

    public Carro(int cavalos, double velocidade, String cor, boolean conversivel) {

        super(cavalos, velocidade, cor);
        this.conversivel = conversivel;

    }

    @Override
    public void acelerar() {
        System.out.println("vrooooOOOOM!!!");
        velocidade += 10;
    };

    @Override
    public void desacelerar() {
        System.out.println("VROOOOoooom...");
        velocidade -= 10;
    };

    @Override
    public void estacionar() {
        System.out.println("vroooom... *beep beep*");
        velocidade = 0;
    };
}