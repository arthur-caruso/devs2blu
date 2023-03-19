package shapes;

public class Shape {

    public String name;
    public double totalArea;
    public double volume;

    public Shape() {}

    public Shape(String name) {
        this.name = name;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}