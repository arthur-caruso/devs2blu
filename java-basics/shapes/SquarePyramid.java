package shapes;

import java.lang.Math;

public class SquarePyramid extends Shape {

    public double edge;
    public double baseArea;
    public double lateralArea;

    public SquarePyramid() {
        super("Square Pyramid");
    }

    public SquarePyramid(double edge) {
        super("Square Pyramid");
        this.edge = edge;

        calcBaseArea();
        calcLateralArea();
        calcTotalArea();
        calcVolume();
    }

    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public double getLateralArea() {
        return lateralArea;
    }

    public void setLateralArea(double lateralArea) {
        this.lateralArea = lateralArea;
    }

    public void calcBaseArea() {
        setBaseArea(Math.pow(edge, 2));
    }

    public void calcLateralArea() {
        setLateralArea(2 * Math.pow(edge, 2));
    }

    public void calcTotalArea() {
        super.setTotalArea(baseArea + lateralArea);
    }

    public void calcVolume() {
        super.setVolume(Math.pow(edge, 3)/ 3.0);
    }

}