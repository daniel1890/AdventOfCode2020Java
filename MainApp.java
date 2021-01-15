import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		runDay1();
		runDay5();
	}
	
	private static void runDay1() throws FileNotFoundException {
		String filePathDay1 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day1.txt";
		File file = new File(filePathDay1);
		System.out.println("~~~~~~DAY 1 ~~~~~~");
		Day1 day1 = new Day1(file);
		day1.runDay1();
	}

	private static void runDay5() throws FileNotFoundException {
		String filePathDay5 = "C:/Users/danie/eclipse-workspace/AOC2020/AOC2020-05/lijst_day5.txt";
		File file = new File(filePathDay5);
		System.out.println("~~~~~~DAY 5 ~~~~~~");
		Day5 day5 = new Day5(file);
		day5.runDay5();
	}
	

}
