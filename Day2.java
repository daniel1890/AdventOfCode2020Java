import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
	ArrayList<String> regels = new ArrayList<>();
	ArrayList<Integer> regelsLo = new ArrayList<>();
	int regelsLength;
	int[][] lohiArray;
	String[] passwords;
	String[] userInput;
	int ans1;
	int ans2;
	private Scanner scan;

	public Day2(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		this.scan = scan;
		this.ans1 = 0;
		this.ans2 = 0;
	}

	public void addRegels() {
		while (scan.hasNextLine()) {
			String huidigeRegel = scan.nextLine();
			regels.add(huidigeRegel);
			regelsLength++;
		}
	}

	public void determineLoHi(String regel, int i) {
		String[] regelSplit = regel.split(" ");
		String[] lohi = regelSplit[0].split("-");
		int lo = Integer.parseInt(lohi[0]);
		int hi = Integer.parseInt(lohi[1]);
		lohiArray[i][0] = lo;
		lohiArray[i][1] = hi;
	}

	private void determinePasswords(String regel, int i) {
		String[] huidigeRegelSplit = regel.split(" ");
		String pass = huidigeRegelSplit[1].replaceFirst(":", "");
		passwords[i] = pass;
	}

	private void determineUserInput(String regel, int i) {
		String[] huidigeRegelSplit = regel.split(" ");
		String input = huidigeRegelSplit[2];
		userInput[i] = input;
	}

	private void checkPasswordsPart2(int i) {
		int lo = lohiArray[i][0];
		int hi = lohiArray[i][1];
		String pass = passwords[i];
		String[] splitRegel = userInput[i].split("", userInput[i].length());
		if (splitRegel[lo - 1].contains(pass) ^ splitRegel[hi - 1].contains(pass)) {
			ans2++;
		}
	}

	private int checkPasswordsPart1(int i) {
		int nKomtVoorIn = 0;
		String[] splitRegel = userInput[i].split("", userInput[i].length());
		for (String c : splitRegel) {
			if (c.contains(passwords[i])) {
				nKomtVoorIn++;
			}
		}

		return nKomtVoorIn;
	}

	private void veryifyPasswords() {
		int i = 0;
		lohiArray = new int[regels.size()][2];
		passwords = new String[regels.size()];
		userInput = new String[regels.size()];
		for (String regel : regels) {
			// Maak het eerste gedeelte van elke regel in regels de low bounds en het
			// laatste gedeelte de high bounds.
			determineLoHi(regel, i);
			determinePasswords(regel, i);
			determineUserInput(regel, i);
			int n = checkPasswordsPart1(i);
			checkPasswordsPart2(i);

			if (n >= lohiArray[i][0] && n <= lohiArray[i][1]) {
				ans1++;
			}

			i++;
		}

	}

	public void runDay2() {
		// Voor elke regel in regels scan deze regel en voeg het toe aan de lijst met
		// Strings.
		addRegels();
		// Voor elke regel in regels vind de lo en hi bounds voor elk passwoord.
		veryifyPasswords();
		System.out.println("Ans part 1: " + ans1);
		System.out.println("Ans Part 2: " + ans2);
	}

}
