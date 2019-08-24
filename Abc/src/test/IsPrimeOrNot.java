package test;

import java.util.Scanner;

public class IsPrimeOrNot {
	boolean cond = false;

	public int check() {
		System.out.println("enter number---");
		Scanner an = new Scanner(System.in);
		int a = an.nextInt();
		if (a < 0) {
			System.out.println("please enter positive number");
		} else if (a > 0) {
			System.out.println("Number is postive:-" + isprime(a));

		}
		return 0;
	}
	public String isprime(int number) {
		int a = 0;
		String text = "";
		if (number == 1 || number == 0) {
			System.out.println("from 1---0");
			cond = false;
		} else {
			for (int i = 2; i <= number - 1; i++) {
				if (number % i == 0) {
					++a;
					break;
				}

			}

		}
		System.out.println(a);
		if (a >= 1) {
			text = "not prime";
		} else {
			text = "prime";
		}
		return text;

	}

	public static void main(String arg[]) {
		new IsPrimeOrNot().check();
	}

}
