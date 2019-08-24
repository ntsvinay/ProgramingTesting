package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumOfTwoNumber {
	public static void main(String arg[]) {
		try {
		Scanner scn = new Scanner(System.in);
		int number = scn.nextInt();
		System.out.println("number 1" + number);
		int number2 = scn.nextInt();
		System.out.println("number 1" + number2);
		System.out.println(new SumOfTwoNumber().sum(number, number2));
		}
		catch(InputMismatchException e)
		{
			System.out.println("error pls enter numric value");
		}
	}

	public int sum(int a, int b) {
		return a + b;
	}

}
