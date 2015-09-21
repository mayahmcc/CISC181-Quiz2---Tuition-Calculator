import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class TuitionCalculator {
	
	// Variables for the calculations
	private static Scanner sc;
	private static double r;
	private static double n;
	private static double p;
	private static double f;
	private static boolean t;

	public static void main(String[] args) {

		double fulltuition = 0;

		sc = new Scanner(System.in);

		System.out.println("What is your initial tuition?: ");
		double basetuition = sc.nextDouble();

		System.out.println("What is the percentage increase on your tuition each year?:");
		double pinc = sc.nextDouble();

		// gets the full tuition amount after four years.
		for (int i = 0; i < 4; i++) {

			fulltuition += basetuition + (basetuition * pinc);

		}

		System.out.println("Your tuiton will come out to be " + fulltuition);

		System.out.println("What is the APR on your loans?: ");
		double apr = sc.nextDouble();
		System.out.println("How many years do you plan to pay off your loans?: ");
		double yearstopay = sc.nextDouble();

		// Calculates the amount of money you have to pay each month.
		double PMT;
		r = apr;
		n = yearstopay * 12;
		p = basetuition;
		f = 0;
		t = false;
		PMT = FinanceLib.pmt(r, n, p, f, t);
		System.out.printf("You must pay $%4.2f each month for %4.2f years", PMT, yearstopay);
	}
}
