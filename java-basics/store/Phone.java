package store;

public class Phone extends Computer {
    public String cameraRes;
    public boolean hasBiometrics;

    public Phone() {}

    public Phone(   int ramSize,
                    String cpuArch,
                    double price,
                    String cameraRes,
                    boolean hasBiometrics) {
        super(ramSize, cpuArch, price);
        this.cameraRes = cameraRes;
        this.hasBiometrics = hasBiometrics;
    }
}