package test;
import java.util.Scanner;
class CheckPrime
{
public static void main(String[] args)
{
System.out.println("Enter the number to be checked");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
CheckPrime ob=new CheckPrime();
ob.check(n);
}

void check(int n)
{
if(n<0)
System.out.println("Please enter a positive integer");
else
prime(n);
}
void prime(int n)
{
int c=0;
for(int i=2;i<n;i++)
{
if(n%i==0)
++c;

}
if(c>=1)
System.out.println("Entered number is not a prime number");
else
System.out.println("Entered number is a prime number");
}
}