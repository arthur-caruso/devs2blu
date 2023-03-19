public class Circle {
        double PI = 3.141590;
        double radius;
        String color;

    public Circle(double r, String color) {
        this.radius = r;
        this.color = color;
    }

    public double getArea() {
        return this.PI * this.radius * this.radius;
    }
}
