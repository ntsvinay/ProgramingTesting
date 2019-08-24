package test;

import java.util.Arrays;
import java.util.Scanner;

public class Hourglass {
	public void change(int[][] arr) {

	}

	public void hourglasstar(int num)
	{
		int i,j,k;
		for(i=0;i<=num;i++)
		{
			for(j=i;j<=i;j++)
			{
				System.out.println("");
				System.out.println("#");
			}
				
		}
	}
	public static void main(String arg[]) {
		int[][] abc = new int[6][6];
		System.out.println(abc.length);
		Scanner nn = new Scanner(System.in);
		
		for (int i = 0; i <= abc.length - 1; i++) {
			for (int j = 0; j <= abc[i].length - 1; j++) {
				int as = abc[i].length - 1;
				System.out.println("enter next value" + as + j + i);
				abc[i][j] = nn.nextInt();
			}
		}
		for (int i = 0; i <= abc.length - 1; i++) {
			for (int j = 0; j <= abc.length - 1; j++) {
				System.out.print(abc[i][j]);
			}
			System.out.println("");
		}
		for (int[] a : abc) {
			System.out.println(Arrays.toString(a));
		}
		// new Hourglass().change(abc);

	}

}
