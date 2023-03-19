package automovel;

public class Moto extends Automovel {
    public Moto(int cavalos, double velocidade, String cor) {
        super(cavalos, velocidade, cor);
    }

    @Override
    public void acelerar() {
        System.out.println("vrééééÉÉÉÉ!!!");
        velocidade += 20;
    };

    @Override
    public void desacelerar() {
        System.out.println("VRÉÉÉÉéééé...");
        velocidade -= 20;
    };

    @Override
    public void estacionar() {
        System.out.println("vréééé... *beep beep*");
        velocidade = 0;
    };

    public String empinar() {
        return "VRÉÉÉÉÉÉÉÉÉÉÉÉ";
    };
}