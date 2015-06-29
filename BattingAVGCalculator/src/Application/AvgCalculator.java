package Application;

import java.text.NumberFormat;
import java.util.Scanner;
import model.Validator;


public class AvgCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NumberFormat num = NumberFormat.getNumberInstance();
		num.setMinimumFractionDigits(4);
		getBatterInfo(sc, num);		
		sc.close();
	}

	private static void getBatterInfo(Scanner sc, NumberFormat num) {
		String choice;
		int atBat;
		double bases;
		double bats;
		System.out.println("Welcome to the Batting Average Calculator: ");
		do {
			bases = 0;
			bats = 0;			
			atBat = Validator.getIntInRange(sc, "Enter number of times at bat: ", 0, 4);
			double[] batsArray = new double[atBat];
			for (int i = 0; i < atBat; i++) {				
				batsArray[i] = Validator.getDouble(sc,"Results for at-bat" + i + ": " );
				if (batsArray[i] > 0) {
					bases += batsArray[i];
					bats++;
				}
			}
			displayStats(num, atBat, bases, bats);
			choice = Validator.getChoice(sc, "Another batter: (y/n):", "y","n");
		} while (choice.equalsIgnoreCase("y"));
	}

	private static void displayStats(NumberFormat num, int atBat, double bases,
			double bats) {
		double battingAvg;
		double slugPercentage;
		battingAvg = bats / atBat;
		slugPercentage = bases / atBat;
		System.out.println("Batting Average: " + num.format(battingAvg));
		System.out
				.println("Slugging Percentage: " + num.format(slugPercentage));		
	}

}
