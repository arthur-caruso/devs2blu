package shapes;

import java.lang.Math;

public class SquarePrism extends Shape {

    public double edge;
    public double faceArea;
    public double baseArea;
    public double lateralArea;

    public SquarePrism() {
        super("Square Prism");
    }

    public SquarePrism(double edge) {
        super("Square Prism");
        this.edge = edge;

        calcFaceArea();
        calcBaseArea();
        calcLateralArea();
        calcTotalArea();
        calcVolume();
    }

    public double getFaceArea() {
        return faceArea;
    }

    public void setFaceArea(double faceArea) {
        this.faceArea = faceArea;
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

    public void calcFaceArea() {
        setFaceArea(Math.pow(edge, 2));
    }

    public void calcBaseArea() {
        setBaseArea((3 * Math.pow(edge, 3) * Math.sqrt(3)) / 2.0);
    }

    public void calcLateralArea() {
        setLateralArea(6 * Math.pow(edge, 2));
    }

    public void calcTotalArea() {
        super.setTotalArea(lateralArea + baseArea);
    }

    public void calcVolume() {
        super.setVolume(baseArea * edge);
    }

}