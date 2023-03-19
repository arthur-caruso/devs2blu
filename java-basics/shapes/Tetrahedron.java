package shapes;

import java.lang.Math;

public class Tetrahedron extends Shape {

    public double edge;
    public double lateralArea;

    public Tetrahedron() {
        super("Tetrahedron");
    }

    public Tetrahedron(double edge) {
        super("Tetrahedron");
        this.edge = edge;

        calcTotalArea();
        calcVolume();
        calcLateralArea();
    }

    public double getLateralArea() {
        return lateralArea;
    }

    public void setLateralArea(double lateralArea) {
        this.lateralArea = lateralArea;
    }

    public void calcTotalArea() {
        super.setTotalArea(Math.pow(edge, 2) * Math.sqrt(3));
    }

    public void calcVolume() {
        super.setVolume(Math.pow(edge, 3) * Math.sqrt(2) / 12.0);
    }

    public void calcLateralArea() {
        setLateralArea(1 / 4.0 * totalArea);
    }
}