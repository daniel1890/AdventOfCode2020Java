import java.io.File;
import java.io.FileNotFoundException;

public class RunAllDays {

	private RunAllDays() {
		throw new IllegalStateException("Utility class");
	}


	public static void runAllDays() throws FileNotFoundException {
		// Zet test aan wanneer je 1 dag wilt testen, zet test uit wanneer je alle dagen wilt runnen.
		boolean test = true;
		
		// Wanneer je 1 functie wilt testen maak je test true en dan wordt maar 1 dag gedraait.
		if (!test) {
			runDay1();
			runDay2();
			runDay3();
			runDay5();
		}	else {
			runDay8();
		}
	}

	//  Moet dit reforormaten maar weet nog niet precies hoe.

	private static void runDay1() throws FileNotFoundException {
		String filePathDay1 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day1.txt";
		File file = new File(filePathDay1);
		System.out.println("~~~~~~DAY 1 ~~~~~~");
		Day1 day1 = new Day1(file);
		day1.runDay1();
	}

	private static void runDay2() throws FileNotFoundException {
		String filePathDay2 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day2.txt";
		File file = new File(filePathDay2);
		System.out.println("~~~~~~DAY 2 ~~~~~~");
		Day2 day2 = new Day2(file);
		day2.runDay2();
	}

	private static void runDay3() throws FileNotFoundException {
		String filePathDay3 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day3.txt";
		File file = new File(filePathDay3);
		System.out.println("~~~~~~DAY 3 ~~~~~~");
		Day3 day3 = new Day3(file);
		day3.runDay3();
	}

	private static void runDay4() throws FileNotFoundException {
		String filePathDay4 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day4.txt";
		File file = new File(filePathDay4);
		System.out.println("~~~~~~DAY 4 ~~~~~~");
		Day4 day4 = new Day4(file);
		day4.runDay4();
	}

	private static void runDay5() throws FileNotFoundException {
		String filePathDay5 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day5.txt";
		File file = new File(filePathDay5);
		System.out.println("~~~~~~DAY 5 ~~~~~~");
		Day5 day5 = new Day5(file);
		day5.runDay5();
	}

	private static void runDay6() throws FileNotFoundException {
		String filePathDay6 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day6.txt";
		File file = new File(filePathDay6);
		System.out.println("~~~~~~DAY 6 ~~~~~~");
		Day6 day6 = new Day6(file);
		day6.runDay6();
	}

	private static void runDay7() throws FileNotFoundException {
		String filePathDay7 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day7.txt";
		File file = new File(filePathDay7);
		System.out.println("~~~~~~DAY 6 ~~~~~~");
		Day7 day7 = new Day7(file);
		day7.runDay7();
	}

	private static void runDay8() throws FileNotFoundException {
		String filePathDay8 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day8.txt";
		File file = new File(filePathDay8);
		System.out.println("~~~~~~DAY 8 ~~~~~~");
		Day8 day8 = new Day8(file);
		day8.runDay8();
	}

}
