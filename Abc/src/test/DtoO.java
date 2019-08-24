package test;

import java.util.Scanner;

public class DtoO {
	public void deciToO()
	{
		Scanner sc=new Scanner(System.in);
		int[] n=new int[100];
		int num=sc.nextInt();
		int a=0;
		while(num!=0)
		{
			n[a]=num%8;
			a++;
			num=num/8;
		}
		for(int j=a-1;j>=0;j--)
		{
			System.out.print("value:---"+n[j]);
		}
	}
	public void deciToHexa()
	{
		Scanner sc=new Scanner(System.in);
		int[] n=new int[100];
		int num=sc.nextInt();
		int a=0;
		while(num!=0)
		{
			n[a]=num%16;
			a++;
			num=num/16;
		}
		for(int j=a-1;j>=0;j--)
		{
			System.out.print(n[j]);
		}
	}
	public void bTd()
	{
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int a=0, b=1;
		int dnum=0;
		while(num!=0)
		{
			a=num%10;
			num=num/10;
			dnum+=a*b;
			b=b*2;
		}
		System.out.println(dnum);
		
	}
	public static void main(String arg[])
	{
		new DtoO().bTd();
	}

}
