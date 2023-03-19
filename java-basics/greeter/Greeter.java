package greeter;

import java.util.ArrayList;

public class Greeter {
    public void greet() {
        System.out.println("\tHello!");
    }

    public void greet(String person1) {
        System.out.println("\tHello " + person1 + "!");
    }

    public void greet(String person1, String person2) {
        System.out.println("\tHello " + person1 + " and " + person2 + "!");
    }

    public void greet(String person1, String person2, String person3) {
        System.out.println("\tHello " + person1 + ", " + person2 + " and " + person3 + "!");
    }

    public void greet(ArrayList<String> people) {
        for (int i = 0; i < people.size(); i++)
            System.out.println("\tHello " + people.get(i) + "!");
    }
}