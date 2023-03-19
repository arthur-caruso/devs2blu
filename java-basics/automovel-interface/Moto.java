package automovel;

public class Moto implements Automovel {
    public int cavalos;
    public double velocidade;
    public String cor;

    public Moto(int cavalos, double velocidade, String cor) {
        this.cavalos = cavalos;
        this.velocidade = velocidade;
        this.cor = cor;
    }

    public void acelerar() {
        System.out.println("vrééééÉÉÉÉ!!!");
        velocidade += 20;
    };

    public void desacelerar() {
        System.out.println("VRÉÉÉÉéééé...");
        velocidade -= 20;
    };

    public void estacionar() {
        System.out.println("vréééé... *beep beep*");
        velocidade = 0;
    };

    public String empinar() {
        return "VRÉÉÉÉÉÉÉÉÉÉÉÉ";
    };
}