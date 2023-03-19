package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample{
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ArrayList<String> listaDeCompras = new ArrayList();

        for (int i = 0; i < 10; i++) {
            listaDeCompras.add(kbd.nextLine());
            System.out.println(listaDeCompras.get(i));
        }

        kbd.close();
    }
}
