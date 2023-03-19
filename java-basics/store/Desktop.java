package store;

public class Desktop extends Computer {

    public String monitorRes;
    public String gpu;

    public Desktop() {}

    public Desktop( int ramSize,
                    String cpuArch,
                    double price,
                    String monitorRes,
                    String gpu) {
        super(ramSize, cpuArch, price);
        this.monitorRes = monitorRes;
        this.gpu = gpu;
    }
}