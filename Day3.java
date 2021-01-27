import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
	ArrayList<String> regels = new ArrayList<>();
	private Scanner scan;
	private int ansPart1;
	private long ansPart2;

	public Day3(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		this.scan = scan;
		this.ansPart1 = 0;
		this.ansPart2 = 0;
	}
	
	public void addRegels() {
		while (scan.hasNextLine()) {
			String huidigeRegel = scan.nextLine();
			regels.add(huidigeRegel);
		}
	}

	public void calcPart1(ArrayList<String> regels) {
		int pos = 0;

		for (String regel : regels) {
			String[] splitRegel = regel.split("");

			if (splitRegel[pos].contains("#")) {
				ansPart1++;
			}
			pos += 3;
			pos = pos % splitRegel.length;
		}

		System.out.println("Antwoord deel 1: " + ansPart1);
	}

	public void calcPart2(ArrayList<String> regels) {
		int pos1, pos2, pos3, pos4, pos5;
		long ansPos1, ansPos2, ansPos3, ansPos4, ansPos5;
		pos1 = pos2 = pos3 = pos4 = pos5 = 0;
		ansPos1 = ansPos2 = ansPos3 = ansPos4 = ansPos5 = 0;

		for (String regel : regels) {
			String[] splitRegel = regel.split("");

			if (splitRegel[pos1].contains("#")) {
				ansPos1++;
			}
			if (splitRegel[pos2].contains("#")) {
				ansPos2++;
			}
			if (splitRegel[pos3].contains("#")) {
				ansPos3++;
			}
			if (splitRegel[pos4].contains("#")) {
				ansPos4++;
			}
			if (splitRegel[pos5].contains("#") && regels.indexOf(regel) % 2 == 0) {
				ansPos5++;
			}
			pos1 += 1;
			pos2 += 3;
			pos3 += 5;
			pos4 += 7;
			if (regels.indexOf(regel) % 2 == 0) {
				pos5 += 1;
			}
			pos1 = pos1 % splitRegel.length;
			pos2 = pos2 % splitRegel.length;
			pos3 = pos3 % splitRegel.length;
			pos4 = pos4 % splitRegel.length;
			pos5 = pos5 % splitRegel.length;
		}
		ansPart2 = ansPos1 * ansPos2 * ansPos3 * ansPos4 * ansPos5;
		System.out.println("Antwoord deel 2: " + ansPart2);
	}

	public void runDay3() {
		// Voor elke regel in regels scan deze regel en voeg het toe aan de lijst met Strings.
		addRegels();
		calcPart1(regels);
		calcPart2(regels);
	}
}
