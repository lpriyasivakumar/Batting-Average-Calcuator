package Application;

import java.text.NumberFormat;
import java.util.Scanner;
import model.Validator;

public class AvgCalculatorExtendedApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Batting Average Calculator: ");
		getBatterInfo();
	}

	private static void getBatterInfo() {
		Scanner sc = new Scanner(System.in);
		int batters;
		int atBat;		
		batters = Validator.getInt(sc, "Enter number of batters: ");			
		atBat = Validator.getIntInRange(sc,"Enter number of times at bat: ",0, 4);
		System.out.println();
		double[][] batsArray = new double[batters][atBat];
		for (int i = 0; i < batters; i++) {
			for (int j = 0; j < atBat; j++) {
				String prompt = "Enter result for at-bat"+j+"for batter"+i+":";
				batsArray[i][j] = Validator.getDouble(sc,prompt);
			}
			System.out.println();
		}
		displayStats(batsArray, batters, atBat);
		sc.close();
	}

	private static void displayStats(double[][] batsArray, int rows, int cols) {
		double battingAvg;
		double slugPercentage;
		double bases;
		double bats;
		NumberFormat num = NumberFormat.getNumberInstance();
		num.setMinimumFractionDigits(4);
		for (int i = 0; i < rows; i++) {
			bats = 0;
			bases = 0;
			for (int j = 0; j < cols; j++) {
				if (batsArray[i][j] > 0) {
					bases += batsArray[i][j];
					bats++;
				}

			}
			battingAvg = bats / cols;
			slugPercentage = bases / cols;
			System.out.println("Batting Average  for batter" + (i+1) + ": "	+ num.format(battingAvg));
			System.out.println("Slugging Percentage for batter" + (i+1) + ": " + num.format(slugPercentage));
			System.out.println();
		}

	}

}
