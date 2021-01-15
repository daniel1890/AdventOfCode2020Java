import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	ArrayList<String> regels = new ArrayList<>();
	ArrayList<String[]> regelsSplit = new ArrayList<>();
	Scanner scan;
	int highestID;
	boolean[] checkIDS;
	
	public Day5(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		this.scan = scan;
		this.highestID = 0;
		this.checkIDS = new boolean[1000];
	}

	public void addRegels() {
		while (scan.hasNextLine()) {
			String huidigeRegel = scan.nextLine();
			regels.add(huidigeRegel);
		}
	}
	
	public void splitRegels() {
		for (String regel : regels) {
			regelsSplit.add(regel.split("", regel.length()));
		}
	}
	
	public void berekenSeatID() {
		for (String regel : regels) {
			int rij;
			int col;
			int seatID = 0;
			int lo = 0;
			int hi = 127;
			int lo2 = 1;
			int hi2 = 8;
			String[] huidigeRegelSplit = regel.split("", regel.length());
			
			for (String c : huidigeRegelSplit) {
				if (c.contentEquals("F")) {
					hi = (hi + lo) / 2;
				}
				if (c.contentEquals("B")) {
					lo = lo + ((hi - lo) / 2);
				}
				if (c.contentEquals("L")) {
					hi2 = ((hi2 + lo2) / 2);
				}
				if (c.contentEquals("R")) {
					lo2 = lo2 + ((hi2 - lo2) / 2);
				}

			}
			
			if (huidigeRegelSplit[6] == "F") {
				rij = lo;
			} else {
				rij = hi;
			}
			
			if (huidigeRegelSplit[huidigeRegelSplit.length - 1] == "L") {
				col = hi2;
			} else {
				col = lo2;
			}
			
			seatID = (rij * 8) + col;
			checkIDS[seatID] = true;
			if (seatID > highestID) {
				highestID = seatID;
			}

		}
	}
	
	public void printEmptyChairs() {
		for (int j = 0; j < highestID; j++) {
			boolean notEmptyChairs = j % 8 != 0;
			if (!checkIDS[j] && notEmptyChairs) {
				System.out.println(checkIDS[j] + " " + j);
			}
		}
	}
	
	public void runDay5() {
		// Voor elke regel in regels scan deze regel en voeg het toe aan de lijst met Strings.
		addRegels();
		// Per regel vind binaire seatID en deel de stoelen in zolang de regel array loopt.
		berekenSeatID();
		System.out.println("Ans part 1: " + highestID);
		// Print lege stoelen, stoel moet in het midden zijn want begin van het vliegtuig bestaat uit lege stoelen.
		printEmptyChairs();
		System.out.println("~~~~~~~~~~~~~~~~~~");
	}
	
}
