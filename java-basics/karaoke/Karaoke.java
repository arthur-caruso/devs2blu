package karaoke;

import java.util.ArrayList;
import java.util.Scanner;

public class Karaoke {
    private static ArrayList<String> verses = new ArrayList<String>();

    public void setVerses(ArrayList<String> verses) {
        this.verses = verses; 
    }

    public void show() {
        for (int i = 0; i < verses.size(); i++) {
            System.out.println(verses.get(i));

            try { Thread.sleep(3000); }
            catch (InterruptedException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
    }
}
