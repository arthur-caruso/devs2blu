package karaoke;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner kbd = new Scanner(System.in);
    private static Karaoke karaoke = new Karaoke();

    public static void main(String[] args) {
        ArrayList<String> verses = new ArrayList<String>();
        verses.add("Mundo Animal");
        verses.add("Comer tatu e bom");
        verses.add("que pena que da dor nas costas");
        verses.add("etc etc");

        karaoke.setVerses(verses);
        karaoke.show();
    }
}
