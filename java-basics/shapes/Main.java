package shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        System.out.println("3D Shape Calculator");

        double edge;
        char option;
        do {
            System.out.println("Options:");
            System.out.println("\t0 - Exit");
            System.out.println("\t1 - Cube");
            System.out.println("\t2 - Dodecahedron");
            System.out.println("\t3 - Tetrahedron");
            System.out.println("\t4 - Square Pyramid");
            System.out.println("\t5 - Square Prism");

            System.out.print("Option: ");
            option = kbd.nextLine().charAt(0);

            System.out.print("\tEdge length: ");
            edge = kbd.nextDouble();

            switch (option) {
                case '0':
                    System.out.println("Exiting program...");
                    break;

                case '1':
                    System.out.print("\tCube edge length: ");
                    edge = kbd.nextDouble();

                    Cube cube = new Cube(edge);

                    System.out.println("\tTotal area of Cube: " + cube.getTotalArea());
                    System.out.println("\tTotal volume of Cube: " + cube.getVolume());
                    break;

                case '2':
                    System.out.print("\tDodecahedron edge length: ");
                    edge = kbd.nextDouble();

                    Dodecahedron dodecahedron = new Dodecahedron(edge);

                    System.out.println("\tTotal area of Dodecahedron: " + dodecahedron.getTotalArea());
                    System.out.println("\tTotal volume of Dodecahedron: " + dodecahedron.getVolume());
                    break;
                
                case '3':
                    System.out.print("\tTetrahedron edge length: ");
                    edge = kbd.nextDouble();

                    Tetrahedron tetrahedron = new Tetrahedron(edge);

                    System.out.println("\tTotal area of Tetrahedron: " + tetrahedron.getTotalArea());
                    System.out.println("\tTotal volume of Tetrahedron: " + tetrahedron.getVolume());
                    break;

                case '4':
                    System.out.print("\tSquare Pyramid edge length: ");
                    edge = kbd.nextDouble();

                    SquarePyramid pyramid = new SquarePyramid(edge);

                    System.out.println("\tTotal area of Square Pyramid: " + pyramid.getTotalArea());
                    System.out.println("\tTotal volume of Square Pyramid: " + pyramid.getVolume());
                    break;

                case '5':
                    System.out.print("\tSquare Prism edge length: ");
                    edge = kbd.nextDouble();

                    SquarePrism prism = new SquarePrism(edge);

                    System.out.println("\tTotal area of Square Prism: " + prism.getTotalArea());
                    System.out.println("\tTotal volume of Square Prism: " + prism.getVolume());
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != '0');
        kbd.close();
    }
}
