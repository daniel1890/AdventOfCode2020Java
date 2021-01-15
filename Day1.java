import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	ArrayList<String> regels = new ArrayList<>();
	private Scanner scan;
	private int ans1;
	private int ans2;

	public Day1(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		this.scan = scan;
	}
	
	public void addRegels() {
		while (scan.hasNextLine()) {
			String huidigeRegel = scan.nextLine();
			regels.add(huidigeRegel);
		}
	}
	
	public void calc2020() {
		for (String getal1 : regels) {
			for (String getal2 : regels) {
				int nummer1 = Integer.parseInt(getal1);
				int nummer2 = Integer.parseInt(getal2);
				if (nummer1 + nummer2 == 2020) {
					ans1 = nummer1 * nummer2;
				}
				for (String getal3 : regels) {
					int nummer3 = Integer.parseInt(getal3);
					if (nummer1 + nummer2 + nummer3 == 2020) {
						ans2 = nummer1 * nummer2 * nummer3;
					}
				}
			}
		}
	}

	public void runDay1() {
		// Voor elke regel in regels scan deze regel en voeg het toe aan de lijst met Strings.
		addRegels();
		// Bereken 2020 met 2 en met 3 getallen en vermenigvuldig daarna de resultaten met elkaar.
		calc2020();
		System.out.println("Ans part1: " + ans1);
		System.out.println("Ans part2: " + ans2);
	}
	
}
