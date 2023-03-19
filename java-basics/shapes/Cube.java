package shapes;

import java.lang.Math;

public class Cube extends Shape {

    public double edge;
    public double lateralArea;

    public Cube() {
        super("Cube");
    }

    public Cube(double edge) {
        super("Cube");
        this.edge = edge;

        calcLateralArea();
        calcTotalArea();
        calcVolume();
    }

    public double getLateralArea() {
        return lateralArea;
    }

    public void setLateralArea(double lateralArea) {
        this.lateralArea = lateralArea;
    }

    public void calcLateralArea() {
        setLateralArea(4 * Math.pow(edge, 2));
    }

    public void calcTotalArea() {
        super.setTotalArea(6 * Math.pow(edge, 2));
    }

    public void calcVolume() {
        super.setVolume(Math.pow(edge, 3));
    }

}