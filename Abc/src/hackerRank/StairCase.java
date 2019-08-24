package hackerRank;

import java.util.Scanner;

public class StairCase {
	public static void main(String arg[]) {
		Scanner asc = new Scanner(System.in);
		int vlaue = asc.nextInt();
		new StairCase().print1(vlaue);
		new StairCase().print2(vlaue);
	}

	public void print1(int val) {
		int a = 0, b;
		for (int i = 0; i <= val; i++) {
			a = a + 1;

			for (int j = 0; j <= val; j++) {
				if ((i + j) > val) {
					System.out.print("#");

				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}

	}

	public void print2(int val) {
		int a = 0;
		for (int i = 0; i < val; i++) {
			a = a + 1;
			for (int j = 0; j < a; j++)
				System.out.print("#");
			System.out.println();
		}
	}
}
