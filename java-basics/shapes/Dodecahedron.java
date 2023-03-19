package shapes;

import java.lang.Math;

public class Dodecahedron extends Shape {

    public double edge;

    public Dodecahedron() {
        super("Dodecahedron");
    }

    public Dodecahedron(double edge) {
        super("Dodecahedron");
        this.edge = edge;

        calcTotalArea();
        calcVolume();
    }

    public void calcTotalArea() {
        super.setTotalArea(3 * Math.sqrt(25) + 10 * Math.sqrt(5) * Math.pow(edge, 2));
    }

    public void calcVolume() {
        super.setVolume(1 / 4.0 * (15 + 7 * Math.sqrt(5)) * Math.pow(edge, 3));
    }
}