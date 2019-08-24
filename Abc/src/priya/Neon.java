package priya;
import java.math.*;
import java.util.Scanner;
public class Neon {
	public static void main(String[]ar) {
		Scanner s = new Scanner(System.in);
		System.out.println("Write an Integer number");
		int num=s.nextInt();
		int i=num*num;
int sum=0;
while(i>0) {
	sum=sum+i%10;
	i=i/10;
}
if(sum==num) {
	System.out.println("this is Neon Number");
}
else {
	System.out.println("neon nhi h");
}
		
	}

}
