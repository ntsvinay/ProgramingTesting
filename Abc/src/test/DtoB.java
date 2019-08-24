package test;

import java.util.Scanner;

public class DtoB {
	public static void main(String arg[]) {
		StringBuffer na = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i, a = 0, c;
		int[] number = new int[100];
		while (num != 0) {
			number[a] = num % 2;
			na.append(number[a]);
			System.out.println("anmk:-" + number[a]);
			num = num / 2;
			a++;
		}
		System.out.println("aknc:-" + na);

	}

}
