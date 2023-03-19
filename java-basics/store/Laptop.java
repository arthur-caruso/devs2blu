package store;

public class Laptop extends Computer {

    public String batteryLife;
    public String touchpadSize;

    public Laptop() {}

    public Laptop(  int ramSize,
                    String cpuArch,
                    double price,
                    String batteryLife,
                    String touchpadSize) {
        super(ramSize, cpuArch, price);
        this.batteryLife = batteryLife;
        this.touchpadSize = touchpadSize;
    }
}