package automovel;

public abstract class Automovel {
    public int cavalos;
    public double velocidade;
    public String cor;

    public Automovel(int cavalos, double velocidade, String cor) {
        this.cavalos = cavalos;
        this.velocidade = velocidade;
        this.cor = cor;
    }

    public abstract void acelerar();
    public abstract void desacelerar();
    public abstract void estacionar();
}