package controler;
import java.util.Scanner;
public class heart {
public static void main(String[] args) {
Scanner s=new Scanner(System.in);
System.err.println("Enter any number : ");
int n = s.nextInt(),x=n/2;
for (int i = x; i <= n; i++){ //loop for above part of the heart
for (int j = 1; j <= n–i; j++) { //loop for first half of above part of the heart
System.out.print(" ");
}
for (int k = 1; k <= (2 * i) – 1; k++) {
System.out.print("* ");
}
for (int j = 1; j <= 2*(n – i)+1; j++) { //loop for spaces between two halves of the above part of heart
System.out.print(" ");
}
for (int k = 1; k <= (2 * i) – 1; k++) {// loop for second half of above part of the heart
System.out.print("* ");
}
System.out.println();
}
for (int i = (n*2)-1; i >=1; i–) { //loop for bottom part of the heart
for (int j = 1; j <= (n*2) – i; j++) {
System.out.print(" ");
}
for (int k = 1; k <= (2 * i) – 1; k++) {
System.out.print("* ");
}
System.out.println();
}
}
}