import java.util.Scanner;
import java.util.ArrayList;

public class Exe9 {
    public static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String item;
        int option, index;

        do {
            System.out.println("Options:");
            System.out.println("\t0 - Exit");
            System.out.println("\t1 - Add item to list");
            System.out.println("\t2 - Remove item from list");
            System.out.println("\t3 - List items");

            System.out.print("Option: ");
            option = kbd.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;

                case 1:
                    System.out.println("Adding item to list...");
                    kbd.nextLine();

                    System.out.print("\tItem: ");
                    item = kbd.nextLine();

                    list.add(item);
                    break;

                case 2:
                    System.out.println("Removing item from list...");
                    kbd.nextLine();

                    do {
                        System.out.print("\tItem index: ");
                        index = kbd.nextInt();

                        if (index < 0 || index >= list.size())
                            System.out.println("Invalid index!");

                    } while (index < 0 || index >= list.size());

                    list.remove(index);
                    break;

                case 3:
                    System.out.println("Listing items...");

                    for (int i = 0; i < list.size(); i++)
                        System.out.printf("\t%d: %s\n", i, list.get(i));
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 0);

        kbd.close();
    }
}
