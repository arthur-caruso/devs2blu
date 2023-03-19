package store;

public class Computer {

    public int ramSize;
    public String cpuArch;
    public double price;

    public Computer() {}

    public Computer(int ramSize, String cpuArch, double price) {
        this.ramSize = ramSize;
        this.cpuArch = cpuArch;
        this.price = price;
    }
}