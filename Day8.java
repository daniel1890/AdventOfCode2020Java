import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day8 {
    ArrayList<String> regels = new ArrayList<>();
    private Scanner scan;
    private int acc;
    private int[] checkArrayPart1;

    public Day8(File file) throws FileNotFoundException {
        this.scan = new Scanner(file);
        this.acc = 0;
    }

    public void addRegels() {
        while (scan.hasNextLine()) {
            String huidigeRegel = scan.nextLine();
            regels.add(huidigeRegel);
        }
    }

    public void add0sToCheckArray() {
        checkArrayPart1 = new int[regels.size()];
        Arrays.fill(checkArrayPart1, 0);
    }

    public void runDay8() {
        // Voor elke regel in regels scan deze regel en voeg het toe aan de lijst met Strings.
        addRegels();
        add0sToCheckArray();

        // Wanneer een opdracht twee keer uitgevoerd wordt terminate het programma.
        for (int i = 0; i < regels.size(); i++) {
            checkArrayPart1[i] ++;
            if (checkArrayPart1[i] > 1) {
                System.out.println(acc);
                System.out.println(checkArrayPart1[i]);
                break;
            }

            // Split elke regel in een String array en scan de individuele elementen.
            String huidigeRegel = regels.get(i);
            String[] huidigeRegelSplit = huidigeRegel.split("");
            String[] huidigeRegelSplitAtWhiteSpace = huidigeRegel.split(" ");
            int regelHuidigGetal = Integer.parseInt(huidigeRegelSplitAtWhiteSpace[1]);

            // Wanneer de String start met "a" dan wordt acc uitgevoerd, wanneer de String start met "j" dan wordt jmp uitgevoerd.
            if (huidigeRegelSplit[0].matches("a")) {
                acc += regelHuidigGetal;
            } else if (huidigeRegelSplit[0].matches("j")) {
                i += regelHuidigGetal - 1;
            }

            // Wanneer de iterator even groot of groter dan de lengte van de regels array is print dan het antwoord van deel 2.
            if (i >= regels.size()) {
                System.out.println(acc);
            }

            System.out.println("Ans Part 1: " + huidigeRegel + " " + i);
        }
    }
}

// Split String in arraylist met regels.
// Scan per regel wat de opdracht in de regel is en voer deze uit.
// Wanneer je een regel split in een array met elke cell gevuld met 1 character van de regel dan kan je makkelijk herkennen per substring wat de opdracht hoort te zijn.
// In substring [4] van elke regel staat een + of - teken aan deze kan je dus makkelijk herkennen of acc + of - het getal moet zijn.
// Herken met substring[0] of de opdracht begint met "a" "n" of "j", corresponderend aan elk letter kan je dan makkelijk herkennen welke opdracht uitgevoert moet worden.
// Wanneer de opdracht nop is dan gebeurt er niks en leest het programma de volgende regel.
// Wanneer de opdracht acc is dan voeg of trek je van het uiteindelijke antwoord het getal af/bij.
// Wanneer de opdracht jmp is dan voer je deze pseudocode uit: "i += waarde van jmp".
// Om te zorgen dan het programma niet in een oneindige loop komt maak ik een tweede array waar elke cell start op 0.
// Wanneer er in de regels arraylist een opdracht uitgevoerd wordt zorgt het programma ervoor dat er in de check array de corresponderende cell met 1 verhoogt wordt.
// Waneer een cell in de check array 2 haalt dan beeïndigd het programma en dan wordt de waarde van acc geprint.